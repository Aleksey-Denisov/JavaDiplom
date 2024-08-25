package ru.gbwh.db.models.alert;

public enum AlertOperation {
    MORE(">"),
    MOREEQ(">="),
    EQUALS("="),
    LESSEQ("<="),
    LESS("<");

    private final String displayValue;

    AlertOperation(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
