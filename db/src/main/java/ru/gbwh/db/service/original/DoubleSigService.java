package ru.gbwh.db.service.original;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.original.DoubleSig;
import ru.gbwh.db.repository.original.DoobleSigRepository;

@Service
@AllArgsConstructor
public class DoubleSigService {
    private final DoobleSigRepository repository;

    // Сохранение записи
    public DoubleSig save(DoubleSig doubleSig) {
        return repository.save(doubleSig);
    }

    // Получение последней
    public DoubleSig getLast(Long idDp, Long idStructType) {
        return repository.getLastSig(idDp, idStructType);
    }
}
