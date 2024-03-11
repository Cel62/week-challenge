package fr.cel.calculator.custom;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SignButton extends Button {

    public SignButton(String sign, Text resultCase) {
        super(sign);

        this.setFont(Font.font(30));

        this.setOnMouseClicked(mouseEvent -> {
            switch (sign) {
                // TODO faire le système d'ajout
                // TODO ajouter les derniers signes

                case "+": {
                    System.out.println("+");
                    break;
                }

                case "-": {
                    System.out.println("-");
                    break;
                }

                case "*": {
                    System.out.println("*");
                    break;
                }

                case "/": {
                    System.out.println("/");
                    break;
                }

                case "=": {
                    System.out.println("=");
                    break;
                }

                case ".": {
                    if (!resultCase.getText().contains(".")) {
                        resultCase.setText(resultCase.getText() + ".");
                    }
                    break;
                }

                case "C": {
                    resultCase.setText("0");
                    break;
                }
            }
        });
    }

}
