package kg.aidar.datadynamo.producer.models;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProduceData {

    String region;
    double temperature;
    double heatIndex;
    double heatStressIndex;
    double windChillIndex;

}
