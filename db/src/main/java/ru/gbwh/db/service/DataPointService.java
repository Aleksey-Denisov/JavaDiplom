package ru.gbwh.db.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.DataPoint;
import ru.gbwh.db.repository.DataPointRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DataPointService {
    private final DataPointRepository dataPointRepository;

    // Сохранение точки данных
    public DataPoint save(DataPoint dataPoint) {
        return dataPointRepository.save(dataPoint);
    }

    // Получение всех точек
    public List<DataPoint> findAll() {
        return dataPointRepository.findAll();
    }

    // Удаление точки данных
    public void delete(Long id) {
        dataPointRepository.deleteById(id);
    }

    // Получение точки по идентификатору
    public DataPoint findById(Long id) {
        return dataPointRepository.findById(id).orElse(null);
    }
}
