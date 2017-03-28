package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.awt.*;

public class Player implements GameMethod {

    private int x;
    private int y;

    private SceneInfo sceneInfo;

//    -------------------------------------------------------

    public Player(Point position, SceneInfo sceneInfo){
        this.setX(position.x);
        this.setY(position.y);
        this.sceneInfo = sceneInfo;
    }


//    Tjek efter om næste felt er en wall
    private boolean wallCollision() {
        for (Maze walls : sceneInfo.mazes) {
            if (this.getX() == walls.getX() && this.getY() == walls.getY()) {
                return true;
            }
        }
        return false;
    }


//    Out of bounds booleans
    private boolean outOfBoundsDown(){
        if (this.getY() >= sceneInfo.getRows()){
            return true;
        }
        return false;
    }
    private boolean outOfBoundsLeft(){
        if (this.getX() < 0){
            return true;
        }
        return false;
    }
    private boolean outOfBoundsRight(){
        if (this.getX() >= sceneInfo.getColumns()){
            return true;
        }
        return false;
    }
    private boolean outOfBoundsUp(){
        if (this.getY() < 0){
            return true;
        }
        return false;
    }


    @Override
    public void update(KeyCode keyPressed) {
        System.out.println("X:" + this.getX() + " Y:" + this.getY());
        switch (keyPressed)
        {
            case DOWN:
                this.setY(this.getY() + 1);
                if (wallCollision() || outOfBoundsDown()) {
                    this.setY(this.getY() - 1);
                }
                break;
            case LEFT:
                this.setX(this.getX() - 1);
                if (wallCollision() ||outOfBoundsLeft()) {
                    this.setX(this.getX() + 1);
                }
                break;
            case RIGHT:
                this.setX(this.getX() + 1);
                if (wallCollision() || outOfBoundsRight()) {
                    this.setX(this.getX() - 1);
                }
                break;
            case UP:
                this.setY(this.getY() - 1);
                if (wallCollision() || outOfBoundsUp()) {
                    this.setY(this.getY() + 1);
                }
                break;
        }
    }


    @Override
    public void draw(GraphicsContext graphicsContext, SceneInfo sceneInfo) {
        graphicsContext.setFill(Color.DARKOLIVEGREEN);
        graphicsContext.fillRoundRect(x * sceneInfo.getFieldWidth(), y * sceneInfo.getFieldHeight(), sceneInfo.getFieldWidth(), sceneInfo.getFieldHeight(), 1, 1);
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
