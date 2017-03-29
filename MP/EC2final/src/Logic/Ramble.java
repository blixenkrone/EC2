package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Ramble implements GameMethod {

    public ArrayList<Float> randomColor = new ArrayList<Float>();
    private Random random = new Random(0-1);
    public float r,g,b = random.nextFloat();
    private Color color;

    private int x;
    private int y;
    private double score = 0;

    public Ramble(Point position){
        this.setX(position.x);
        this.setY(position.y);
        generateRambleColor();
        this.color = color;
    }


    public void generateRambleColor(){
        randomColor.add(r);
        randomColor.add(g);
        randomColor.add(b);
        setColor(new Color(r,g,b,1));
    }


    @Override
    public void update(KeyCode keyPressed) {

    }

    @Override
    public void draw(GraphicsContext graphicsContext, SceneInfo sceneInfo) {
        graphicsContext.setFill(javafx.scene.paint.Color.AQUA);
        graphicsContext.fillRoundRect(x * sceneInfo.getFieldWidth(), y * sceneInfo.getFieldHeight(), sceneInfo.getFieldWidth(), sceneInfo.getFieldHeight(), 1, 1);
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
