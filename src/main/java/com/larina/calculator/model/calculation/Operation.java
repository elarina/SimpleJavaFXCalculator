package com.larina.calculator.model.calculation;

public enum Operation {
    DIVISION("/"),
    MINUS("-"),
    MULTIPLICATION("*"),
    PLUS("+"),
    REMAINDER("%"),
    POW("pow"),
    EQUAL_SIGN("="),
    CLEAR_ALL("C"),
    ADD_TO_MEMORY("MS"),
    BACKSPACE("B"),
    REVERT("R");

    private final String sign;

    private Operation(String sign){
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
