package ru.gbwh.db.models.common;

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
public class NumCommon extends CommonSignal {
    // У числовых типов хранится ещё единица измерения
    private String unit;

    // Простой конструктор для загрузки на страницу
    public NumCommon(Long idDp, Long idElement) {
        this.idDp = idDp;
        this.idElement = idElement;
    }
}
