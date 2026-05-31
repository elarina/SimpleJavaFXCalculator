package com.larina.calculator.controller.handlers;

import com.larina.calculator.model.MainModel;
import com.larina.calculator.model.calculation.Calculator;
import javafx.scene.control.Button;

public class DigitButtonPressedHandler extends AbstractButtonPressedHandler {
    public DigitButtonPressedHandler(MainModel model) {
        super(model);
    }

    @Override
    protected void handleButtonPressed(Button button) {
        Calculator calculator = mainModel.getCalculator();

        double operand = Double.parseDouble(button.getText());

        if(calculator.getOperation() == null && !calculator.isResume()){
            calculator.setFirstOperand(operand);
        } else if(calculator.getOperation() != null) {
            calculator.setSecondOperand(operand);
        }

        setTextInTextRow(button);
    }

    private void setTextInTextRow(Button button) {
        String text = mainModel.getTextRowValue().getText();
        String previousText = text == null ? "" : text;
        mainModel.getTextRowValue().setText(previousText + button.getText());
    }
}
