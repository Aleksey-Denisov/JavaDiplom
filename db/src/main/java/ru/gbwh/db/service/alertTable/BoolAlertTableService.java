package ru.gbwh.db.service.alertTable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbwh.db.models.alert.AlertColor;
import ru.gbwh.db.models.alert.BoolAlert;
import ru.gbwh.db.models.alertTable.BoolAlertTable;
import ru.gbwh.db.models.original.BoolSig;
import ru.gbwh.db.repository.alertTable.BoolAlertTableRepository;
import ru.gbwh.db.service.alert.BoolAlertService;

@Service
@AllArgsConstructor
public class BoolAlertTableService {
    private final BoolAlertTableRepository  boolAlertTableRepository;
    private final BoolAlertService          boolAlertService;

    public void save(BoolSig boolSig) {
        // Получение алерта
        BoolAlert boolAlert = boolAlertService.getAlert(boolSig.getIdDP(), boolSig.getIdStructType());
        // Получение последнего аларма
        BoolAlertTable boolAlertTable = boolAlertTableRepository.getLastAlert(boolSig.getIdDP(),
                boolSig.getIdStructType());
        // Проверка на активность алерта
        if (boolAlert.getActive()) {
            // Проверка на то, что значения соответствуют сработке в алерте,
            // так же раньше никаких сработок быть не должно
            if (boolAlertTable == null && boolAlert.getValue() == boolSig.getSignalValue()) {
                // Собираем модель и записываем в таблицу
                boolAlertTableRepository.save(setParameters(boolSig, boolAlert.getColorAlert(),
                        boolAlert.getAlarmText() + "." + boolAlert.getInstalledText()));
            // А тут смотрим такое же условие, но сработка ранее была
            // а так же что алерт ранее не был сработан. Исключая дублирование
            } else if (boolAlert.getValue() == boolSig.getSignalValue() && boolAlertTable != null &&
                    boolSig.getSignalValue() != boolAlertTableRepository.getLastAlert(boolSig.getIdDP(),
                            boolSig.getIdStructType()).getValue()) {
                // Собираем модель и записываем в таблицу
                boolAlertTableRepository.save(setParameters(boolSig, boolAlert.getColorAlert(),
                        boolAlert.getAlarmText() + "." + boolAlert.getInstalledText()));
            // Иначе смотрим на то, что флаг снялся и последняя запись так же отсутствует в БД
            } else if (boolAlert.getValue() != boolSig.getSignalValue() && boolAlertTable != null &&
                    boolSig.getSignalValue() != boolAlertTableRepository.getLastAlert(boolSig.getIdDP(),
                            boolSig.getIdStructType()).getValue()) {
                boolAlertTableRepository.save(setParameters(boolSig, AlertColor.WHITE,
                        boolAlert.getAlarmText() + "." + boolAlert.getRemovedText()));
            }
        }
    }

    // Функция для сбора сущности
    private BoolAlertTable setParameters(BoolSig boolSig, AlertColor color, String textAlert) {
        BoolAlertTable boolAlertTable = new BoolAlertTable();
        boolAlertTable.setIdDp(boolSig.getIdDP());
        boolAlertTable.setIdElement(boolSig.getIdStructType());
        boolAlertTable.setValue(boolSig.getSignalValue());
        boolAlertTable.setTimeAlarm(boolSig.getTimeSignal());
        boolAlertTable.setColor(color);
        boolAlertTable.setTextAlarm(textAlert);
        return boolAlertTable;
    }
}
