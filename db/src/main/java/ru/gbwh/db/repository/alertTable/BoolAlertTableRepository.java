package ru.gbwh.db.repository.alertTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.alertTable.BoolAlertTable;

public interface BoolAlertTableRepository extends JpaRepository<BoolAlertTable, Long> {

    @Query("select bt from BoolAlertTable bt where bt.idDp=?1 and bt.idElement=?2 order by bt.timeAlarm desc limit 1")
    BoolAlertTable getLastAlert(Long idDp, Long idElement);
}
