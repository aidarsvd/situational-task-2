package kg.aidar.datadynamo.producer.models;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.apache.commons.csv.CSVRecord;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherData {
    String timestamp;
    String region;
    double temperature;
    int humidity;
    double windSpeed;
    int pressure;
    double dewPoint;
    double precipitation;
    int uvIndex;
    int cloudCover;
    int visibility;
    double radiation;

    public WeatherData(CSVRecord csvRecord) {
        this.timestamp = csvRecord.get("timestamp");
        this.region = csvRecord.get("region");
        this.temperature = Double.parseDouble(csvRecord.get("temperature"));
        this.humidity = Integer.parseInt(csvRecord.get("humidity"));
        this.windSpeed = Double.parseDouble(csvRecord.get("wind_speed"));
        this.pressure = Integer.parseInt(csvRecord.get("pressure"));
        this.dewPoint = Double.parseDouble(csvRecord.get("dew_point"));
        this.precipitation = Double.parseDouble(csvRecord.get("precipitation"));
        this.uvIndex = Integer.parseInt(csvRecord.get("uv_index"));
        this.cloudCover = Integer.parseInt(csvRecord.get("cloud_cover"));
        this.visibility = Integer.parseInt(csvRecord.get("visibility"));
        this.radiation = Double.parseDouble(csvRecord.get("radiation"));
    }

    public double calculateHeatIndex() {
        double e = 6.11 * Math.pow(10.0, 7.5 * temperature / (237.3 + temperature)) * humidity / 100;
        return temperature + 0.5555 * (e - 10.0);
    }

    public double calculateHeatStressIndex() {
        double e = 6.11 * Math.pow(10.0, 7.5 * temperature / (237.3 + temperature)) * humidity / 100;
        return temperature + 0.348 * e - 0.7 * windSpeed + 0.7 * radiation - 4.25;
    }

    public double calculateWindChillIndex() {
        if (temperature > 10 || windSpeed < 1.3) {
            return temperature; // WCI only applicable for T <= 10°C and ws > 1.3 m/s
        }
        return 13.12 + 0.6215 * temperature - 11.37 * Math.pow(windSpeed, 0.16)
                + 0.3965 * temperature * Math.pow(windSpeed, 0.16);
    }

}
