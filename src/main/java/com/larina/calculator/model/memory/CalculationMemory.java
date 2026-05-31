package com.larina.calculator.model.memory;

import java.util.ArrayList;
import java.util.List;

public class CalculationMemory {
    private final List<Double> results = new ArrayList<>();

    public void addToMemory(double result){
        results.add(result);
    }

    public List<Double> getMemory(){
        return results;
    }
}
