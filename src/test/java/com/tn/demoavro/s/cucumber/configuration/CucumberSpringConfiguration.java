package com.tn.demoavro.s.cucumber.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"${app.kafka.topic}"})
@ActiveProfiles("test")
public class CucumberSpringConfiguration {
}
