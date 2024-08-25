package ru.gbwh.db.models.alert;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IntAlert extends AlertSignal {
    // Поле значение для сравнения
    @Column(nullable = false)
    private Integer value = 0;
    // Поле определяющее операцию сравнения
    @Column(nullable = false)
    private AlertOperation operation;
    // Поля для текста аларма
    private String alarmText;
    private String installedText;
    private String removedText;
    // Поле для цвета
    @Column(nullable = false)
    private AlertColor colorAlert;
    // Поле указывающее в какой позиции находится данный алерт
    @Column(nullable = false)
    private Integer idPosition = 1;

    public IntAlert(Long idDp, Long idElement) {
        this.idDp = idDp;
        this.idElement = idElement;
    }
}
