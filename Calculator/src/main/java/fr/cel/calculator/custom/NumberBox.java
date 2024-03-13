package fr.cel.calculator.custom;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class NumberBox extends HBox {

    public NumberBox(List<Button> buttons) {
        super(30);
        this.setTranslateX(40);
        this.getChildren().addAll(buttons);
    }

}
