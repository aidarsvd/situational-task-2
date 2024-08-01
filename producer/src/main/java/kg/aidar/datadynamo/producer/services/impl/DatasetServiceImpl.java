package kg.aidar.datadynamo.producer.services.impl;

import kg.aidar.datadynamo.producer.processors.DatasetProcessor;
import kg.aidar.datadynamo.producer.services.DatasetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatasetServiceImpl implements DatasetService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void upload(MultipartFile multipartFile) {
        DatasetProcessor datasetProcessor = new DatasetProcessor(multipartFile, rabbitTemplate);
        datasetProcessor.run();
    }
}
