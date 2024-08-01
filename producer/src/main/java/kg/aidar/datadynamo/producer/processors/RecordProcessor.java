package kg.aidar.datadynamo.producer.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.aidar.datadynamo.producer.models.ProduceData;
import kg.aidar.datadynamo.producer.models.WeatherData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;

import static kg.aidar.datadynamo.producer.config.RabbitConfig.QUEUE_NAME;


@Slf4j
@RequiredArgsConstructor
public class RecordProcessor implements Runnable {

    private final WeatherData weatherData;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run() {
        ProduceData produceData = ProduceData.builder()
                .region(weatherData.getRegion())
                .temperature(weatherData.getTemperature())
                .heatIndex(weatherData.calculateHeatIndex())
                .heatStressIndex(weatherData.calculateHeatStressIndex())
                .windChillIndex(weatherData.calculateWindChillIndex())
                .build();
        ObjectMapper om = new ObjectMapper();
        try {
            rabbitTemplate.convertAndSend(QUEUE_NAME, om.writeValueAsString(produceData));
        } catch (IOException ioException) {
            log.error("Error", ioException);
        }
    }
}
