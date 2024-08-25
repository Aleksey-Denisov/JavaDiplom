package ru.gbwh.db.models.original;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class IntSig extends SignalFactory{
    private Integer signalValue;

    // Простой конструктор для загрузки на страницу
    public IntSig(Long idDP, Long idStructType) {
        this.idDP = idDP;
        this.idStructType = idStructType;
    }
}
