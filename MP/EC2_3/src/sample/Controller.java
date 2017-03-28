package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.awt.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static java.awt.Color.GREEN;

public class Controller {

    @FXML
    Canvas canvas;

    private Random random = new Random();


    private ArrayList<Node> platforms = new ArrayList<Node>();

    private Pane appRoot = new Pane();
    private Pane gameRoot = new Pane();
    private Pane uiRoot = new Pane();

    private Node player;
    private Point2D playerVelocity = new Point2D() {


        @Override
        public double getX() {
            return 0;
        }

        @Override
        public double getY() {
            return 0;
        }

        @Override
        public void setLocation(double x, double y) {

        }
    };

    private int levelWidth;


    Rectangle bg = new Rectangle(700,700);

    public void initContent(){
        levelWidth = LevelData.MazeData[0].length()*60;

        for (int i = 0; i < LevelData.MazeData.length; i++) {
            String line = LevelData.MazeData[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Node platform = createEntity(j*60, i*60, 60, 60, javafx.scene.paint.Color.BROWN);
                        platforms.add(platform);
                        break;
                }
            }
        }

        player = createEntity(0, 600, 40, 40, javafx.scene.paint.Color.BLUE);

        player.translateXProperty().addListener((obs, old, newValue) -> {
            int offset = newValue.intValue();

            if (offset > 640 && offset < levelWidth - 640) {
                gameRoot.setLayoutX(-(offset - 640));
            }
        });



        appRoot.getChildren().addAll(bg, gameRoot, uiRoot);
    }

    private Node createEntity(int x, int y, int w, int h, javafx.scene.paint.Color color) {
        javafx.scene.shape.Rectangle entity = new javafx.scene.shape.Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(color);
        entity.getProperties().put("alive", true);

        gameRoot.getChildren().add(entity);
        return entity;
    }






    public void update(){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        animationTimer.start();
    }


}
