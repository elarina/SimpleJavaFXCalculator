package com.larina.calculator.model.calculation;

public class Calculator {
    private Double firstOperand;
    private Double secondOperand;
    private Operation operation;
    private boolean resume;

    public void clearCalculation(){
        this.firstOperand = null;
        this.secondOperand = null;
        this.operation = null;
        this.resume = false;
    }

    public void clearCalculationKeepFirstOperand(){
        this.secondOperand = null;
        this.operation = null;
        this.resume = false;
    }

    public void setFirstOperand(Double firstOperand) {
        if(this.firstOperand == null || resume || operation != null){
            this.firstOperand = firstOperand;
        } else {
            this.firstOperand = this.firstOperand*10 + firstOperand;
        }
    }

    public void setSecondOperand(Double secondOperand) {
        if(this.secondOperand == null){
            this.secondOperand = secondOperand;
        } else {
            this.secondOperand = this.secondOperand*10 + secondOperand;
        }
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Double getFirstOperand() {
        return firstOperand;
    }

    public Double getSecondOperand() {
        return secondOperand;
    }

    public Operation getOperation() {
        return operation;
    }

    public boolean isResume() {
        return resume;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }
}
