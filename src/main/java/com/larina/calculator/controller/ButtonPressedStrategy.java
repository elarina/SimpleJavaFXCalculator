package com.larina.calculator.controller;

import com.larina.calculator.controller.handlers.AbstractButtonPressedHandler;
import com.larina.calculator.controller.handlers.CalcButtonPressedHandler;
import com.larina.calculator.controller.handlers.ControlButtonPressedHandler;
import com.larina.calculator.controller.handlers.DigitButtonPressedHandler;
import com.larina.calculator.model.ButtonGroup;
import com.larina.calculator.model.MainModel;
import javafx.scene.control.Button;

import java.util.Map;

public class ButtonPressedStrategy {
    private final Map<ButtonGroup, AbstractButtonPressedHandler> handlers;

    public ButtonPressedStrategy(MainModel model){
         handlers = Map.of(ButtonGroup.CONTROL_OPERATION, new ControlButtonPressedHandler(model),
                ButtonGroup.CALC_OPERATION,  new CalcButtonPressedHandler(model),
                ButtonGroup.DIGIT, new DigitButtonPressedHandler(model));
    }

    public void handle(MainModel model, Button button){
        ButtonGroup group = ButtonGroup.defineGroup(button);
        handlers.get(group).handle(button);
    }
}
