package ru.gbwh.db.repository.alertTable;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbwh.db.models.alertTable.DoubleAlertTable;

public interface DoubleAlertTableRepository extends JpaRepository<DoubleAlertTable,Long> {
}
