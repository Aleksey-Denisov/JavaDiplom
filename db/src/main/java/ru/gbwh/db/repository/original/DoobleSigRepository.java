package ru.gbwh.db.repository.original;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.original.DoubleSig;

public interface DoobleSigRepository extends JpaRepository<DoubleSig, Long> {

    // Выгрузка по идентификаторам точки и элемента
    // Получение последнего значения
    @Query("select d from DoubleSig d where d.idDP=?1 and d.idStructType=?2 order by d.id desc limit 1")
    DoubleSig getLastSig(Long idDP, Long idStructType);
}
