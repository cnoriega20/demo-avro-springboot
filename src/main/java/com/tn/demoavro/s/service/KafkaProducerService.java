package com.tn.demoavro.s.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaProducerService {
    @Value("${kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public CompletableFuture<RecordMetadata> sendMessage(String message){
        return CompletableFuture.supplyAsync(() -> {
            try{
                //Send message asynchronously
                return kafkaTemplate.send(topicName, message).get().getRecordMetadata();
            } catch(Exception e){
                throw new RuntimeException("Failed to send message to Kafka", e);
            }
        });
    }
}
