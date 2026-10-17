package com.example.animals;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Herbivore extends Animal {
    private final Circle node = new Circle(size / 2);

    public Herbivore() {
        super(15, 1.5, Color.GREEN);
    }

    @Override
    public void draw() {
        node.setCenterX(x + size / 2);
        node.setCenterY(y + size / 2);
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
}