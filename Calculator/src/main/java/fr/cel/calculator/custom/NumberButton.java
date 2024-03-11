package fr.cel.calculator.custom;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NumberButton extends Button {

    public NumberButton(int number, Text resultCase) {
        super(String.valueOf(number));

        this.setFont(Font.font(30));

        this.setOnMouseClicked(mouseEvent -> {
            System.out.println("Le nombre clique est : " + number);
            if (resultCase.getText().equals("0")) {
                resultCase.setText(String.valueOf(number));
            } else {
                resultCase.setText(resultCase.getText() + number);
            }

        });
    }

}