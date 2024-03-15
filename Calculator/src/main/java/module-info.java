module fr.cel.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens fr.cel.calculator to javafx.fxml;
    exports fr.cel.calculator;
    exports fr.cel.calculator.custom;
    opens fr.cel.calculator.custom to javafx.fxml;
    exports fr.cel.calculator.mode;
    opens fr.cel.calculator.mode to javafx.fxml;
}