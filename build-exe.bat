IF EXIST "SimpleJavaFXCalculator" (
    RMDIR /S /Q "SimpleJavaFXCalculator"
)
mvn clean javafx:jlink && jpackage --type app-image ^ -n SimpleJavaFXCalculator ^ -m com.larina.hello.example/com.larina.calculator.main.Main ^ --runtime-image target/image