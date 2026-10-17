package com.example.shapes;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public abstract class GeometricShape {
    protected double x;
    protected double y;
    protected Color color;

    public GeometricShape(double x, double y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract Node getNode();

    public abstract void draw();

    public abstract void move(double paneW, double paneH);

    public void moveDown(double paneH){
        y+=30;
        if(y > paneH-30){
            y=paneH-40;
        }
    }
}
