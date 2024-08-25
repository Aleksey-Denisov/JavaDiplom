package ru.gbwh.db.service.original;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.original.StringSig;
import ru.gbwh.db.repository.original.StringSigRepository;

@Service
@AllArgsConstructor
public class StringSigService {
    private final StringSigRepository repository;

    // Сохранение записи
    public StringSig save(StringSig stringSig) {
        return repository.save(stringSig);
    }

    // Получение последней
    public StringSig getLast(Long idDp, Long idStructType) {
        return repository.getLastSig(idDp, idStructType);
    }
}
