package ru.gbwh.db.models.alert;

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
public class StringAlert extends AlertSignal {
    // Поле определяющее на какой тест будет сработка
    private String value;
    // Поле определяющее, когда будет сработка аларма, по умолчанию на правду
    @Column(columnDefinition = "boolean")
    private Boolean options = true;
    // Поля основного текста аларма и составляющих при установке или снятии
    private String alarmText;
    private String installedText;
    private String removedText;
    // Поле для цвета
    @Column(nullable = false)
    private AlertColor colorAlert;
}
