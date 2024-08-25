package ru.gbwh.db.models.alert;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AlertSignal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected Long idDp;
    @Column(nullable = false)
    protected Long idElement;
    @Column(columnDefinition = "boolean")
    protected Boolean active = false;
    @Column(columnDefinition = "boolean")
    protected Boolean ack = false;
}
