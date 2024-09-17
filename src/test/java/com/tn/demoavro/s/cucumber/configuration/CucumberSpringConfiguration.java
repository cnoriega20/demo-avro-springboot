package com.tn.demoavro.s.cucumber.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@CucumberContextConfiguration
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics={"student-topic"})
public class CucumberSpringConfiguration {
}
