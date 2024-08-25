package ru.gbwh.db.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Type {
    // Поля сущности
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nameDPT;
}
