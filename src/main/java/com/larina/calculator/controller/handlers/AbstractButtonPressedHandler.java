package com.larina.calculator.controller.handlers;

import com.larina.calculator.model.MainModel;
import com.larina.calculator.model.TextRowValue;
import javafx.scene.control.Button;

public abstract class AbstractButtonPressedHandler {

    protected final MainModel mainModel;

    public AbstractButtonPressedHandler(MainModel mainModel){
        this.mainModel = mainModel;
    }

    public void handle(Button button){
        handleButtonPressed(button);
        mainModel.notifyAboutChanges();
    }

    protected abstract void handleButtonPressed(Button button);
}
