package com.tn.demoavro.s.integration;

import com.tn.demoavro.s.cucumber.configuration.CucumberSpringConfiguration;
import com.tn.demoavro.s.cucumber.kafka.TestKafkaConsumer;
import com.tn.demoavro.s.cucumber.kafka.TestKafkaProducer;
import com.tn.demoavro.s.generated.AvroStudent;
import com.tn.demoavro.s.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = CucumberSpringConfiguration.class)
@EmbeddedKafka(partitions = 1, topics = {"student-topic"})
public class KafkaIntegrationTest {
    @Autowired
    private TestKafkaProducer testKafkaProducer;

    @Autowired
    private TestKafkaConsumer testKafkaConsumer;

    @Test
    public void testKafkaIntegration() throws Exception {
        Student student = Student.builder()
                .studentId("1")
                .studentName("TestStud")
                .build();

        testKafkaProducer.sendStudentMessage(student);
        AvroStudent receivedStudent = testKafkaConsumer.consumeStudentMessage();
        assertEquals(student.getStudentName(), receivedStudent.getStudentName());

    }
}
