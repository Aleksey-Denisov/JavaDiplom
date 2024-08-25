package ru.gbwh.db.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StructType {
    // Поля сущности
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private TypeSignal typeSignal;
    @Column(nullable = false)
    private String nameElement;
    @Column(nullable = false)
    private Long idType;
}
