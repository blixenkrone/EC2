package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

public class Controller {

    @FXML Canvas canvas;

    @FXML ColorPicker colorPicker = new ColorPicker();
    GraphicsContext gc;
    @FXML Slider slider;

    @FXML public void drawCanvas(){

        gc = canvas.getGraphicsContext2D();
        System.out.println("drawCanvas");

        try {
            canvas.setOnMousePressed(event -> {
                System.out.println("Mouse click");
                gc.beginPath();
                gc.lineTo(event.getSceneX(), event.getSceneY());
                gc.stroke();
            });

            canvas.setOnMouseDragged(event -> {
                System.out.println("Mouse dragged");
                gc.lineTo(event.getSceneX(), event.getSceneY());
                gc.stroke();
            });

        }catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }

    @FXML private void setColor(){
        gc = canvas.getGraphicsContext2D();
        colorPicker.setValue(Color.WHITE);
        colorPicker.setOnAction(event -> {
            gc.setStroke(colorPicker.getValue());
        });
        System.out.println(colorPicker.getValue());
    }

    @FXML private void setSize(){
        slider.setMin(1);
        slider.setMax(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.onDragDetectedProperty();
        gc.setLineWidth(slider.getValue());
    }

    @FXML private void eraseDraw(){

    }
}
