package fr.cel.calculator;

import fr.cel.calculator.custom.Grid;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MainView extends Group {

    private double firstNumber = 0;
    private double secondNumber = 0;
    private String symbol = "";
    private boolean operationError = false;

    private final Text resultCase;

    public MainView() {
        ObservableList<Node> components = this.getChildren();

        resultCase = new Text("0");
        resultCase.setFill(Color.WHITE);
        resultCase.setFont(Font.font(30));
        resultCase.setTranslateY(50);
        resultCase.setTextAlignment(TextAlignment.LEFT);

        components.addAll(resultCase, new Grid(this));
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Text getResultCase() {
        return resultCase;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isOperationError() {
        return operationError;
    }

    public void setOperationError(boolean operationError) {
        this.operationError = operationError;
    }

}