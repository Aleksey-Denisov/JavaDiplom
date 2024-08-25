package ru.gbwh.db.service.alert;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.alert.IntAlert;
import ru.gbwh.db.repository.alert.IntAlertRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class IntAlertService {
    private final IntAlertRepository repository;

    // Сохранение изменений алерта
    public void save(IntAlert intAlert) {
        repository.save(intAlert);
    }

    // Получение алерта по идентификаторам точки данных
    public List<IntAlert> getAlert(Long idDp, Long idElement) {
        return repository.getIntAlertByDpe(idDp, idElement);
    }

    // Получение всех алертов
    public List<IntAlert> findAll() {
        return repository.findAll();
    }

    public void deleteAllByIdDPE(Long idDp, Long idElement) {
        repository.deleteAllByIdDPE(idDp, idElement);
    }
}
