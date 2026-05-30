module com.larina.hello.example {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.larina.calculator.main;

    opens com.larina.calculator.main.controls to javafx.graphics, javafx.base, javafx.fxml;
}