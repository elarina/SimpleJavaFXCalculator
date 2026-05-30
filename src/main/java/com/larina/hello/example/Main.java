package com.larina.hello.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX 21!");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Simple JavaFX App on Java 21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
