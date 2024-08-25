package ru.gbwh.db.models.alert;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListIntAlerts {
    // Сущность для загрузки на страницу всех алертов
    private final List<IntAlert> alerts;
    private Long idDP;
    private Long idElement;

    public ListIntAlerts(Long idDP, Long idElement) {
        alerts = new ArrayList<>();
        this.idDP = idDP;
        this.idElement = idElement;
    }
    public void setAlerts(IntAlert intAlert) {
        this.alerts.add(intAlert);
    }
    public void setAlerts(List<IntAlert> alerts) {
        this.alerts.addAll(alerts);
    }


}
