package com.example.space;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Asteroid extends SpaceObject {
    private final Rectangle node = new Rectangle(size, size);
    private double dx;
    private double dy;

    public Asteroid() {
        super(Color.GRAY);
        dx = (random.nextBoolean() ? 1 : -1) * (1 + random.nextDouble() * 2);
        dy = (random.nextBoolean() ? 1 : -1) * (1 + random.nextDouble() * 2);
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    @Override
    public void move(double paneW, double paneH) {
        x += dx;
        y += dy;
        if (x <= 0 || x + size >= paneW) {
            dx = -dx;
        }
        if (y <= 0 || y + size >= paneH) {
            dy = -dy;
        }
    }

    @Override
    public void draw() {
        node.setX(x);
        node.setY(y);
        node.setFill(color);
    }

    @Override
    public Node getNode() {
        return node;
    }
}