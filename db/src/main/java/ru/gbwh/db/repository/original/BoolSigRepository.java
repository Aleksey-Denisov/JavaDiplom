package ru.gbwh.db.repository.original;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.original.BoolSig;

public interface BoolSigRepository extends JpaRepository<BoolSig, Long> {
    // Выгрузка по идентификаторам точки и элемента
    // Получение последнего значения
    @Query("select b from BoolSig b where b.idDP=?1 and b.idStructType=?2 order by b.id desc limit 1")
    BoolSig getLastSig(Long idDP, Long idStructType);
}
