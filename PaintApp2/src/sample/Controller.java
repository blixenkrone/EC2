package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class Controller {

    GraphicsContext gc;
    private Color totalSlideColor;
    private static double buttonSizeValue = 0;
    private static double sliderValue = 0;


    @FXML
    Canvas canvas;
    @FXML
    ColorPicker colorPicker = new ColorPicker();
    @FXML
    Slider slider, rslider, gslider, bslider;
    @FXML
    Button slet, tegn, op, ned, clear;

    @FXML
    public void drawOnCanvas() {
        gc = canvas.getGraphicsContext2D();
        System.out.println("Tegner!");

        try {
            canvas.setOnMousePressed(event -> {
                setSize();
                gc.beginPath();
                gc.setLineCap(StrokeLineCap.ROUND);
                gc.lineTo(event.getSceneX(), event.getSceneY());
                gc.stroke();

            });

            canvas.setOnMouseDragged(event -> {
                setSize();
                gc.lineTo(event.getSceneX(), event.getSceneY());
                gc.stroke();
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @FXML
    private void setColor() {
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(colorPicker.getValue());
        System.out.println(colorPicker.getValue());
    }

    @FXML
    private void setSliderColor() {
        rslider.setMin(0);
        rslider.setMax(1);
        rslider.setBlockIncrement(0.1);
        double redValue = rslider.getValue();
        gslider.setMin(0);
        gslider.setMax(1);
        gslider.setBlockIncrement(0.1);
        double greenValue = gslider.getValue();
        bslider.setMin(0);
        bslider.setMax(1);
        bslider.setBlockIncrement(0.1);
        double blueValue = bslider.getValue();

        totalSlideColor = new Color(redValue, greenValue, blueValue, 1);
        System.out.println(redValue + greenValue + blueValue);
        gc.setStroke(totalSlideColor);
    }


    @FXML
    private void setSize() {
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        buttonSizeValue = sliderValue;
        slider.setMin(1);
        slider.setMax(100);
        double sliderDrawValue = slider.getValue();
        gc.setLineWidth(sliderDrawValue);
    }

    @FXML
    private void setButtonSize() {

        op.setOnMousePressed(event -> {
            buttonSizeValue += 10;
            gc.setLineWidth(buttonSizeValue);
            System.out.println("op 10 størrelse");
        });

        ned.setOnMousePressed(event -> {
            buttonSizeValue -= 10;
            gc.setLineWidth(buttonSizeValue);
            System.out.println("ned 10 størrelse");
        });

        sliderValue = buttonSizeValue;
        slider.setValue(buttonSizeValue); //Vi sætter værdien af slideren til at være det, som knappens værdi er blevet til.
        setSize();
    }

    @FXML
    private void eraseDraw() {
        slider.onDragDetectedProperty();
        gc.setLineWidth(slider.getValue());
        colorPicker.setValue(new Color(0.95, 0.95, 0.95, 1));
    }

    @FXML
    private void clearCanvas() {
        gc.clearRect(0, 0, 700, 700);
    }
}