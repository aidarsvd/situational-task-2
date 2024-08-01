package kg.aidar.datadynamo.producer.processors;

import kg.aidar.datadynamo.producer.models.WeatherData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RequiredArgsConstructor
@Slf4j
public class DatasetProcessor implements Runnable {

    private final MultipartFile file;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run() {
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream());
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("timestamp", "region", "temperature", "humidity", "wind_speed", "pressure", "dew_point", "precipitation", "uv_index", "cloud_cover", "visibility", "radiation").withSkipHeaderRecord())) {
            for (CSVRecord csvRecord : csvParser) {
                WeatherData weatherData = new WeatherData(csvRecord);
                RecordProcessor recordProcessor = new RecordProcessor(weatherData, rabbitTemplate);
                recordProcessor.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
