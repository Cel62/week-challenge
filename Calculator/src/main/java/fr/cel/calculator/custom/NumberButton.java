package fr.cel.calculator.custom;

import fr.cel.calculator.mode.NormalMode;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class NumberButton extends Button {

    public NumberButton(int number, NormalMode view) {
        super(String.valueOf(number));

        this.setFont(Font.font(30));

        this.setOnMouseClicked(mouseEvent -> {
            if (view.getResultCase().getText().equals("Infinity") || view.getResultCase().getText().equals("∞")) {
                view.setFirstNumber(number);
                view.setSecondNumber(0);
                view.setSymbol("");
                view.getResultCase().setText(String.valueOf(number));
                return;
            }

            view.numbers(number);
        });
    }

}