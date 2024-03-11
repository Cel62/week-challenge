package fr.cel.calculator.custom;

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

    public Grid(Text resultCase) {
        super(20);

        this.setTranslateY(100);

        this.setBackground(Background.EMPTY);

        ObservableList<Node> components = this.getChildren();

        SignButton backButton = new SignButton("←", resultCase);
        SignButton squareButton = new SignButton("x²", resultCase);
        SignButton squareRootButton = new SignButton("√x", resultCase);
        SignButton divideButton = new SignButton("/", resultCase);

        List<Button> secondRow = new ArrayList<>();
        for (int i = 7; i < 10; i++) {
            NumberButton button = new NumberButton(i, resultCase);
            secondRow.add(button);
        }

        SignButton multiplyButton = new SignButton("*", resultCase);
        secondRow.add(multiplyButton);

        List<Button> thirdRow = new ArrayList<>();
        for (int i = 4; i < 7; i++) {
            NumberButton button = new NumberButton(i, resultCase);
            thirdRow.add(button);
        }

        SignButton minusButton = new SignButton("-", resultCase);
        thirdRow.add(minusButton);

        List<Button> fourthRow = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            NumberButton button = new NumberButton(i, resultCase);
            fourthRow.add(button);
        }

        SignButton plusButton = new SignButton("+", resultCase);
        fourthRow.add(plusButton);

        NumberButton button0 = new NumberButton(0, resultCase);
        SignButton buttonC = new SignButton("C", resultCase);
        SignButton buttonDot = new SignButton(".", resultCase);
        SignButton buttonEqual = new SignButton("=", resultCase);

        components.add(new NumberBox(List.of(backButton, squareButton, squareRootButton, divideButton)));
        components.add(new NumberBox(secondRow));
        components.add(new NumberBox(thirdRow));
        components.add(new NumberBox(fourthRow));
        components.add(new NumberBox(List.of(button0, buttonC, buttonDot, buttonEqual)));
    }

}