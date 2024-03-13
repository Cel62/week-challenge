package fr.cel.calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class Main extends Application {

    private final String WINDOW_TITLE = "Calculator";
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 530;

    @Override
    public void start(Stage stage) {
        stage.setTitle(WINDOW_TITLE);
        stage.setResizable(false);

        Scene scene = new Scene(new MainView(), WINDOW_WIDTH, WINDOW_HEIGHT, Color.rgb(32, 32, 32));
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}