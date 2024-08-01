package kg.aidar.datadynamo.consumer.models;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherDataModel {

    String region;

    Double temperature;

    Double heatIndex;

    Double heatStressIndex;

    Double windChillIndex;

}
