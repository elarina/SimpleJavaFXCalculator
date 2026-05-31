package com.larina.calculator.model;

import com.larina.calculator.controller.listeners.ModelListener;
import com.larina.calculator.model.calculation.Calculator;
import com.larina.calculator.model.memory.CalculationMemory;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    private final TextRowValue textRowValue;
    private final CalculationMemory memory;
    private final Calculator calculator;
    private final List<ModelListener> listeners = new ArrayList<>();

    public MainModel(TextRowValue textRowValue, CalculationMemory memory, Calculator calculator){
        this.textRowValue = textRowValue;
        this.memory = memory;
        this.calculator = calculator;
    }

    public void addListener(ModelListener listener) {
        listeners.add(listener);
    }

    public void notifyAboutChanges(){
        listeners.forEach(l -> l.onModelChanged(textRowValue));
    }

    public TextRowValue getTextRowValue() {
        return textRowValue;
    }

    public CalculationMemory getMemory() {
        return memory;
    }

    public Calculator getCalculator() {
        return calculator;
    }

}
