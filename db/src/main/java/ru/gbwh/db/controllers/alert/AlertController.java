package ru.gbwh.db.controllers.alert;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gbwh.db.models.alert.BoolAlert;
import ru.gbwh.db.models.alert.ListDoubleAlerts;
import ru.gbwh.db.models.alert.ListIntAlerts;
import ru.gbwh.db.models.alert.StringAlert;
import ru.gbwh.db.service.alert.BoolAlertService;
import ru.gbwh.db.service.alert.DoubleAlertService;
import ru.gbwh.db.service.alert.IntAlertService;
import ru.gbwh.db.service.alert.StringAlertService;

@Controller
@AllArgsConstructor
public class AlertController {
    private final BoolAlertService      boolAlertService;
    private final DoubleAlertService    doubleAlertService;
    private final IntAlertService       intAlertService;
    private final StringAlertService    stringAlertService;

    @PostMapping("/alertBool")
    public synchronized String saveAlertBool(BoolAlert boolAlert) {
        boolAlertService.save(boolAlert);
        return "redirect:/elements/" + boolAlert.getIdDp() + "/" + boolAlert.getIdElement() + "/BOOL";
    }

    @PostMapping("/alertInt")
    public synchronized String saveAlertInt(ListIntAlerts alerts) {
        intAlertService.deleteAllByIdDPE(alerts.getIdDP(), alerts.getIdElement());
        alerts.getAlerts().forEach(intAlertService::save);
        return "redirect:/elements/" + alerts.getIdDP() + "/" + alerts.getIdElement() + "/INT";
    }

    @PostMapping("/alertDouble")
    public synchronized String saveAlertDouble(ListDoubleAlerts alerts) {
        doubleAlertService.deleteAllByIdDPE(alerts.getIdDP(), alerts.getIdElement());
        alerts.getAlerts().forEach(doubleAlertService::save);
        return "redirect:/elements/" + alerts.getIdDP() + "/" + alerts.getIdElement() + "/DOUBLE";
    }

    @PostMapping("/alertString")
    public synchronized String saveAlertString(StringAlert stringAlert) {
        stringAlertService.save(stringAlert);
        return "redirect:/elements/" + stringAlert.getIdDp() + "/" + stringAlert.getIdElement() + "/STRING";
    }
}
