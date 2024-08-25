package ru.gbwh.db.service.original;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.original.IntSig;
import ru.gbwh.db.repository.original.IntSigRepository;

@Service
@AllArgsConstructor
public class IntSigService {
    private final IntSigRepository repository;

    // Сохранение записи
    public IntSig save(IntSig intSig) {
        return repository.save(intSig);
    }

    // Получение последней
    public IntSig getLast(Long idDp, Long idStructType) {
        return repository.getLastSig(idDp, idStructType);
    }
}
