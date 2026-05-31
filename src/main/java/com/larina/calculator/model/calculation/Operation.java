package com.larina.calculator.model.calculation;

import java.util.List;

public enum Operation {
    DIVISION("/"),
    MINUS("-"),
    MULTIPLICATION("*"),
    PLUS("+"),
    REMAINDER("rem"),
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

    public static List<Operation> getControlOperations(){
        return List.of(EQUAL_SIGN, CLEAR_ALL, ADD_TO_MEMORY, BACKSPACE, REVERT);
    }
}
