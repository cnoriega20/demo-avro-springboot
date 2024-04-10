package com.tn.demoavro.s.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tn.demoavro.s.avro.model.Student;

@Service
@Slf4j
public class KafkaAvroListener {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.topic.consumer}")
    public void listen(ConsumerRecord<String, Student> record){
        log.info("Received Message:");
        log.info("Topic: {}", record.topic());
        log.info("Partition: {}", record.partition());
        log.info("Offset: {}", record.offset());
        log.info("Key: {}", record.key());
        log.info("Value: {}", record.value());
    }
}
