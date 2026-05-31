module com.larina.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.larina.calculator.main;
    exports com.larina.calculator.model;
    exports com.larina.calculator.model.memory;
    exports com.larina.calculator.model.calculation;
    exports com.larina.calculator.controller.listeners;

    opens com.larina.calculator.view.controls to javafx.graphics, javafx.base, javafx.fxml;
}