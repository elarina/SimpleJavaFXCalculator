package com.larina.calculator.model;

import javafx.scene.control.Button;

public enum ButtonGroup {
    CALC_OPERATION("calc"),
    CONTROL_OPERATION("ctrl"),
    DIGIT("btn");

    private final String buttonIdPrefix;

    ButtonGroup(String buttonIdPrefix){
        this.buttonIdPrefix = buttonIdPrefix;
    }

    public String getButtonIdPrefix(){
        return this.buttonIdPrefix;
    }

    public static ButtonGroup defineGroup(Button button){
        String id = button.getId();
        if(id.contains(CALC_OPERATION.getButtonIdPrefix())){
            return CALC_OPERATION;
        }

        if(id.contains(CONTROL_OPERATION.getButtonIdPrefix())){
            return CONTROL_OPERATION;
        }

        if(id.contains(DIGIT.getButtonIdPrefix())){
            return DIGIT;
        }
        return null;
    }
}
