package kg.aidar.datadynamo.consumer.repositories;

import kg.aidar.datadynamo.consumer.entities.WeatherDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherDataEntity, Long> {
}
