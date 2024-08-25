package ru.gbwh.db.models.original;

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
public class BoolSig  extends  SignalFactory{
    @Column(columnDefinition = "boolean")
    private Boolean signalValue;

    // Простой конструктор для загрузки на страницу
    public BoolSig(Long idDP, Long idStructType) {
        this.idDP = idDP;
        this.idStructType = idStructType;
    }
}
