package UI;

import Logic.GameObject;
import Logic.SceneInfo;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.*;

import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by skb on 24-03-2017.
 */
public class Ramble implements GameObject {

    public ArrayList<Float> randomColor = new ArrayList<Float>();
    private Random random = new Random(0-1);
    public float r,g,b = random.nextFloat();
    public Color rambleColor;

    private int x;
    private int y;

    public Ramble(Point position, Color color){
        this.setX(position.x);
        this.setX(position.y);
        this.rambleColor = color;
    }


    public void generateRambleColor(){
        randomColor.add(r);
        randomColor.add(g);
        randomColor.add(b);
        setRambleColor(new Color(r,g,b,1));
    }

    @Override
    public void update(KeyCode keyPressed) {

    }

    @Override
    public void draw(GraphicsContext graphicsContext, SceneInfo sceneInfo) {
            getRambleColor();
            //graphicsContext.setFill(getRambleColor());
            graphicsContext.fillRoundRect(getX() * sceneInfo.getFieldWidth(), getY() * sceneInfo.getFieldHeight(), sceneInfo.getFieldWidth(), sceneInfo.getFieldHeight(), 5, 5);
    }


    public Color getRambleColor() {
        return rambleColor;
    }

    public void setRambleColor(Color rambleColor) {
        this.rambleColor = rambleColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
