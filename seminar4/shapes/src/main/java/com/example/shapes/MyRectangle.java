package com.example.shapes;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends GeometricShape {
    public static double w = 40;
    public static double h = 20;
    private double speed = 2;

    private final Rectangle node = new Rectangle(w, h);

    public MyRectangle(double x, double y, Color c){
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
        x+=speed;
        if(x<0){
            x = 0;
            speed = -speed;
        }else if(x+w>paneW){
            x=paneW-w;
            speed = -speed;
        }
    }
}

