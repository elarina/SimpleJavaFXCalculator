package com.larina.calculator.main.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainControl extends GridPane {
    private static final int COLUMN_COUNT = 3;

    @FXML private GridPane gridPane;
    @FXML private Label calculationRow;
    @FXML private GridPane buttonGrid;
    List<String> buttonGroups = Arrays.asList("ctrl", "btn","calc");
    private int rowCount;

    public MainControl(){
        URL fxmlUrl = getClass().getResource("/fxml/main.fxml");
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
        List<Button> allButtons = getAllButtons();
        Optional<Node> textOpt = buttonGrid.getChildren().stream().filter(Label.class::isInstance).findFirst();

        if(textOpt.isPresent()){
            Node text = textOpt.get();
            GridPane.setRowIndex(text, 0);
            GridPane.setColumnIndex(text,0);
            GridPane.setColumnSpan(text, 3);
            GridPane.setRowSpan(text, 2);
        }
        int startPosition = 1;
        for (String g: buttonGroups){
            startPosition = setButtonPositions(this, allButtons.stream().filter(b -> b.getId().contains(g)).toList(), startPosition);
        }

        this.rowCount = startPosition;
        setColumnPercentWidth();
        setRowPercentHeight();
    }

    private void setColumnPercentWidth() {
        buttonGrid.getColumnConstraints().clear();
        for(int i = 0; i < COLUMN_COUNT; i++){
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(((double) 100 / COLUMN_COUNT));
            cc.setHgrow(Priority.ALWAYS);
            buttonGrid.getColumnConstraints().add(cc);
        }
    }

    private static int setButtonPositions(MainControl mainControl, List<Button> buttons, int rowStartPosition) {
        System.out.println(rowStartPosition);
        int row = rowStartPosition;
        int col = 0;

        for (Button button : buttons) {
            if(col%3 == 0){
                col = 0;
                row++;
            }
            GridPane.setRowIndex(button, row);
            GridPane.setColumnIndex(button, col);
            button.setOnAction(e -> mainControl.handleDigitButton(button.getText()));
            col++;
        }
            return row;

    }

    private void setRowPercentHeight() {
        buttonGrid.getRowConstraints().clear();
        double rowWidth = (double)100/rowCount;

        for(int i = 0; i < this.rowCount + 1; i++){
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(rowWidth);
            rowConstraints.setVgrow(Priority.ALWAYS);
            buttonGrid.getRowConstraints().add(rowConstraints);
        }
    }

    private List<Button> getAllButtons() {
        return buttonGrid.getChildren()
                .filtered(node -> node instanceof Button)
                .stream()
                .map(node -> (Button) node).toList();
    }

    private void handleDigitButton(String buttonText) {
        switch(buttonText){
            case "C" -> calculationRow.setText("");
            case "B" -> calculationRow.setText(calculationRow.getText().substring(0, calculationRow.getText().length() - 2));
            default ->  calculationRow.setText(calculationRow.getText() + " " + buttonText);

        };
    }
}
