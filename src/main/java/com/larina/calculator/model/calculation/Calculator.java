package com.larina.calculator.model.calculation;

public class Calculator {
    private Double firstOperand;
    private Double secondOperand;
    private Operation operation;
    private boolean resume;

    public void calculate() {
        if(secondOperand == null){
            System.out.println("Second operand is not defined");
            return;
        }

        switch(operation){
            case Operation.PLUS ->  {
                firstOperand += secondOperand;
            }
            case Operation.MINUS ->  {
                firstOperand -= secondOperand;
            }
            case Operation.MULTIPLICATION ->  {
                firstOperand *= secondOperand;
            }
            case Operation.DIVISION ->  {
                firstOperand /= secondOperand;
            }
            case Operation.POW ->  {
                firstOperand = Math.pow(firstOperand, secondOperand);
            }
            case Operation.REMAINDER ->  {
                firstOperand %= secondOperand;
            }
        };
    }

    public void clearCalculation(){
        this.firstOperand = null;
        this.secondOperand = null;
        this.operation = null;
        this.resume = false;
    }

    public void clearCalculationKeepFirstOperand(){
        this.secondOperand = null;
        this.operation = null;
    }

    private void setFirstOperand(Double firstOperand) {
        if(this.firstOperand == null){
            this.firstOperand = firstOperand;
        } else {
            this.firstOperand = this.firstOperand*10 + firstOperand;
        }
    }

    private void setSecondOperand(Double secondOperand) {
        if(this.secondOperand == null){
            this.secondOperand = secondOperand;
        } else {
            this.secondOperand = this.secondOperand*10 + secondOperand;
        }
    }

    public void setOperation(Operation operation) {
        if(!Operation.getControlOperations().contains(operation)) {
            this.operation = operation;
        }
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

    public void setOperand(Double operand){
        if(firstOperand == null){
            setFirstOperand(operand);
        } else {
            setSecondOperand(operand);
        }
    }

    public boolean isResume() {
        return resume;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }


}
