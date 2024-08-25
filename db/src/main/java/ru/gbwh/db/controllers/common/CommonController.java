package ru.gbwh.db.controllers.common;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gbwh.db.models.TypeSignal;
import ru.gbwh.db.models.common.NumCommon;
import ru.gbwh.db.models.common.WordCommon;
import ru.gbwh.db.service.common.NumCommonService;
import ru.gbwh.db.service.common.WordCommonService;

@Controller
@AllArgsConstructor
public class CommonController {
    private final NumCommonService      numCommonService;
    private final WordCommonService     wordCommonService;

    @PostMapping("/numCommon/{dp}/{element}/{typeSignal}")
    public synchronized String saveNumCommon(@PathVariable("typeSignal") TypeSignal typeSignal,
                                @PathVariable("dp") String dp,
                                @PathVariable("element") String element,
                                NumCommon numCommon) {
        // Псевдоним уникальное поле, если оно пустое, значит по умолчанию вставляется точка и элемент
        if(numCommon.getAlias().equals(""))
            numCommon.setAlias(dp + element);
        // Сохраняем изменения и возвращаемся на страницу
        numCommonService.save(numCommon);
        return "redirect:/elements/" + numCommon.getIdDp() + "/" + numCommon.getIdElement() + "/" + typeSignal;
    }

    @PostMapping("/wordCommon/{dp}/{element}/{typeSignal}")
    public synchronized String saveNumCommon(@PathVariable("typeSignal") TypeSignal typeSignal,
                                             @PathVariable("dp") String dp,
                                             @PathVariable("element") String element,
                                             WordCommon wordCommon) {
        // Псевдоним уникальное поле, если оно пустое, значит по умолчанию вставляется точка и элемент
        if(wordCommon.getAlias().equals(""))
            wordCommon.setAlias(dp + element);
        // Сохраняем изменения и возвращаемся на страницу
        wordCommonService.save(wordCommon);
        return "redirect:/elements/" + wordCommon.getIdDp() + "/" + wordCommon.getIdElement() + "/" + typeSignal;
    }
}
