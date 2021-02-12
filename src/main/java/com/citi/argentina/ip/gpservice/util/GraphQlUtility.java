package com.citi.argentina.ip.gpservice.util;

import java.io.File;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.datafetcher.AccountDataFetcher;
import com.citi.argentina.ip.gpservice.datafetcher.AllAccountsDataFetcher;
import com.citi.argentina.ip.gpservice.datafetcher.CreateAccountDataFetcher;
import com.citi.argentina.ip.gpservice.datafetcher.DeleteAccountDataFetcher;
import com.citi.argentina.ip.gpservice.datafetcher.UpdateAccountDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQlUtility {

	//@Value("classpath:account.graphql")
	//private Resource schemaResource;
	@Autowired
	private ResourceLoader resourceLoader;
	private GraphQL graphQL;
	@Autowired
	private AllAccountsDataFetcher allAccountsDataFetcher;
	@Autowired
	private AccountDataFetcher accountDataFetcher;
	@Autowired
	private CreateAccountDataFetcher createAccountDataFetcher;
	@Autowired
	private UpdateAccountDataFetcher updateAccountDataFetcher;
	@Autowired
	private DeleteAccountDataFetcher deleteAccountDataFetcher;

	@PostConstruct
	public void loadSchema() throws Exception {

		/*File schemas = schemaResource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);*/
		InputStream schemaInput = resourceLoader.getResource("classpath:account.graphql").getInputStream();
		File InputFile = File.createTempFile("account", ".graphql");
		FileUtils.copyInputStreamToFile(schemaInput, InputFile);
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(InputFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	public RuntimeWiring buildRuntimeWiring() throws Exception{

		return RuntimeWiring.newRuntimeWiring()
		                    .type("Query",
		                          typeWiring -> typeWiring.dataFetcher("allAccounts", allAccountsDataFetcher).dataFetcher("account", accountDataFetcher))
		                    .type("Mutation",
		                          typeWiring -> typeWiring.dataFetcher("createAccount", createAccountDataFetcher)
		                                                  .dataFetcher("updateAccount", updateAccountDataFetcher)
		                                                  .dataFetcher("deleteAccount", deleteAccountDataFetcher))
		                    .build();
	}

	public GraphQL getGraphQL() {

		return graphQL;
	}
}
