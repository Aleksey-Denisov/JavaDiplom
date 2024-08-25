package ru.gbwh.db.repository.alert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.alert.DoubleAlert;

import java.util.List;

public interface DoubleAlertRepository extends JpaRepository<DoubleAlert, Long> {

    @Query("select da from DoubleAlert da where da.idDp=?1 and da.idElement=?2")
    List<DoubleAlert> getDoubleAlertByDpe(Long idDp, Long idElement);
    @Query("delete from DoubleAlert ia where ia.idDp=?1 and ia.idElement=?2")
    void deleteAllByIdDPE(Long idDp, Long idElement);
}
