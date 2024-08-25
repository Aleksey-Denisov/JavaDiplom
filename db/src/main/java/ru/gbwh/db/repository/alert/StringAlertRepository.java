package ru.gbwh.db.repository.alert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.alert.StringAlert;

public interface StringAlertRepository extends JpaRepository<StringAlert, Long> {

    @Query("select sa from StringAlert sa where sa.idDp=?1 and sa.idElement=?2")
    StringAlert getStringAlertByDpe(Long idDp, Long idElement);
}
