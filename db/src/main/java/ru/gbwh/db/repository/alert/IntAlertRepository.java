package ru.gbwh.db.repository.alert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.alert.IntAlert;

import java.util.List;

public interface IntAlertRepository extends JpaRepository<IntAlert, Long> {

    @Query("select ia from IntAlert ia where ia.idDp=?1 and ia.idElement=?2")
    List<IntAlert> getIntAlertByDpe(Long idDp, Long idElement);

    @Query("delete from IntAlert ia where ia.idDp=?1 and ia.idElement=?2")
    void deleteAllByIdDPE(Long idDp, Long idElement);
}
