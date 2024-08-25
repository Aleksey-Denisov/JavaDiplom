package ru.gbwh.db.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSController {

    // Стили бд
    @GetMapping("/database.css")
    public String getStyle() {
        return "../static/css/database.css";
    }

    // Общий стиль заголовков страницы
    @GetMapping("/header_page.css")
    public String getStyleHeader() {
        return "../static/css/header_page.css";
    }

    // Стили типов
    @GetMapping("/types.css")
    public String getStyleType() {
        return "../static/css/types.css";
    }

    // Получение стиля страницы свойств элементов
    @GetMapping("/original.css")
    public String getStyleOriginal() {
        return "../static/css/original.css";
    }

    // Выдача стилей страницы элементов
    @GetMapping("/elements.css")
    public String getStyleElements() {
        return "../static/css/elements.css";
    }
}

