package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {

    private HashMap<KeyCode, Boolean> keyCode = new HashMap<KeyCode, Boolean>();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("EC2");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();

        root.setOnKeyPressed(event -> keyCode.put(event.getCode(), true));
        root.setOnKeyReleased(event -> keyCode.put(event.getCode(), false));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
