package com.larina.calculator.main.controls;

import com.larina.calculator.util.ResourceUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;

public class MainControl extends GridPane {
    public MainControl(){
        URL fxmlUrl = ResourceUtil.getResourceURL("fxml/main.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlUrl);
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
        // Do some work
    }

    @FXML
    private void oneClicked() {
        System.out.println("One clicked");
    }

    @FXML
    private void twoClicked() {
        System.out.println("Two clicked");
    }

    @FXML
    private void threeClicked() {
        System.out.println("Three clicked");
    }

    @FXML
    private void fourClicked() {
        System.out.println("Four clicked");
    }

    @FXML
    private void fiveClicked() {
        System.out.println("Five clicked");
    }

    @FXML
    private void sixClicked() {
        System.out.println("Six clicked");
    }

    @FXML
    private void sevenClicked() {
        System.out.println("Seven clicked");
    }

    @FXML
    private void eightClicked() {
        System.out.println("Eight clicked");
    }

    @FXML
    private void nineClicked() {
        System.out.println("Nine clicked");
    }
}
