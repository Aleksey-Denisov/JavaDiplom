package ru.gbwh.db.repository.alertTable;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbwh.db.models.alertTable.IntAlertTable;

public interface IntAlertTableRepository extends JpaRepository<IntAlertTable, Long> {
}
