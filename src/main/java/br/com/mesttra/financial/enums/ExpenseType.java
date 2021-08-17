package br.com.mesttra.financial.enums;

public enum ExpenseType {

    SALARY("SALARY"), OTHER("OTHER");

    private String value;

    private ExpenseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
