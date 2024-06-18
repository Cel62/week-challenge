package fr.cel.calculator.mode;

import fr.cel.calculator.custom.Grid;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import lombok.Getter;
import lombok.Setter;

@Getter
public class NormalMode extends Group {

    @Setter private double firstNumber = 0;
    @Setter private double secondNumber = 0;
    @Setter private String symbol = "";
    @Setter private boolean operationError = false;

    private double result = 0;

    private final Text resultCase;

    public NormalMode() {
        ObservableList<Node> components = this.getChildren();

        resultCase = new Text("0");
        resultCase.setFill(Color.WHITE);
        resultCase.setFont(Font.font(30));
        resultCase.setTranslateY(50);
        resultCase.setTextAlignment(TextAlignment.RIGHT);

        components.addAll(resultCase, new Grid(this));

        this.setOnKeyPressed(keyEvent -> {
        // System.out.println("Key Pressed: " + keyEvent.getCode().getName());

            if (this.getResultCase().getText().equals("Infinity") || this.getResultCase().getText().equals("∞")) {
                this.setFirstNumber(0);
                this.setSecondNumber(0);
                this.setSymbol("");
                this.getResultCase().setText(String.valueOf(0));
                return;
            }

            // Numbers
            if (keyEvent.getCode().getName().contains("Numpad")) {
                numbers(Integer.parseInt(keyEvent.getCode().getName().substring(keyEvent.getCode().getName().length() - 1)));
            }

            try {
                numbers(Integer.parseInt(keyEvent.getCode().getName()));
            } catch (NumberFormatException ignored) {}

            // Operators (only those found on the Numpad)
            operatorsNumpad(keyEvent.getCode().getName());

        });
    }

    public void operatorsNumpad(String keyName) {
        switch (keyName) {
            case "Add" -> operators("+");
            case "Substract" -> operators("-");
            case "Multiply" -> operators("*");
            case "Divide" -> operators("/");

            // TODO "Enter" doesn't work with AZERTY keyboard ?
            case "Equals", "Enter" -> operators("=");

            case "Decimal", "Comma", "Semicolon" -> operators(".");
        }

    }

    public void numbers(int number) {
        if (resultCase.getText().length() == 23) {
            return;
        }

        if (this.isOperationError()) {
            this.setFirstNumber(number);
            this.setSecondNumber(0);
            this.setSymbol("");
            this.getResultCase().setText(String.valueOf(number));
            this.getResultCase().setFont(Font.font(30));
            this.setOperationError(false);
            return;
        }

        if (this.getResultCase().getText().equals("0")) {
            this.getResultCase().setText(String.valueOf(number));
            return;
        }

        this.getResultCase().setText(this.getResultCase().getText() + number);
    }

    public void operators(String sign) {
        Text resultCase = this.getResultCase();
        double resultCaseNumber = Double.parseDouble(resultCase.getText());

        switch (sign) {
            case "+": {
                this.setFirstNumber(resultCaseNumber);
                resultCase.setText("0");
                this.setSymbol("+");
                break;
            }

            case "-": {
                this.setFirstNumber(resultCaseNumber);
                resultCase.setText("0");
                this.setSymbol("-");
                break;
            }

            case "*": {
                this.setFirstNumber(resultCaseNumber);
                resultCase.setText("0");
                this.setSymbol("*");
                break;
            }

            case "/": {
                this.setFirstNumber(resultCaseNumber);
                resultCase.setText("0");
                this.setSymbol("/");
                break;
            }

            case "=": {
                this.setSecondNumber(resultCaseNumber);
                if (this.getSymbol().equals("+")) {
                    result = this.getFirstNumber() + this.getSecondNumber();
                    resultCase.setText(formatResult(result));
                    this.setFirstNumber(result);
                }

                if (this.getSymbol().equals("-")) {
                    result = this.getFirstNumber() - this.getSecondNumber();
                    resultCase.setText(formatResult(result));
                    this.setFirstNumber(result);
                }

                if (this.getSymbol().equals("*")) {
                    result = this.getFirstNumber() * this.getSecondNumber();
                    resultCase.setText(formatResult(result));
                    this.setFirstNumber(result);
                }

                if (this.getSymbol().equals("/")) {
                    if (this.getSecondNumber() == 0) {
                        resultCase.setText("Vous ne pouvez pas diviser par 0");
                        resultCase.setFont(Font.font(27));
                        this.setOperationError(true);
                    } else {
                        result = this.getFirstNumber() / this.getSecondNumber();
                        resultCase.setText(formatResult(result));
                        this.setFirstNumber(result);
                    }
                }
                break;
            }

            case ".": {
                if (!resultCase.getText().contains(".")) {
                    resultCase.setText(resultCase.getText() + ".");
                }
                break;
            }

            case "←": {
                resultCase.setText(resultCase.getText().substring(0, resultCase.getText().length() - 1));
                if (resultCase.getText().isEmpty() || (resultCase.getText().length() == 1 && resultCase.getText().contains("-"))) {
                    resultCase.setText("0");
                    return;
                }
                break;
            }

            case "x²": {
                result = resultCaseNumber * resultCaseNumber;
                this.setFirstNumber(resultCaseNumber);
                resultCase.setText(formatResult(result));
                break;
            }

            case "√x": {
                if (resultCaseNumber < 0) {
                    resultCase.setText("Entrée non valide");
                    this.setOperationError(true);
                } else {
                    result = Math.sqrt(resultCaseNumber);
                    this.setFirstNumber(resultCaseNumber);
                    resultCase.setText(formatResult(result));
                }
                break;
            }

            case "C": {
                resultCase.setText("0");
                this.setFirstNumber(0.0D);
                this.setSecondNumber(0.0D);
                this.setSymbol("");
                break;
            }
        }

        if (this.getResultCase().getText().equals("Infinity")) {
            this.getResultCase().setText("∞");
        }
    }

    private String formatResult(double result) {
        if (result == (int) result) {
            return Integer.toString((int) result);
        } else {
            return Double.toString(result);
        }
    }

}