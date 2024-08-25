package ru.gbwh.db.repository.alert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.alert.BoolAlert;

public interface BoolAlertRepository extends JpaRepository<BoolAlert, Long> {

    @Query("select ba from BoolAlert ba where ba.idDp=?1 and ba.idElement=?2")
    BoolAlert getBoolAlertByDpe(Long idDp, Long idElement);
}
