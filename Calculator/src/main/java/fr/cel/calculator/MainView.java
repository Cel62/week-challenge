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

    public MainView() {
        ObservableList<Node> components = this.getChildren();

        Text resultCase = new Text("0");
        resultCase.setFill(Color.WHITE);
        resultCase.setFont(Font.font(30));
        resultCase.setTranslateY(50);
        resultCase.setTextAlignment(TextAlignment.RIGHT);

        components.addAll(resultCase, new Grid(resultCase));
    }

}