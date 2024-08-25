package ru.gbwh.db.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gbwh.db.models.Elements;
import ru.gbwh.db.models.StructType;
import ru.gbwh.db.service.StructTypeService;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class StructController {
    private StructTypeService service;

    @GetMapping("/change-elements/{id}")
    public String changeStruct(@PathVariable("id") Long id, Model model) {
        // Выдаем страницу, для начала подготовим необходимые сущности
        Elements elements = new Elements();
        StructType type = new StructType();
        // По идентификатору достану все что относится
        elements.setTypeList(service.findByIdType(id));
        type.setIdType(id);
        // Полученные модели отправятся на страницу
        model.addAttribute("typeName", "Настройка типа данных " + service.getTypeById(id).getNameDPT());
        model.addAttribute("struct", elements);
        model.addAttribute("addElement", type);
        return "change-elements";
    }

    @PostMapping(value = "/add-element/{id}")
    public String saveElement(@PathVariable("id") Long id, StructType structType) {
        // Проверка записи пустоты
        if (structType.getNameElement().equals(""))
            return "redirect:/change-elements/" + id;
        // Проверка записи дубликатов
        Optional<StructType> type = service.findByIdType(id).stream().filter(struct -> struct.getNameElement()
                .equals(structType.getNameElement())).findFirst();
        if(type.isPresent())
            return "redirect:/change-elements/" + id;
        // Дополнительная проверка на начальный разделитель
        if(!structType.getNameElement().startsWith("."))
            structType.setNameElement("." + structType.getNameElement());
        // В конечном итоге если все хорошо записываю
        service.save(structType);
        return "redirect:/change-elements/" + id;
    }

    @PostMapping(value = "/change-elements/{id}")
    public String saveChanges(@PathVariable("id") Long id, Elements elements) {
        // Сохранение изменений структуры
        elements.getTypeList().forEach(element -> {
            // Дополнительная проверка на начальный разделитель
            if(!element.getNameElement().startsWith("."))
                element.setNameElement("." + element.getNameElement());
            service.save(element);
        });
        return "redirect:/change-elements/" + id;
    }

    @GetMapping(value = "/deleteDpe/{id}/{idType}")
    public String deleteElement(@PathVariable("id") Long id,
                                @PathVariable("idType") Long idType) {
        service.delete(id);
        return "redirect:/change-elements/" + idType;
    }
}
