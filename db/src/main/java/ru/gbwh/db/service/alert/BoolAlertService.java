package ru.gbwh.db.service.alert;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.alert.BoolAlert;
import ru.gbwh.db.repository.alert.BoolAlertRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class BoolAlertService {
    private final BoolAlertRepository repository;

    // Сохранение изменений алерта
    public BoolAlert save(BoolAlert boolAlert) {
        return repository.save(boolAlert);
    }

    // Получение алерта по идентификаторам точки данных
    public BoolAlert getAlert(Long idDp, Long idElement) {
        return repository.getBoolAlertByDpe(idDp, idElement);
    }

    // Получение всех алертов
    public List<BoolAlert> findAll() {
        return repository.findAll();
    }
}
