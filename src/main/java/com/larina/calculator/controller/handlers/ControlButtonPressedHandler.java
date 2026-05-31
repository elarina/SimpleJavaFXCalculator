package com.larina.calculator.controller.handlers;

import com.larina.calculator.model.MainModel;
import com.larina.calculator.model.TextRowValue;
import com.larina.calculator.model.calculation.Calculator;
import javafx.scene.control.Button;

public class ControlButtonPressedHandler extends  AbstractButtonPressedHandler{
    public ControlButtonPressedHandler(MainModel model) {
        super(model);
    }

    @Override
    protected void handleButtonPressed(Button button) {
        final TextRowValue textRowValue = mainModel.getTextRowValue();
        final Calculator calculator = mainModel.getCalculator();
        switch(button.getText()){
            case "C" ->  {
                textRowValue.setText("");
                calculator.clearCalculation();
            }
            case "MS" -> mainModel.getMemory().addToMemory(calculator.getFirstOperand());
            case "B" -> {
//                if(calculator.getSecondOperand() != null){
//                    double newValue = (double)(calculator.getSecondOperand().intValue() / 10);
//                    calculator.setSecondOperand(newValue);
//                    textRowValue.setText(textRowValue.getText().substring(0, textRowValue.getText().length() - 1));
//                } else if (calculator.getOperation() != null){
//                    calculator.setOperation(null);
//                    textRowValue.setText(textRowValue.getText().substring(0, textRowValue.getText().length() - 1));
//                } else if (!calculator.isResume()){
//                    double newValue = (double)(calculator.getFirstOperand().intValue() / 10);
//                    calculator.setFirstOperand(newValue);
//                    textRowValue.setText(textRowValue.getText().substring(0, textRowValue.getText().length() - 1));
//                }
            }
            case "R" -> {

            }
            case "=" -> {
                calculator.calculate();

                if(calculator.getSecondOperand() != null) {
                    textRowValue.setText(String.valueOf(calculator.getFirstOperand()));
                    calculator.finish();
                }

            }
//            default ->  textRowValue.setText(textRowValue.getText() + " " + button.getText());
        };
    }
}
