package com.example.space;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import java.util.Random;

public abstract class SpaceObject {
    public static final double size = 20;

    protected double x;
    protected double y;
    protected Color color;
    protected final Random random = new Random();

    public SpaceObject(Color color) {
        this.color = color;
    }

    public abstract Node getNode();

    public abstract void draw();

    public abstract void move(double paneW, double paneH);

    public void placeRandomly(double paneW, double paneH) {
        x = random.nextDouble() * Math.max(1, (paneW - size));
        y = random.nextDouble() * Math.max(1, (paneH - size));
    }
}