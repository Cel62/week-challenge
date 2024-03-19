package fr.cel.calculator.mode;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ScientificMode extends Group {

    private final Text resultCase;

    public ScientificMode() {
        ObservableList<Node> components = this.getChildren();

        resultCase = new Text("0");
        resultCase.setFill(Color.WHITE);
        resultCase.setFont(Font.font(30));
        resultCase.setTranslateY(50);
        resultCase.setTextAlignment(TextAlignment.RIGHT);
    }

}
