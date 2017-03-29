package UI;

import Logic.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static javafx.scene.paint.Color.GOLD;
import static javafx.scene.paint.Color.PINK;

public class Controller {

    @FXML
    private Canvas myCanvas;

    private KeyCode keyPressed = KeyCode.BACK_SPACE;
    private float refreshRate = 200;

    private SceneInfo sceneInfo;
    private Player player;
    private Maze maze;
    private Ramble ramble;

    ArrayList<GameMethod> gameMethods = new ArrayList<GameMethod>();

//    -------------------------------------------------------

    public void startBtnMethod() {
        System.out.println("Start-btn clicked");
        drawCanvas();
    }


    public void keyPressed(KeyCode keyCode) {
        this.keyPressed = keyCode;
    }


    public void initialize() {
        sceneInfo = new SceneInfo(myCanvas);

        player = new Player(sceneInfo.playerSpawnPoint(), sceneInfo);

        ramble = new Ramble(sceneInfo.getRandomPoint());
        gameMethods.add(player);

        gameMethods.add(ramble);

        //System.out.println(ramble.getColor());

        for (int i = 0; i < 2000; i++) {
            maze = new Maze(Color.BLACK, sceneInfo.getRandomPoint());
            gameMethods.add(maze);
            sceneInfo.mazes.add(maze);

        }

        // Start and control game loop
        new AnimationTimer() {
            long lastUpdate;

            public void handle(long now) {
                if (now > lastUpdate + refreshRate * 1000000) {
                    lastUpdate = now;
                    update(now);
                }
            }
        }.start();
    }


    private void update(long now) {

        for (int i = 0; i < gameMethods.size(); i++) {
            gameMethods.get(i).update(this.keyPressed);
        }

        drawCanvas();
    }


    private void drawCanvas() {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, sceneInfo.getRows() * sceneInfo.getFieldWidth(), sceneInfo.getColumns() * sceneInfo.getFieldHeight());

//        Tegner alle spil-objekter
        for (GameMethod gameObjects : gameMethods) {
            gameObjects.draw(gc, sceneInfo);
        }
    }
}

