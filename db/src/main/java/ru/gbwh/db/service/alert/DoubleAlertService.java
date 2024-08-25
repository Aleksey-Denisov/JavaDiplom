package ru.gbwh.db.service.alert;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.alert.DoubleAlert;
import ru.gbwh.db.repository.alert.DoubleAlertRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DoubleAlertService {
    private final DoubleAlertRepository repository;

    // Сохранение изменений алерта
    public void save(DoubleAlert doubleAlert) {
        repository.save(doubleAlert);
    }

    // Получение алерта по идентификаторам точки данных
    public List<DoubleAlert> getAlert(Long idDp, Long idElement) {
        return repository.getDoubleAlertByDpe(idDp, idElement);
    }

    // Получение всех алертов
    public List<DoubleAlert> findAll() {
        return repository.findAll();
    }

    public void deleteAllByIdDPE(Long idDp, Long idElement) {
        repository.deleteAllByIdDPE(idDp, idElement);
    }
}
