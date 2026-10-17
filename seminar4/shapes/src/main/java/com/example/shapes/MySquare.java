package com.example.shapes;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MySquare extends GeometricShape{
    public static final double size = 20;
    private final Rectangle node = new Rectangle(size, size);
    private double speed = 2;

    public MySquare(double x, double y, Color c){
        super(x, y, c);
        draw();
    }

    public void draw(){
        node.setX(x);
        node.setY(y);
        node.setFill(color);
    }

    public Node getNode(){
        return node;
    }

    public void move(double paneW, double paneH){
        y+=speed;
        if(y<50) {
            y = 50;
            speed = -speed;
        }else if(y + size > paneH){
            y=paneH-size;
            speed = -speed;
        }
    }
}
