package kg.aidar.datadynamo.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "weather_data_queue";

    @Bean
    public Queue weatherDataQueue() {
        return new Queue(QUEUE_NAME, true);
    }

}
