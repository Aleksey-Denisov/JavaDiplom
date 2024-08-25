package ru.gbwh.db.models;

import lombok.Data;

import java.util.List;

@Data
public class Elements {
    // Класс обертка для выгрузки списка элементов у типа
    List<StructType> typeList;
}
