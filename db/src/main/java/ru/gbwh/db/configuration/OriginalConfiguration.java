package ru.gbwh.db.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import ru.gbwh.db.models.TypeSignal;
import ru.gbwh.db.models.original.*;
import ru.gbwh.db.service.DataPointService;
import ru.gbwh.db.service.StructTypeService;
import ru.gbwh.db.service.original.BoolSigService;
import ru.gbwh.db.service.original.DoubleSigService;
import ru.gbwh.db.service.original.IntSigService;
import ru.gbwh.db.service.original.StringSigService;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@AllArgsConstructor
public class OriginalConfiguration {
    private final DataPointService  dataPointService;
    private final StructTypeService structTypeService;
    private final IntSigService     intSigService;
    private final BoolSigService    boolSigService;
    private final DoubleSigService  doubleSigService;
    private final StringSigService  stringSigService;

    // Список всех целочисленных элементов
    public ConcurrentHashMap<String, IntSig> getIntOriginal() {
        ConcurrentHashMap<String, IntSig> intSigs = new ConcurrentHashMap<>();
        dataPointService.findAll().forEach(dp -> structTypeService.findAll().forEach(dpe->  {
            if (Objects.equals(dp.getIdType(), dpe.getIdType())
                    && dpe.getTypeSignal() == TypeSignal.INT) {
                intSigs.put(dp.getDataPointName() + dpe.getNameElement(),
                        Objects.requireNonNullElseGet(intSigService.getLast(dp.getId(), dpe.getId()),
                                () -> new IntSig(dp.getId(), dpe.getId())));
            }
        }));
        return intSigs;
    }

    // Список всех булевых элементов
    public ConcurrentHashMap<String, BoolSig> getBoolOriginal() {
        ConcurrentHashMap<String, BoolSig> boolSigs = new ConcurrentHashMap<>();
        dataPointService.findAll().forEach(dp -> structTypeService.findAll().forEach(dpe -> {
            if (Objects.equals(dp.getIdType(), dpe.getIdType())
                    && dpe.getTypeSignal() == TypeSignal.BOOL) {
                boolSigs.put(dp.getDataPointName() + dpe.getNameElement(),
                        Objects.requireNonNullElseGet(boolSigService.getLast(dp.getId(), dpe.getId()),
                                () -> new BoolSig(dp.getId(), dpe.getId())));
            }
        }));
        return boolSigs;
    }

    // Список всех элементов с плавающей точкой
    public ConcurrentHashMap<String, DoubleSig> getDoubleOriginal() {
        ConcurrentHashMap<String, DoubleSig> doubleSigs = new ConcurrentHashMap<>();
        dataPointService.findAll().forEach(dp -> structTypeService.findAll().forEach(dpe->  {
            if (Objects.equals(dp.getIdType(), dpe.getIdType())
                    && dpe.getTypeSignal() == TypeSignal.DOUBLE) {
                doubleSigs.put(dp.getDataPointName() + dpe.getNameElement(),
                        Objects.requireNonNullElseGet(doubleSigService.getLast(dp.getId(), dpe.getId()),
                                () -> new DoubleSig(dp.getId(), dpe.getId())));
            }
        }));
        return doubleSigs;
    }

    // Список всех строковых элементов
    public ConcurrentHashMap<String, StringSig> getStringOriginal() {
        ConcurrentHashMap<String, StringSig> stringSigs = new ConcurrentHashMap<>();
        dataPointService.findAll().forEach(dp -> structTypeService.findAll().forEach(dpe->  {
            if (Objects.equals(dp.getIdType(), dpe.getIdType())
                    && dpe.getTypeSignal() == TypeSignal.STRING) {
                stringSigs.put(dp.getDataPointName() + dpe.getNameElement(),
                        Objects.requireNonNullElseGet(stringSigService.getLast(dp.getId(), dpe.getId()),
                                () -> new StringSig(dp.getId(), dpe.getId())));
            }
        }));
        return stringSigs;
    }
}
