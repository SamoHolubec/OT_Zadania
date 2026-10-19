package com.example.space;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Satellite extends SpaceObject {
    private final Polygon node = new Polygon();
    private double dy;

    public Satellite() {
        super(Color.ORANGE);
        node.getPoints().addAll(
                size / 2, 0.0,
                size, size / 2,
                size / 2, size,
                0.0, size / 2
        );
        dy = (random.nextBoolean() ? 1 : -1) * (2 + random.nextDouble() * 2);
    }

    public void shiftRight(double amount) {
        x += amount;
    }

    @Override
    public void move(double paneW, double paneH) {
        y += dy;
        if (y <= 0 || y + size >= paneH) {
            dy = -dy;
        }
        if (x > paneW) {
            x = 0;
        }
    }

    @Override
    public void draw() {
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setFill(color);
    }

    @Override
    public Node getNode() {
        return node;
    }
}