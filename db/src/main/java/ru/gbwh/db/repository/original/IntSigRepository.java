package ru.gbwh.db.repository.original;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.original.IntSig;

public interface IntSigRepository extends JpaRepository<IntSig, Long> {

    // Выгрузка по идентификаторам точки и элемента
    // Получение последнего значения
    @Query("select i from IntSig i where i.idDP=?1 and i.idStructType=?2 order by i.id desc limit 1")
    IntSig getLastSig(Long idDP, Long idStructType);
}
