package ru.gbwh.db.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DataPoint {
    // Поля сущности
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String dataPointName;
    @Column(nullable = false)
    private Long idType;
}
