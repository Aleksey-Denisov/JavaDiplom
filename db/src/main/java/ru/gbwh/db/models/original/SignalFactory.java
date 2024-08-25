package ru.gbwh.db.models.original;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class SignalFactory {
    // Поля сущности
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected Long idDP;
    @Column(nullable = false)
    protected Long idStructType;
    @Column(columnDefinition = "boolean")
    protected Boolean activeSig = true;
    @Column(columnDefinition = "boolean")
    protected Boolean bad = true;
    @Column(nullable = false)
    protected LocalDateTime timeSignal;
}