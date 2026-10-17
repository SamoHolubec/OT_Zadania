package com.example.animals;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Carnivore extends Animal {
    private final Rectangle node = new Rectangle(size, size);

    public Carnivore() {
        super(55, 3, Color.RED);
    }

    @Override
    public void draw() {
        node.setX(x + size / 2);
        node.setY(y + size / 2);
        node.setFill(color);
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void move(double paneW, double paneH) {
        moveAlongEdges(paneW, paneH);
    }

    public void changeDirection() {
        direction = -direction;
    }
}