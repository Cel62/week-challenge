package fr.cel.calculator.custom;

import fr.cel.calculator.mode.NormalMode;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class SignButton extends Button {

    public SignButton(String sign, NormalMode view) {
        super(sign);

        this.setFont(Font.font(30));

        this.setOnMouseClicked(mouseEvent -> {
            if (view.getResultCase().getText().equals("Infinity") || view.getResultCase().getText().equals("∞")) {
                view.setFirstNumber(0);
                view.setSecondNumber(0);
                view.setSymbol("");
                view.getResultCase().setText(String.valueOf(0));
                return;
            }

            view.operators(sign);
        });
    }



}