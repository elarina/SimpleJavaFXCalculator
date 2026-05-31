package com.larina.calculator.main;

import com.larina.calculator.controller.Controller;
import com.larina.calculator.model.MainModel;
import com.larina.calculator.model.TextRowValue;
import com.larina.calculator.model.calculation.Calculator;
import com.larina.calculator.view.MainView;
import com.larina.calculator.view.controls.MainControl;
import com.larina.calculator.model.memory.CalculationMemory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        if(controller == null){
            throw new IllegalArgumentException("Controller should be initialized");
        }

        Scene scene = new Scene(controller.getView().getMainControl(), 500, 500);
        String url = Objects.requireNonNull(getClass().getResource("/css/maincontrol.css")).toExternalForm();
        scene.getStylesheets().add(url);
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.setTitle("Simple JavaFX Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init(){
        MainControl root = new MainControl();
        MainView view = new MainView(root);
        TextRowValue textRowValue = new TextRowValue();
        CalculationMemory memory = new CalculationMemory();
        Calculator calculator = new Calculator();
        MainModel model = new MainModel(textRowValue, memory, calculator);
        controller = new Controller(model, view);
        view.addListener(controller);
        model.addListener(view);
    }
}
