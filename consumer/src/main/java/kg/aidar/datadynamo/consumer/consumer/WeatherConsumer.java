package kg.aidar.datadynamo.consumer.consumer;

import kg.aidar.datadynamo.consumer.services.WeatherDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherConsumer {

    private final WeatherDataService weatherDataService;

    @RabbitListener(queues = "weather_data_queue")
    public void receiveMessage(String message) {
        log.info("Received data: {}", message);
        weatherDataService.save(message);
    }

}
