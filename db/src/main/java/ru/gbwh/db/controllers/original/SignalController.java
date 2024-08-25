package ru.gbwh.db.controllers.original;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gbwh.db.configuration.OriginalConfiguration;
import ru.gbwh.db.models.original.BoolSig;
import ru.gbwh.db.models.original.DoubleSig;
import ru.gbwh.db.models.original.IntSig;
import ru.gbwh.db.models.TypeSignal;
import ru.gbwh.db.models.original.StringSig;
import ru.gbwh.db.service.original.BoolSigService;
import ru.gbwh.db.service.original.DoubleSigService;
import ru.gbwh.db.service.original.IntSigService;
import ru.gbwh.db.service.original.StringSigService;

import java.time.LocalDateTime;


@Controller
@AllArgsConstructor
public class SignalController {
    private final OriginalConfiguration originalConfiguration;
    private final IntSigService         intSigService;
    private final BoolSigService        boolSigService;
    private final DoubleSigService      doubleSigService;
    private final StringSigService      stringSigService;



    // Обработка целочисленных значений
    @PostMapping("/saveInt/{dp}/{element}/{typeSignal}")
    public synchronized String saveChanges(@PathVariable("typeSignal") TypeSignal typeSignal,
                              @PathVariable("dp") String dp,
                              @PathVariable("element") String element,
                              IntSig intSig) {
        // Проверка флага активности, если ее нет, ничего записывать не буду
        if(originalConfiguration.getIntOriginal().get(dp + element).getActiveSig() ||
                intSig.getActiveSig()) {
            intSig.setTimeSignal(LocalDateTime.now());
            originalConfiguration.getIntOriginal().put(dp + element, intSigService.save(intSig));
        }
        return "redirect:/elements/" + intSig.getIdDP() + "/" + intSig.getIdStructType() + "/" + typeSignal;
    }

    // Обработка булевых значений
    @PostMapping("/saveBool/{dp}/{element}/{typeSignal}")
    public synchronized String saveChanges(@PathVariable("typeSignal") TypeSignal typeSignal,
                              @PathVariable("dp") String dp,
                              @PathVariable("element") String element,
                              BoolSig boolSig) {
        // Проверка флага активности, если ее нет, ничего записывать не буду
        if(originalConfiguration.getBoolOriginal().get(dp + element).getActiveSig() ||
                boolSig.getActiveSig()) {
            boolSig.setTimeSignal(LocalDateTime.now());
            originalConfiguration.getBoolOriginal().put(dp + element, boolSigService.save(boolSig));
        }
        return "redirect:/elements/" + boolSig.getIdDP() + "/" + boolSig.getIdStructType() + "/" + typeSignal;
    }

    // Обработка значений с плавающей точкой
    @PostMapping("/saveDouble/{dp}/{element}/{typeSignal}")
    public synchronized String saveChanges(@PathVariable("typeSignal") TypeSignal typeSignal,
                              @PathVariable("dp") String dp,
                              @PathVariable("element") String element,
                              DoubleSig doubleSig) {
        // Проверка флага активности, если ее нет, ничего записывать не буду
        if(originalConfiguration.getDoubleOriginal().get(dp + element).getActiveSig() ||
                doubleSig.getActiveSig()) {
            doubleSig.setTimeSignal(LocalDateTime.now());
            originalConfiguration.getDoubleOriginal().put(dp + element, doubleSigService.save(doubleSig));
        }
        return "redirect:/elements/" + doubleSig.getIdDP() + "/" + doubleSig.getIdStructType() + "/" + typeSignal;
    }

    // Обработка строк
    @PostMapping("/saveString/{dp}/{element}/{typeSignal}")
    public synchronized String saveChanges(@PathVariable("typeSignal") TypeSignal typeSignal,
                              @PathVariable("dp") String dp,
                              @PathVariable("element") String element,
                              StringSig stringSig) {
        // Проверка флага активности, если ее нет, ничего записывать не буду
        if(originalConfiguration.getStringOriginal().get(dp + element).getActiveSig() ||
                stringSig.getActiveSig()) {
            stringSig.setTimeSignal(LocalDateTime.now());
            originalConfiguration.getStringOriginal().put(dp + element, stringSigService.save(stringSig));
        }
        return "redirect:/elements/" + stringSig.getIdDP() + "/" + stringSig.getIdStructType() + "/" + typeSignal;
    }
}
