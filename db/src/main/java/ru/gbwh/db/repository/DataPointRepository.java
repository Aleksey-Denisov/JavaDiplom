package ru.gbwh.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.gbwh.db.models.DataPoint;

import java.util.List;

public interface DataPointRepository extends JpaRepository<DataPoint, Long> {
    // Выгрузка списка точек данных с сортировкой
    @Modifying
    @Query("select dp from DataPoint dp order by dp.dataPointName")
    List<DataPoint> findAll();
}
