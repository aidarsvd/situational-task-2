package kg.aidar.datadynamo.producer.services;

import org.springframework.web.multipart.MultipartFile;

public interface DatasetService {

    void upload(MultipartFile multipartFile);

}
