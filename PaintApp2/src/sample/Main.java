package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void init(){}

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Paint app");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void stop(){}

}

