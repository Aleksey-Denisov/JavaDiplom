package ru.gbwh.db.models.common;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class CommonSignal {
    // Поля таблицы
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected Long idDp;
    protected Long idElement;
    protected String description;
    @Column(unique = true)
    protected String alias;
}
