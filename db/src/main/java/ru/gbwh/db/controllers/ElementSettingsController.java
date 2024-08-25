package ru.gbwh.db.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gbwh.db.models.TypeSignal;
import ru.gbwh.db.models.alert.BoolAlert;
import ru.gbwh.db.models.alert.IntAlert;
import ru.gbwh.db.models.alert.ListIntAlerts;
import ru.gbwh.db.models.common.NumCommon;
import ru.gbwh.db.models.common.WordCommon;
import ru.gbwh.db.models.original.BoolSig;
import ru.gbwh.db.models.original.DoubleSig;
import ru.gbwh.db.models.original.IntSig;
import ru.gbwh.db.models.original.StringSig;
import ru.gbwh.db.service.DataPointService;
import ru.gbwh.db.service.StructTypeService;
import ru.gbwh.db.service.alert.BoolAlertService;
import ru.gbwh.db.service.alert.DoubleAlertService;
import ru.gbwh.db.service.alert.IntAlertService;
import ru.gbwh.db.service.alert.StringAlertService;
import ru.gbwh.db.service.common.NumCommonService;
import ru.gbwh.db.service.common.WordCommonService;

import java.util.Objects;

@Controller
@AllArgsConstructor
public class ElementSettingsController {
    private final DataPointService      dataPointService;
    private final StructTypeService     structTypeService;
    private final NumCommonService      numCommonService;
    private final WordCommonService     wordCommonService;
    private final BoolAlertService      boolAlertService;
    private final DoubleAlertService    doubleAlertService;
    private final IntAlertService       intAlertService;
    private final StringAlertService    stringAlertService;

    // Загрузка общей страницы свойств элементов точек данных
    @GetMapping("/elements/{idDp}/{idDpe}/{typeSignal}")
    public String getOriginal(@PathVariable("typeSignal") TypeSignal typeSignal,
                              @PathVariable("idDp") Long idDp,
                              @PathVariable("idDpe") Long idElement,
                              Model model) {
        String dp = dataPointService.findById(idDp).getDataPointName();
        String element = structTypeService.find(idElement).getNameElement();
        // В зависимости от типа данных будет получена модель для отображения на странице
        switch (typeSignal) {
            case INT -> {
                model.addAttribute("signal", new IntSig(idDp, idElement));
                model.addAttribute("common", Objects.requireNonNullElseGet(numCommonService.getNumCommon(idDp, idElement),
                        () -> new NumCommon(idDp, idElement)));
                ListIntAlerts intAlerts = new ListIntAlerts(idDp, idElement);
                if(intAlertService.getAlert(idDp, idElement).isEmpty())
                    intAlerts.setAlerts(new IntAlert(idDp, idElement));
                else
                    intAlerts.setAlerts(intAlertService.getAlert(idDp, idElement));
                model.addAttribute("alert", intAlerts);
            }
            case BOOL -> {
                model.addAttribute("signal", new BoolSig(idDp, idElement));
                model.addAttribute("common", Objects.requireNonNullElseGet(wordCommonService.getWordCommon(idDp, idElement),
                        () -> new WordCommon(idDp, idElement)));
                model.addAttribute("alert", Objects.requireNonNullElseGet(boolAlertService.getAlert(idDp, idElement),
                        () -> new BoolAlert(idDp, idElement)));
            }
            case DOUBLE -> {
                model.addAttribute("signal", new DoubleSig(idDp, idElement));
                model.addAttribute("common", Objects.requireNonNullElseGet(numCommonService.getNumCommon(idDp, idElement),
                        () -> new NumCommon(idDp, idElement)));
            }
            case STRING -> {
                model.addAttribute("signal", new StringSig(idDp, idElement));
                model.addAttribute("common", Objects.requireNonNullElseGet(wordCommonService.getWordCommon(idDp, idElement),
                        () -> new WordCommon(idDp, idElement)));
            }
        }
        model.addAttribute("typeSignal", typeSignal);
        model.addAttribute("dp", dp);
        model.addAttribute("element", element);
        return "element-settings";
    }
}
