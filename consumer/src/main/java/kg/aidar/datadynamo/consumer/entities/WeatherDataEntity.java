package kg.aidar.datadynamo.consumer.entities;

import jakarta.persistence.*;
import kg.aidar.datadynamo.consumer.models.WeatherDataModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "data_dynamo_weather_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String region;

    Double temperature;

    Double heatIndex;

    Double heatStressIndex;

    Double windChillIndex;

    public WeatherDataEntity(WeatherDataModel weatherData) {
        this.id = null;
        this.region = weatherData.getRegion();
        this.temperature = weatherData.getTemperature();
        this.heatIndex = weatherData.getHeatIndex();
        this.heatStressIndex = weatherData.getHeatStressIndex();
        this.windChillIndex = weatherData.getWindChillIndex();
    }
}
