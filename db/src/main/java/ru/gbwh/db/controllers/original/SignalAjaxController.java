package ru.gbwh.db.controllers.original;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.gbwh.db.configuration.OriginalConfiguration;
import ru.gbwh.db.models.TypeSignal;

@RestController
@AllArgsConstructor
public class SignalAjaxController {
    private final OriginalConfiguration originalConfiguration;

    // Для отображения текущих значений в точках БД
    @RequestMapping(value="/event/{dpe}/{typeSignal}", method= RequestMethod.POST)
    public Object getEventCount(@PathVariable("typeSignal") TypeSignal typeSignal,
                                                @PathVariable("dpe") String dpe) {
        switch (typeSignal) {
            case INT -> {
                return originalConfiguration.getIntOriginal().get(dpe);
            }
            case BOOL -> {
                return originalConfiguration.getBoolOriginal().get(dpe);
            }
            case DOUBLE -> {
                return originalConfiguration.getDoubleOriginal().get(dpe);
            }
            case STRING -> {
                return originalConfiguration.getStringOriginal().get(dpe);
            }
            default -> {
                return null;
            }
        }
    }
}
