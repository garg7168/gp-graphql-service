
package com.citi.argentina.ip.gpservice.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.model.Response;
import com.citi.argentina.ip.gpservice.util.GraphQlUtility;
import com.citi.argentina.ip.gpservice.util.ResponseMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.ExecutionResult;

@Component
public class GPRequestConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(GPRequestConsumer.class);
	@Autowired
	private GraphQlUtility graphQlUtility;
	@Autowired
	ResponseMapping responseMapping;
	@Autowired
	ObjectMapper objectMapper;
	Response response = null;
	@Autowired
	private KafkaTemplate<Object, Object> replyTemplate;
	@Value("${citi.config.kafka.account.response.topic}")
	private String getResTopic;

	@KafkaListener(topics = "${citi.config.kafka.account.request.topic}", containerFactory = "requestListenerContainerFactory")
	public void receiveGetRequest(ConsumerRecord<Object, Object> payload, @Header(KafkaHeaders.CORRELATION_ID) byte[] correlation) {

		String query = convertToAccount((JsonNode) payload.value());
		LOGGER.debug("GPREAD : Query is" + query);
		ExecutionResult result = graphQlUtility.getGraphQL().execute(query);
		response = responseMapping.resultToResponse(result);
		LOGGER.debug("GPREAD : response is" + response);
		ProducerRecord<Object, Object> record = new ProducerRecord<>(getResTopic, objectMapper.valueToTree(response));
		record.headers().add(KafkaHeaders.CORRELATION_ID, correlation);
		replyTemplate.send(record);
	}

	String convertToAccount(JsonNode object) {

		try {
			return objectMapper.treeToValue(object, String.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}