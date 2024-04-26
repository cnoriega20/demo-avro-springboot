package com.tn.demoavro.s.service;

import com.tn.demoavro.s.mappers.StudentMapper;
import com.tn.demoavro.s.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaProducerService {
    @Value("${spring.kafka.topic.name}")
    private String topicName;


    private final KafkaTemplate<String, com.tn.springboot.kafka.model.Student> kafkaTemplate;
    private final StudentMapper studentMapper;

    public KafkaProducerService(KafkaTemplate<String, com.tn.springboot.kafka.model.Student> kafkaTemplate, StudentMapper studentMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.studentMapper = studentMapper;

    }

    public CompletableFuture<String> sendMessage(com.tn.springboot.kafka.model.Student avroStudent){
        return CompletableFuture.supplyAsync(() -> {
            try {

                // Convert Avro student to POJO student using the mapper
                Student pojoStudent = studentMapper.convertAvroToStudent(avroStudent);

                //Log the contents of the Student object
                log.info("Sending message to Kafka: {}", pojoStudent);

                // Send message asynchronously
                kafkaTemplate.send(topicName, avroStudent).get();
                return "Success";
            } catch (Exception e) {
                throw new RuntimeException("Failed to send message to Kafka", e);
            }
        });
    }
}
