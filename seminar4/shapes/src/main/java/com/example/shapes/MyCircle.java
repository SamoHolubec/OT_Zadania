package com.example.shapes;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends GeometricShape{

    public static double r = 10;

    private Circle node = new Circle(r, color);
    private double angle = 0;

    public MyCircle(double x, double y, Color c){
        super(x, y, c);
        draw();
    }

    public void draw(){
        node.setCenterX(x);
        node.setCenterY(y);
        node.setFill(color);
    }

    public Node getNode(){
        return node;
    }

    public void move(double paneW, double paneH){
        x = x + 2 * Math.cos(angle);
        y = y + 2 * Math.sin(angle);
        angle += 0.1;
    }

    public void setBlue(){
        color = Color.BLUE;
    }
}
