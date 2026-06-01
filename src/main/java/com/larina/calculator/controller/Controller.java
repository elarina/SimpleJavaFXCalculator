package com.larina.calculator.controller;

import com.larina.calculator.controller.listeners.ViewListener;
import com.larina.calculator.model.MainModel;
import com.larina.calculator.view.MainView;
import javafx.scene.control.Button;

public class Controller implements ViewListener {
    private final MainModel model;
    private final MainView view;
    private ButtonPressedStrategy buttonPressedStrategy;

    public Controller(MainModel model, MainView view){
        this.model = model;
        this.view = view;
    }

    public MainModel getModel() {
        return model;
    }

    public MainView getView() {
        return view;
    }

    public void setButtonPressedStrategy(ButtonPressedStrategy buttonPressedStrategy) {
        this.buttonPressedStrategy = buttonPressedStrategy;
    }

    @Override
    public void onButtonClicked(Button button) {
        buttonPressedStrategy.handle(model, button);
    }
}
