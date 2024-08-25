package ru.gbwh.db.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.common.NumCommon;

public interface NumCommonRepository extends JpaRepository<NumCommon, Long> {
    // Выгрузка по идентификаторам точки и элемента
    @Query("select n from NumCommon n where n.idDp=?1 and n.idElement=?2")
    NumCommon getNumCommon(Long idDp, Long idElement);
}
