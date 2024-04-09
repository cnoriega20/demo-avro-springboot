package com.tn.demoavro.s.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.util.Utf8;
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
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper; // Jackson ObjectMapper for serialization


    public KafkaProducerService(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

    public CompletableFuture<RecordMetadata> sendMessage(com.tn.demoavro.s.avro.model.Student message){
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Convert Student to GenericRecord
                GenericRecord genericRecord = convertStudentToGenericRecord(message);// Convert Student to GenericRecord

                // Serialize GenericRecord to JSON string
                String jsonMessage = objectMapper.writeValueAsString(genericRecord);

                // Send message asynchronously
                return kafkaTemplate.send(topicName, jsonMessage).get().getRecordMetadata();
            } catch (Exception e) {
                throw new RuntimeException("Failed to send message to Kafka", e);
            }
        });
    }

    private GenericRecord convertStudentToGenericRecord(com.tn.demoavro.s.avro.model.Student message){
        Schema schema = com.tn.demoavro.s.avro.model.Student.getClassSchema();

        // Create a new GenericRecord instance using the schema
        GenericRecord genericRecord = new GenericData.Record(schema);

        //  Set values for each field in the GenericRecord
        genericRecord.put("studentName", new Utf8(message.getStudentName().toString()));
        genericRecord.put("studentId", new Utf8(message.getStudentId().toString()));
        genericRecord.put("age", message.getAge());
        return genericRecord;
    }
}
