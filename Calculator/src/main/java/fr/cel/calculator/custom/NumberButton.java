package fr.cel.calculator.custom;

import fr.cel.calculator.MainView;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class NumberButton extends Button {

    public NumberButton(int number, MainView view) {
        super(String.valueOf(number));

        this.setFont(Font.font(30));

        this.setOnMouseClicked(mouseEvent -> {
            // TODO 25 caractères max avant dépassement
            if (view.isOperationError()) {
                view.setFirstNumber(number);
                view.setSecondNumber(0);
                view.setSymbol("");
                view.getResultCase().setText(String.valueOf(number));
                view.getResultCase().setFont(Font.font(30));
                view.setOperationError(false);
                return;
            }

            if (view.getResultCase().getText().equals("Infinity") || view.getResultCase().getText().equals("∞")) {
                view.setFirstNumber(number);
                view.setSecondNumber(0);
                view.setSymbol("");
                view.getResultCase().setText(String.valueOf(number));
                return;
            }

            if (view.getResultCase().getText().equals("0")) {
                view.getResultCase().setText(String.valueOf(number));
                return;
            }

            view.getResultCase().setText(view.getResultCase().getText() + number);
        });
    }

}