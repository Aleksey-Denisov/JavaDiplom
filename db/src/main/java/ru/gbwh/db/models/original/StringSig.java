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
public class StringSig extends SignalFactory{
    private String signalValue;

    // Простой конструктор для загрузки на страницу
    public StringSig(Long idDP, Long idStructType) {
        this.idDP = idDP;
        this.idStructType = idStructType;
    }
}
