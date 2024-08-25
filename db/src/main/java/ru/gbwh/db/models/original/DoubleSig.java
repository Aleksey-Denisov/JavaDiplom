package ru.gbwh.db.models.original;

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
public class DoubleSig  extends SignalFactory {
    private Double signalValue;

    // Простой конструктор для загрузки на страницу
    public DoubleSig(Long idDP, Long idStructType) {
        this.idDP = idDP;
        this.idStructType = idStructType;
    }
}
