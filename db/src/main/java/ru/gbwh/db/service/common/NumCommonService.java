package ru.gbwh.db.service.common;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.common.NumCommon;
import ru.gbwh.db.repository.common.NumCommonRepository;

@Service
@AllArgsConstructor
public class NumCommonService {
    private NumCommonRepository repository;

    // Сохранение записей
    public NumCommon save(NumCommon numCommon) {
        return repository.save(numCommon);
    }

    // Получение записи по идентификаторам из репозитория
    public NumCommon getNumCommon(Long idDp, Long idElement) {
        return repository.getNumCommon(idDp, idElement);
    }
}
