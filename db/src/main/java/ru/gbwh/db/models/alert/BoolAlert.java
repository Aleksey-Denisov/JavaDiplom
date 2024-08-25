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
public class BoolAlert extends AlertSignal{
    // Поле определяющее, когда будет сработка аларма, по умолчанию на правду
    @Column(columnDefinition = "boolean")
    private Boolean value = true;
    // Поля основного текста аларма и составляющих при установке или снятии
    private String alarmText;
    private String installedText;
    private String removedText;
    // Поле для цвета
    @Column(nullable = false)
    private AlertColor colorAlert;

    public BoolAlert(Long idDp, Long idElement) {
        this.idDp = idDp;
        this.idElement = idElement;
    }
}
