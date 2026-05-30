package com.larina.calculator.main;

import com.larina.calculator.main.controls.MainControl;
import com.larina.calculator.util.ResourceUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new MainControl();
        Scene scene = new Scene(root, 500, 500);
        var url = ResourceUtil.getResourceURLStr("css/maincontrol.css");
        scene.getStylesheets().add(url);
        primaryStage.setTitle("Simple JavaFX App on Java 21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
