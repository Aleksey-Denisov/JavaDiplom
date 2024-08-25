package ru.gbwh.db.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gbwh.db.models.DataPoint;
import ru.gbwh.db.service.DataPointService;
import ru.gbwh.db.service.StructTypeService;
import ru.gbwh.db.service.TypeService;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class DataPointController {
    private DataPointService dataPointService;
    private StructTypeService structTypeService;
    private TypeService typeService;

    // Стартова страница
    @GetMapping("/")
    public String getHome() {
        return "redirect:/database";
    }

    // Получение страницы
    @GetMapping("/database")
    public String getDatabase(Model model) {
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("dataPoints", dataPointService.findAll());
        model.addAttribute("structs", structTypeService.findAll());
        model.addAttribute("DP", new DataPoint());
        return "database";
    }

    // Обработка при добавлении точки
    @PostMapping(value = "/add-dp/{id}")
    public String addDP(@PathVariable("id") Long id, @ModelAttribute("DP") DataPoint dataPoint) {
        // Проверка на пустоту
        if(dataPoint.getDataPointName().equals(""))
            return "redirect:/database";
        // Обработка существующих точек на совпадение
        Optional<DataPoint> dpInDb = dataPointService.findAll().stream()
                .filter(dp -> dp.getDataPointName().equals(dataPoint.getDataPointName())).findFirst();
        if(dpInDb.isPresent())
            return "redirect:/database";
        dataPoint.setIdType(id);
        dataPointService.save(dataPoint);
        return "redirect:/database";
    }

    @PostMapping("/changeDP/{id}/{idType}")
    public String changeDP(@PathVariable("id") Long id,
                           @PathVariable("idType") Long idType,
                           @ModelAttribute("DP") DataPoint dataPoint) {
        // Проверка на пустоту
        if(dataPoint.getDataPointName().equals(""))
            return "redirect:/database";
        // Обработка существующих точек на совпадение
        Optional<DataPoint> dpInDb = dataPointService.findAll().stream()
                .filter(dp -> dp.getDataPointName().equals(dataPoint.getDataPointName())).findFirst();
        if(dpInDb.isPresent())
            return "redirect:/database";
        dataPoint.setId(id);
        dataPoint.setIdType(idType);
        dataPointService.save(dataPoint);
        return "redirect:/database";
    }

    // Удаление точки
    @GetMapping("/deleteDP/{id}")
    public String deleteDP(@PathVariable("id") Long id) {
        dataPointService.delete(id);
        return "redirect:/database";
    }

    // Перенаправление с любого неверного адреса
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "redirect:/database";
    }
}
