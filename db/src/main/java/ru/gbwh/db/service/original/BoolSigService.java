package ru.gbwh.db.service.original;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.original.BoolSig;
import ru.gbwh.db.repository.original.BoolSigRepository;
import ru.gbwh.db.service.alertTable.BoolAlertTableService;

@Service
@AllArgsConstructor
public class BoolSigService {
    private final BoolSigRepository repository;
    private final BoolAlertTableService service;

    // Сохранение записи
    public BoolSig save(BoolSig boolSig) {
        new Thread(() -> {
            service.save(boolSig);
        }).start();
        return repository.save(boolSig);
    }

    // Получение последней
    public BoolSig getLast(Long idDp, Long idStructType) {
        return repository.getLastSig(idDp, idStructType);
    }
}
