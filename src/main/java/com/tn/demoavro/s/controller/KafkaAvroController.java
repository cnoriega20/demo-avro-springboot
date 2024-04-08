package com.tn.demoavro.s.controller;

import com.tn.demoavro.s.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avro-kafka/students")
public class KafkaAvroController {
    private KafkaProducerService kafkaProducerService;

    public KafkaAvroController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping(value = "/send")
    public String kafkaMessage(@RequestBody com.tn.demoavro.s.avro.model.Student message){
        kafkaProducerService.sendMessage(message);
        return "Success";
    }

}
