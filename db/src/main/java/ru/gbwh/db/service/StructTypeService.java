package ru.gbwh.db.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.StructType;
import ru.gbwh.db.models.Type;
import ru.gbwh.db.repository.StructTypeRepository;
import ru.gbwh.db.repository.TypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StructTypeService {
    private final StructTypeRepository  structTypeRepository;
    private final TypeRepository        typeRepository;

    // Сохранение изменений
    public void save(StructType structType) {
        structTypeRepository.save(structType);
    }

    // Получение общего списка
    public List<StructType> findAll() {
        return structTypeRepository.findAll();
    }

    // Получение списка по идентификатору типа
    public List<StructType> findByIdType(Long idType) {
        return structTypeRepository.getStructTypeById(idType);
    }

    // Удаление элемента
    public void delete(Long id) {
        structTypeRepository.deleteById(id);
    }

    public StructType find(Long id) {
        return structTypeRepository.findById(id).orElse(null);
    }

    // Получение типа по идентификатору
    public Type getTypeById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }
}
