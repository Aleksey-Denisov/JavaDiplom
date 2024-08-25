package ru.gbwh.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.StructType;

import java.util.List;

public interface StructTypeRepository extends JpaRepository<StructType, Long> {
    // Выгрузка списка элементов точек данных с сортировкой
    // По конкретному типу
    @Modifying
    @Query("select s from StructType s where s.idType=?1 order by s.nameElement")
    List<StructType> getStructTypeById(Long idType);

    // Выгрузка списка элементов точек данных с сортировкой
    @Modifying
    @Query("select dpe from StructType dpe order by dpe.nameElement")
    List<StructType> findAll();
}
