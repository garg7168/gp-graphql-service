 package com.citi.argentina.ip.gpservice;

 import org.junit.jupiter.api.Test;
 import org.junit.runner.RunWith;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
 import org.springframework.test.context.ActiveProfiles;
 import org.springframework.test.context.junit4.SpringRunner;

 @SpringBootTest
 @RunWith(SpringRunner.class)
 @ActiveProfiles({"com.citi.argentina.ip.gpservice", "com.citi.payment"})
 class GpServiceApplicationTests {

 @Test void contextLoads() { }

 }
