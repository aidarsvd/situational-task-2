package kg.aidar.datadynamo.consumer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.aidar.datadynamo.consumer.entities.WeatherDataEntity;
import kg.aidar.datadynamo.consumer.models.WeatherDataModel;
import kg.aidar.datadynamo.consumer.repositories.WeatherDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherDataServiceImpl implements WeatherDataService {

    private final WeatherDataRepository weatherDataRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void save(String o) {
        try {
            WeatherDataModel weatherData = objectMapper.readValue(o, WeatherDataModel.class);
            weatherDataRepository.save(new WeatherDataEntity(weatherData));
        } catch (IOException e) {
            log.error("Error", e);
        }
    }
}