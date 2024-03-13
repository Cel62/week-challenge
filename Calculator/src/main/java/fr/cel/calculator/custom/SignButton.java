package fr.cel.calculator.custom;

import fr.cel.calculator.MainView;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SignButton extends Button {

    private double result = 0;

    public SignButton(String sign, MainView view) {
        super(sign);

        this.setFont(Font.font(30));

        this.setOnMouseClicked(mouseEvent -> {
            Text resultCase = view.getResultCase();

            if (view.getResultCase().getText().equals("∞")) {
                view.setFirstNumber(0);
                view.setSecondNumber(0);
                view.setSymbol("");
                return;
            }

            double resultCaseNumber = Double.parseDouble(resultCase.getText());

            // TODO 25 caractères max avant dépassement pour = ; . ; x² / √x

            switch (sign) {
                case "+": {
                    view.setFirstNumber(resultCaseNumber);
                    resultCase.setText("0");
                    view.setSymbol("+");
                    break;
                }

                case "-": {
                    view.setFirstNumber(resultCaseNumber);
                    resultCase.setText("0");
                    view.setSymbol("-");
                    break;
                }

                case "*": {
                    view.setFirstNumber(resultCaseNumber);
                    resultCase.setText("0");
                    view.setSymbol("*");
                    break;
                }

                case "/": {
                    view.setFirstNumber(resultCaseNumber);
                    resultCase.setText("0");
                    view.setSymbol("/");
                    break;
                }

                case "=": {
                    view.setSecondNumber(resultCaseNumber);
                    if (view.getSymbol().equals("+")) {
                        result = view.getFirstNumber() + view.getSecondNumber();
                        resultCase.setText(formatResult(result));
                        view.setFirstNumber(result);
                    }

                    if (view.getSymbol().equals("-")) {
                        result = view.getFirstNumber() - view.getSecondNumber();
                        resultCase.setText(formatResult(result));
                        view.setFirstNumber(result);
                    }

                    if (view.getSymbol().equals("*")) {
                        result = view.getFirstNumber() * view.getSecondNumber();
                        resultCase.setText(formatResult(result));
                        view.setFirstNumber(result);
                    }

                    if (view.getSymbol().equals("/")) {
                        if (view.getSecondNumber() == 0) {
                            resultCase.setText("Vous ne pouvez pas diviser par 0");
                            resultCase.setFont(Font.font(27));
                            view.setOperationError(true);
                        } else {
                            result = view.getFirstNumber() / view.getSecondNumber();
                            resultCase.setText(formatResult(result));
                            view.setFirstNumber(result);
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
                    view.setFirstNumber(resultCaseNumber);
                    resultCase.setText(formatResult(result));
                    break;
                }

                case "√x": {
                    if (resultCaseNumber < 0) {
                        resultCase.setText("Entrée non valide");
                        view.setOperationError(true);
                    } else {
                        result = Math.sqrt(resultCaseNumber);
                        view.setFirstNumber(resultCaseNumber);
                        resultCase.setText(formatResult(result));
                    }
                    break;
                }

                case "C": {
                    resultCase.setText("0");
                    view.setFirstNumber(0.0D);
                    view.setSecondNumber(0.0D);
                    view.setSymbol("");
                    break;
                }
            }

            if (view.getResultCase().getText().equals("Infinity")) {
                view.getResultCase().setText("∞");
            }
        });
    }

    private String formatResult(double result) {
        if (result == (int) result) {
            return Integer.toString((int) result);
        } else {
            return Double.toString(result);
        }
    }

}