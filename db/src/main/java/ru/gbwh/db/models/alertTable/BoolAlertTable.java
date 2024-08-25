package ru.gbwh.db.models.alertTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoolAlertTable extends AlertTable {
    @Column(columnDefinition = "boolean")
    private Boolean value;
}
