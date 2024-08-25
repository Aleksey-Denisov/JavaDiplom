package ru.gbwh.db.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.Type;
import ru.gbwh.db.repository.TypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeService {
    private final TypeRepository typeRepository;

    // Сохранение типа
    public void save(Type type) {
        typeRepository.save(type);
    }

    // Получение общего списка
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    // Удаление типа
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    // Возможно удалить за не надобностью
    /*
    public Type getById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }
    public Type getByName(Type type) {
        return typeRepository.findByNameDPT(type.getNameDPT()).orElse(null);
    }
    */
}
