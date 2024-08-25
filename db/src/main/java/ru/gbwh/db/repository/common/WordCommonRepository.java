package ru.gbwh.db.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.common.WordCommon;

public interface WordCommonRepository extends JpaRepository<WordCommon, Long> {
    // Выгрузка по идентификаторам точки и элемента
    @Query("select w from WordCommon w where w.idDp=?1 and w.idElement=?2")
    WordCommon getWordCommon(Long idDp, Long idElement);
}
