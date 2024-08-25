package ru.gbwh.db.models.alert;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDoubleAlerts {
    // Сущность для загрузки на страницу всех алертов
    private List<DoubleAlert> alerts;
    private Long idDP;
    private Long idElement;

    public ListDoubleAlerts(Long idDP, Long idElement) {
        alerts = new ArrayList<>();
        this.idDP = idDP;
        this.idElement = idElement;
    }
    public void setAlerts(DoubleAlert doubleAlert) {
        this.alerts.add(doubleAlert);
    }
    public void setAlerts(List<DoubleAlert> alerts) {
        this.alerts.addAll(alerts);
    }
}
