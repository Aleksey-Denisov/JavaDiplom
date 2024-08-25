package ru.gbwh.db.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Imitator {
    private final OriginalConfiguration configuration;


}
