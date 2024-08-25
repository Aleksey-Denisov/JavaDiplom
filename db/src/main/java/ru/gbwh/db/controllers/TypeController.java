package ru.gbwh.db.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gbwh.db.models.Type;
import ru.gbwh.db.service.StructTypeService;
import ru.gbwh.db.service.TypeService;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class TypeController {
    private final TypeService typeService;
    private final StructTypeService structTypeService;

    // Сохранение типа
    @PostMapping(value = "/add-type")
    public String saveChangeType(@ModelAttribute("type") Type type) {
        // Проверка на пустоту
        if(type.getNameDPT().equals(""))
            return "redirect:/types";
        // Обработка существующих типов на совпадение
        Optional<Type> typeInDb = typeService.findAll().stream()
                .filter(dpt -> dpt.getNameDPT().equals(type.getNameDPT())).findFirst();
        if(typeInDb.isPresent())
            return "redirect:/types";
        typeService.save(type);
        return "redirect:/types";
    }

    // Удаление типа, каскадом удаляется и структура
    @GetMapping("/delete-type/{id}")
    public String deleteType(@PathVariable("id") Long id) {
        structTypeService.findByIdType(id).forEach(structType -> {
            structTypeService.delete(structType.getId());
        });
        typeService.delete(id);
        return "redirect:/types";
    }

    // Получение страницы типов
    @GetMapping("types")
    public String findAll(Model model) {
        model.addAttribute("type", new Type());
        model.addAttribute("types", typeService.findAll());
        return "types";
    }
}
