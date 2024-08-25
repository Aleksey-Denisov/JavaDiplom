package ru.gbwh.db.models.alertTable;

import jakarta.persistence.*;
import lombok.Data;
import ru.gbwh.db.models.alert.AlertColor;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AlertTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idDp;
    @Column(nullable = false)
    private Long idElement;
    @Column(nullable = false)
    private LocalDateTime timeAlarm;
    private String textAlarm;
    @Column(nullable = false)
    private AlertColor color;
}
