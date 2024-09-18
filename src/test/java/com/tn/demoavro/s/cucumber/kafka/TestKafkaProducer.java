package com.tn.demoavro.s.cucumber.kafka;

import com.tn.demoavro.s.generated.AvroStudent;
import com.tn.demoavro.s.mappers.StudentMapper;
import com.tn.demoavro.s.model.Student;
import com.tn.demoavro.s.serializer.AvroSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class TestKafkaProducer {

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Autowired
    private StudentMapper studentMapper;

    @Value("${app.kafka.topic}")
    private String topicName;

    public void sendStudentMessage(Student student) {

        // Map POJO Student to Avro Student
        AvroStudent avroStudent = studentMapper.convertStudentToAvro(student);

        // Log the Avro student being sent
        log.info("Sending student to Kafka: {}", avroStudent);

        // Produce the Avro message
        Map<String, Object> producerProps = KafkaTestUtils.producerProps(embeddedKafkaBroker);
        Producer<String, AvroStudent> producer = new KafkaProducer<>(producerProps,
                new StringSerializer(), new AvroSerializer());

        producer.send(new ProducerRecord<>(topicName, avroStudent.getStudentId().toString(), avroStudent), (metadata, exception) ->{
            if (exception != null) {
                log.error("Error sending student to Kafka: {}", exception.getMessage());
            } else {
                log.info("Successfully sent student to Kafka: {}", metadata.toString());
            }
        });
        producer.flush();
        producer.close();

    }

}
