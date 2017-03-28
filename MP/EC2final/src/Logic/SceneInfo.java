package Logic;

import javafx.scene.canvas.Canvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SceneInfo {

    private double fieldHeight;
    private double fieldWidth;

    private int rows = 100;
    private int columns = 50;

    private Random random = new Random();
    public ArrayList<Maze> mazes = new ArrayList<>();

//    -------------------------------------------------------

    public SceneInfo(Canvas canvas) {
        fieldHeight = canvas.getHeight() / rows;
        fieldWidth = canvas.getWidth() / columns;
    }


    //    Tildeler et random punkt på scenen
    public Point getRandomPoint() {
        return new Point(random.nextInt(rows), random.nextInt(columns));
    }

    public Point playerSpawnPoint(){
        return new Point(1,1);
    }


    //    Størrelsen på fields i højde og bredte
    public double getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight(double fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public double getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(double fieldWidth) {
        this.fieldWidth = fieldWidth;
    }


    //    Antal rows
    public double getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }


    //    Antal Columns
    public double getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
