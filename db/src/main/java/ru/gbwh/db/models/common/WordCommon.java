package ru.gbwh.db.models.common;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class WordCommon extends CommonSignal {
    public WordCommon() {
    }

    // Простой конструктор для загрузки на страницу
    public WordCommon(Long idDp, Long idElement) {
        this.idDp = idDp;
        this.idElement = idElement;
    }
}
