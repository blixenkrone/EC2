package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.awt.*;

public class Maze implements GameMethod {

    private int x;
    private int y;
    private Color color;

//    -------------------------------------------------------

    public Maze(Color color, Point position){
        this.setX(position.x);
        this.setY(position.y);
        this.color = color;
    }


    @Override
    public void draw(GraphicsContext graphicsContext, SceneInfo sceneInfo) {
        graphicsContext.setFill(this.getColor());
        graphicsContext.fillRoundRect(x * sceneInfo.getFieldWidth(), y * sceneInfo.getFieldHeight(), sceneInfo.getFieldWidth(), sceneInfo.getFieldHeight(), 1, 1);
    }


    @Override
    public void update(KeyCode keyPressed) {
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
