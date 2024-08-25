package ru.gbwh.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbwh.db.models.Type;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    // Получение типа по имени
    Optional<Type> findByNameDPT(String name);

}
