package com.larina.calculator.view.controls;

import com.larina.calculator.controller.Controller;
import com.larina.calculator.controller.listeners.ViewListener;
import com.larina.calculator.model.calculation.Calculator;
import com.larina.calculator.model.ButtonGroup;
import com.larina.calculator.model.memory.CalculationMemory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    List<String> buttonGroups = Arrays.asList(ButtonGroup.CONTROL_OPERATION.getButtonIdPrefix(),ButtonGroup.DIGIT.getButtonIdPrefix(), ButtonGroup.CALC_OPERATION.getButtonIdPrefix());
    private int rowCount;
    private ViewListener listener;
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

    public void setListener(ViewListener listener){
        this.listener = listener;
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
            button.setOnAction(e -> mainControl.handleButtonPressed(button));
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

    private void handleButtonPressed(Button button) {
        if(listener != null){
            listener.onButtonClicked(button);
        }
    }

    public void updateTextRowValue(String text) {
        calculationRow.setText(text);
    }
}
