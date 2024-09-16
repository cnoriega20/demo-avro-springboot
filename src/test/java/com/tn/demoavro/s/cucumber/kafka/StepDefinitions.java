package com.tn.demoavro.s.cucumber.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tn.demoavro.s.generated.AvroStudent;
import com.tn.demoavro.s.mappers.StudentMapper;
import com.tn.demoavro.s.model.Student;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Component
public class StepDefinitions {
    @Autowired
    private TestKafkaProducer testKafkaProducer;

    @Autowired
    private TestKafkaConsumer testKafkaConsumer;

    private Student pojoStudent;
    private AvroStudent avroStudent;

    @Autowired
    private  StudentMapper studentMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Given("a student with data from {string}")
    public void a_student_with_data_from(String jsonFilePath) throws Exception {
        //Load student data from JSON and map to POJO Student
        File jsonFile = new File(jsonFilePath);

        // Deserialize JSON into POJO Student object
        pojoStudent = objectMapper.readValue(jsonFile, Student.class);

        // Map POJO Student to Avro-generated Student
        avroStudent = studentMapper.convertStudentToAvro(pojoStudent);
    }

    @When("the student data is sent to Kafka")
    public void the_student_data_is_sent_to_kafka() {
        // Use the TestKafkaProducer to send the AvroStudent to the topic
        testKafkaProducer.sendStudentMessage(pojoStudent); // Mapping happens inside TestKafkaProducer
    }

    @Then("the student name should be {string}")
    public void the_student_name_should_be(String studentName) throws InterruptedException {
        // Consume the message from Kafka
        AvroStudent consumedStudent = testKafkaConsumer.consumeStudentMessage();

        // Check if the consumed student's name matches the expected name
        assertEquals(studentName, consumedStudent.getStudentName().toString());
    }
}
