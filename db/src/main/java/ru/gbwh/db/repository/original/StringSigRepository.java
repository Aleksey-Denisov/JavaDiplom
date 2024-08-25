package ru.gbwh.db.repository.original;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.original.StringSig;

public interface StringSigRepository extends JpaRepository<StringSig, Long> {

    // Выгрузка по идентификаторам точки и элемента
    // Получение последнего значения
    @Query("select s from StringSig s where s.idDP=?1 and s.idStructType=?2 order by s.id desc limit 1")
    StringSig getLastSig(Long idDP, Long idStructType);
}
