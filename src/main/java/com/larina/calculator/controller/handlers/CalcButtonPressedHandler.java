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
        TextRowValue textRowValue = mainModel.getTextRowValue();

        addOperationText(op.get(), calculator);
        calculator.calculate();

        if(calculator.getSecondOperand() != null) {
            textRowValue.setText(String.valueOf(calculator.getFirstOperand()) + op.get().getSign());
            calculator.setResume(true);
        }
        calculator.clearCalculationKeepFirstOperand();
        calculator.setOperation(op.get());
    }

    private void addOperationText(Operation operation, Calculator calculator) {
//        if(Operation.getControlOperations().contains(operation)){
//            return;
//        }

        setTextInTextRow(operation.getSign(), calculator.getOperation() != null);
    }

    private void setTextInTextRow(String additionalText, boolean clearPreviousOperation) {
        String text = mainModel.getTextRowValue().getText();
        String previousText = text == null ? "" : text;
        previousText = clearPreviousOperation ? previousText.substring(0, previousText.length() - 1) : previousText;
        mainModel.getTextRowValue().setText(previousText + additionalText);
    }
}