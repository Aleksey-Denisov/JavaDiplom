package ru.gbwh.db.service.common;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.common.WordCommon;
import ru.gbwh.db.repository.common.WordCommonRepository;

@Service
@AllArgsConstructor
public class WordCommonService {
    private final WordCommonRepository repository;

    // Сохранение записей
    public WordCommon save(WordCommon wordCommon) {
        return repository.save(wordCommon);
    }

    // Получение записи по идентификаторам из репозитория
    public WordCommon getWordCommon(Long idDp, Long idElement) {
        return repository.getWordCommon(idDp, idElement);
    }
}
