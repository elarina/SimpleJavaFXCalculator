package com.larina.calculator.model.calculation;

public class Operand {
    private double digit;
    private final Operation operationBefore;
    private final double previousValue;

    public Operand(double previousValue, Operation operationBefore){
        this.previousValue = previousValue;
        this.operationBefore = operationBefore;
    }

    public void addDigitValue(double digit){
        this.digit = digit;
    }

    public double digit() {
        return digit;
    }

    public void setDigit(double digit) {
        this.digit = digit;
    }

    public double getPreviousValue() {
        return previousValue;
    }

    public Operation getOperationBefore() {
        return operationBefore;
    }
}

