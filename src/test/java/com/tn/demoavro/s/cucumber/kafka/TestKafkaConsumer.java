package com.tn.demoavro.s.cucumber.kafka;

import com.tn.demoavro.s.generated.AvroStudent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Component
public class TestKafkaConsumer {

    @Value("${app.kafka.topic}")
    private String topic;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    private final BlockingQueue<ConsumerRecord<String, AvroStudent>> consumerRecords = new LinkedBlockingQueue<>();

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, AvroStudent> record,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        consumerRecords.add(record);
    }

    // Method to retrieve the consumed AvroStudent from the queue
    public AvroStudent consumeStudentMessage() throws InterruptedException {
        // Adjust timeout if necessary
        ConsumerRecord<String, AvroStudent> record = consumerRecords.poll(10, TimeUnit.SECONDS);
        if (record != null) {
            return record.value();
        } else {
            throw new RuntimeException("No message consumed within the timeout period");
        }

    }
}
