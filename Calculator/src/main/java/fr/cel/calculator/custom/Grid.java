package fr.cel.calculator.custom;

import fr.cel.calculator.MainView;
import fr.cel.calculator.custom.NumberButton;
import fr.cel.calculator.custom.NumberBox;
import fr.cel.calculator.custom.SignButton;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Grid extends VBox {

    public Grid(MainView view) {
        super(20);

        this.setTranslateY(100);

        this.setBackground(Background.EMPTY);

        ObservableList<Node> components = this.getChildren();

        SignButton backButton = new SignButton("←", view);
        SignButton squareButton = new SignButton("x²", view);
        SignButton squareRootButton = new SignButton("√x", view);
        SignButton divideButton = new SignButton("/", view);

        List<Button> secondRow = new ArrayList<>();
        for (int i = 7; i < 10; i++) {
            NumberButton button = new NumberButton(i, view);
            secondRow.add(button);
        }

        SignButton multiplyButton = new SignButton("*", view);
        secondRow.add(multiplyButton);

        List<Button> thirdRow = new ArrayList<>();
        for (int i = 4; i < 7; i++) {
            NumberButton button = new NumberButton(i, view);
            thirdRow.add(button);
        }

        SignButton minusButton = new SignButton("-", view);
        thirdRow.add(minusButton);

        List<Button> fourthRow = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            NumberButton button = new NumberButton(i, view);
            fourthRow.add(button);
        }

        SignButton plusButton = new SignButton("+", view);
        fourthRow.add(plusButton);

        SignButton buttonC = new SignButton("C", view);
        NumberButton button0 = new NumberButton(0, view);
        SignButton buttonDot = new SignButton(".", view);
        SignButton buttonEqual = new SignButton("=", view);

        components.addAll(new NumberBox(List.of(backButton, squareButton, squareRootButton, divideButton)), new NumberBox(secondRow),
                new NumberBox(thirdRow), new NumberBox(fourthRow), new NumberBox(List.of(buttonC, button0, buttonDot, buttonEqual)));
    }

}