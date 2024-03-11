module fr.cel.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.cel.calculator to javafx.fxml;
    exports fr.cel.calculator;
    exports fr.cel.calculator.custom;
    opens fr.cel.calculator.custom to javafx.fxml;
}