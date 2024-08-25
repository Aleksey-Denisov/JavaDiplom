package ru.gbwh.db.service.alert;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.alert.StringAlert;
import ru.gbwh.db.repository.alert.StringAlertRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class StringAlertService {
    private final StringAlertRepository repository;

    // Сохранение изменений алерта
    public void save(StringAlert stringAlert) {
        repository.save(stringAlert);
    }

    // Получение алерта по идентификаторам точки данных
    public StringAlert getAlert(Long idDp, Long idElement) {
        return repository.getStringAlertByDpe(idDp, idElement);
    }

    // Получение всех алертов
    public List<StringAlert> findAll() {
        return repository.findAll();
    }
}
