
package com.tn.demoavro.s.controller;


import com.tn.demoavro.s.generated.AvroStudent;
import com.tn.demoavro.s.mappers.StudentMapper;
import com.tn.demoavro.s.model.Student;
import com.tn.demoavro.s.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/avro-kafka/students")
public class KafkaAvroController {
    private KafkaProducerService kafkaProducerService;
    private final StudentMapper studentMapper;

    public KafkaAvroController(KafkaProducerService kafkaProducerService, StudentMapper studentMapper) {
        this.kafkaProducerService = kafkaProducerService;
        this.studentMapper = studentMapper;
    }

    @PostMapping(value = "/send")
    public CompletableFuture<String> kafkaMessage(@RequestBody Student message) {
        AvroStudent avroStudent = studentMapper.convertStudentToAvro(message);
        return kafkaProducerService.sendMessage(avroStudent);

    }

}

