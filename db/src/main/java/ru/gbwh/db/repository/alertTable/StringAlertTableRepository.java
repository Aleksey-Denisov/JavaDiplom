package ru.gbwh.db.repository.alertTable;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbwh.db.models.alertTable.StringAlertTable;

public interface StringAlertTableRepository extends JpaRepository<StringAlertTable, Long> {
}
