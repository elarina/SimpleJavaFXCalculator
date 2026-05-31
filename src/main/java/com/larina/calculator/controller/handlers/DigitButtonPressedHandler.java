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
        calculator.setOperand(operand);

        if (!calculator.isFinished()) {
            setTextInTextRow(button);
        } else {
            mainModel.getTextRowValue().setText(button.getText());
            calculator.start();
        }
    }

    private void setTextInTextRow(Button button) {
        String text = mainModel.getTextRowValue().getText();
        String previousText = text == null ? "" : text;
        mainModel.getTextRowValue().setText(previousText + button.getText());
    }
}
