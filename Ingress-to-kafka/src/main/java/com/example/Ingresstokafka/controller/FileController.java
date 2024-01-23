package com.example.Ingresstokafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileController {

    @Value("${kafka.topic}")
    private String kafkaTopic;
    @Autowired
    private final com.example.Ingresstokafka.service.KafkaProducerService kafkaProducerService;

    public FileController(com.example.Ingresstokafka.service.KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String content = new String(file.getBytes());
            kafkaProducerService.sendMessage(kafkaTopic, content);
            return ResponseEntity.ok("File uploaded and sent to Kafka!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading file");
        }
    }
}
