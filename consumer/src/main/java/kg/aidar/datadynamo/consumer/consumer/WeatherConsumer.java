package kg.aidar.datadynamo.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeatherConsumer {

    @RabbitListener(queues = "weather_data_queue")
    public void receiveMessage(String message) {
        log.info("Received data: {}", message);
    }

}
