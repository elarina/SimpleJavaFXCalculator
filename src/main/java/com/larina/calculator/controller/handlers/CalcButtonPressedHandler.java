package com.larina.calculator.controller.handlers;

import com.larina.calculator.model.MainModel;
import com.larina.calculator.model.TextRowValue;
import com.larina.calculator.model.calculation.Calculator;
import com.larina.calculator.model.calculation.Operand;
import com.larina.calculator.model.calculation.Operation;
import javafx.scene.control.Button;

import java.util.Optional;
import java.util.stream.Stream;

public class CalcButtonPressedHandler extends AbstractButtonPressedHandler {

    public CalcButtonPressedHandler(MainModel model) {
        super(model);
    }

    @Override
    protected void handleButtonPressed(Button button) {
        Optional<Operation> op = Stream.of(Operation.values()).filter(v -> v.getSign().equals(button.getText())).findFirst();
        if(op.isEmpty()){
            throw new IllegalArgumentException("Illegal operation");
        }
        Calculator calculator = mainModel.getCalculator();

        addOperationText(op.get(), calculator);
        if(calculator.getSecondOperand() != null){
            calculate();
            if(op.get() != Operation.EQUAL_SIGN){
                mainModel.getTextRowValue().setText(String.valueOf(calculator.getFirstOperand()) + " " + op.get().getSign() + " ");
            } else {
                mainModel.getTextRowValue().setText(String.valueOf(calculator.getFirstOperand()));
            }
        } else if(op.get() != Operation.EQUAL_SIGN) {
            calculator.setOperation(op.get());
        }
    }

    private void addOperationText(Operation operation, Calculator calculator) {
        if(operation == Operation.EQUAL_SIGN){
            return;
        }

        if(calculator.getOperation() == null){
            setTextInTextRow(operation.getSign());
        } else {
            setTextInTextRowRemovePrevOp(operation.getSign());
        }
    }

    private void setTextInTextRow(String additionalText) {
        String text = mainModel.getTextRowValue().getText();
        String previousText = text == null ? "" : text;
        mainModel.getTextRowValue().setText(previousText + additionalText);
    }

    private void setTextInTextRowRemovePrevOp(String additionalText) {
        String text = mainModel.getTextRowValue().getText();
        String previousText = text == null ? "" : text;
        String substring = previousText.substring(0, previousText.length() - 1);
        mainModel.getTextRowValue().setText(substring + additionalText);
    }

    private void calculate() {
        Calculator calculator = mainModel.getCalculator();

        switch(calculator.getOperation()){
            case Operation.PLUS ->  {
                calculator.setFirstOperand(calculator.getFirstOperand() + calculator.getSecondOperand());
            }
            case Operation.MINUS ->  {
                calculator.setFirstOperand(calculator.getFirstOperand() - calculator.getSecondOperand());
            }
            case Operation.MULTIPLICATION ->  {
                calculator.setFirstOperand(calculator.getFirstOperand() * calculator.getSecondOperand());
            }
            case Operation.DIVISION ->  {
                calculator.setFirstOperand(calculator.getFirstOperand() / calculator.getSecondOperand());
            }
            case Operation.POW ->  {
                calculator.setFirstOperand(Math.pow(calculator.getFirstOperand(), calculator.getSecondOperand()));
            }
            case Operation.REMAINDER ->  {
                calculator.setFirstOperand(calculator.getFirstOperand() % calculator.getSecondOperand());
            }
        };
        mainModel.getTextRowValue().setText("");
        calculator.clearCalculationKeepFirstOperand();
    }
}