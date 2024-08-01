package kg.aidar.datadynamo.producer.controller;

import kg.aidar.datadynamo.producer.services.DatasetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/dataset")
@RequiredArgsConstructor
public class DatasetController {

    private final DatasetService datasetService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDataset(@RequestParam("file") MultipartFile file) {
        datasetService.upload(file);
        return ResponseEntity.ok().body("OK!");
    }

}
