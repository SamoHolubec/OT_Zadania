package com.example.space;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Planet extends SpaceObject {
    private final Circle node = new Circle(size / 2);
    private double angle;
    private final double orbitRadius = 60;
    private double centerX;
    private double centerY;
    private final double speed = 0.03;

    public Planet() {
        super(Color.BLUE);
        angle = random.nextDouble() * 2 * Math.PI;
    }

    @Override
    public void placeRandomly(double paneW, double paneH) {
        centerX = orbitRadius + random.nextDouble() * Math.max(1, (paneW - 2 * orbitRadius));
        centerY = orbitRadius + random.nextDouble() * Math.max(1, (paneH - 2 * orbitRadius));
        updatePosition();
    }

    private void updatePosition() {
        x = centerX + orbitRadius * Math.cos(angle);
        y = centerY + orbitRadius * Math.sin(angle);
    }

    @Override
    public void move(double paneW, double paneH) {
        angle += speed;
        updatePosition();
    }

    @Override
    public void draw() {
        node.setCenterX(x);
        node.setCenterY(y);
        node.setFill(color);
    }

    @Override
    public Node getNode() {
        return node;
    }
}