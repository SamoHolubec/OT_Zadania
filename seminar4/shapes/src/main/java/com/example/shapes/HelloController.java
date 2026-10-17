package com.example.shapes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML
    private Pane pane;

    private List<GeometricShape> shapes = new ArrayList<>();
    private final Random random = new Random();
    private Timeline timeline;

    @FXML
    public void initialize(){
        timeline = new Timeline(new KeyFrame(Duration.millis(20), e-> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void update(){
        double w = pane.getWidth();
        double h = pane.getHeight();
        for(GeometricShape shape : shapes){
            shape.move(w, h);
            shape.draw();
        }
    }

    private void addShape(GeometricShape shape){
        shapes.add(shape);
        pane.getChildren().add(shape.getNode());
    }

    @FXML
    public void addSquare(){
        double x = random.nextDouble() * (pane.getWidth() - MySquare.size);
        double y = 50 + random.nextDouble() * ((pane.getHeight() - MySquare.size) -50);
        addShape(new MySquare(x, y, Color.RED));
    }

    @FXML
    public void addRectangle(){
        double x = random.nextDouble() * (pane.getWidth() - MyRectangle.w);
        double y = 50 + random.nextDouble() * ((pane.getHeight() - MyRectangle.h) -50);
        addShape(new MyRectangle(x, y, Color.BLACK));
    }

    @FXML
    public void addCircle(){
        double minX = 10+MyCircle.r;
        double maxX = pane.getWidth() - 10;
        double minY = 50 + 10;
        double maxY = pane.getHeight() - 10;
        double x = minX + random.nextDouble() * (maxX - minX);
        double y = minY + random.nextDouble() * (maxY - minY);

        addShape(new MyCircle(x, y, Color.PURPLE));
    }

    @FXML
    public void moveDown(){
        for(GeometricShape shape : shapes){
            shape.moveDown(pane.getHeight());
        }
    }

    @FXML
    public void blueCircles(){
        for(GeometricShape shape : shapes){
            if(shape instanceof MyCircle){
                ((MyCircle) shape).setBlue();
            }
        }
    }
}
