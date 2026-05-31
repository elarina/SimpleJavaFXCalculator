package com.larina.calculator.view;

import com.larina.calculator.controller.listeners.ModelListener;
import com.larina.calculator.controller.listeners.ViewListener;
import com.larina.calculator.model.TextRowValue;
import com.larina.calculator.view.controls.MainControl;

public class MainView implements ModelListener {
    private final MainControl mainControl;

    public MainView(MainControl mainControl){
        this.mainControl = mainControl;
    }

    public MainControl getMainControl() {
        return mainControl;
    }

    public void addListener(ViewListener viewListener){
        mainControl.setListener(viewListener);
    }

    @Override
    public void onModelChanged(TextRowValue textRowValue) {
        mainControl.updateTextRowValue(textRowValue.getText());
    }
}
