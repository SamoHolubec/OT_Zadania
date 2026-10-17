package com.example.animals;

import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Animal {
    public static final double size = 20;
    public static final double topBar = 50;

    protected double x;
    protected double y;
    protected Color color;
    protected double margin;
    protected double speed;
    protected double distance;
    protected int direction = 1;
    private boolean moving = true;
    private final Random random = new Random();

    public Animal(double margin, double speed, Color color) {
        this.margin = margin;
        this.speed = speed;
        this.color = color;
    }

    public abstract Node getNode();

    public abstract void draw();

    public abstract void move(double paneW, double paneH);

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private double trackW(double paneW) {
        return Math.max(1, paneW - 2 * margin - size);
    }

    private double trackH(double paneH) {
        return Math.max(1, paneH - topBar - 2 * margin - size);
    }

    public void placeRandomly(double paneW, double paneH) {
        double perimeter = 2 * (trackW(paneW) + trackH(paneH));
        distance = random.nextDouble() * perimeter;
        updatePosition(paneW, paneH);
    }

    protected void moveAlongEdges(double paneW, double paneH) {
        double perimeter = 2 * (trackW(paneW) + trackH(paneH));
        distance += direction * speed;
        if (distance >= perimeter) {
            distance -= perimeter;
        }
        if (distance < 0) {
            distance += perimeter;
        }
        updatePosition(paneW, paneH);
    }

    public void updatePosition(double paneW, double paneH) {
        double w = trackW(paneW);
        double h = trackH(paneH);
        double left = margin;
        double top = topBar + margin;

        if (distance < w) {
            x = left + distance;
            y = top;
        } else if (distance < w + h) {
            x = left + w;
            y = top + (distance - w);
        } else if (distance < 2 * w + h) {
            x = left + w - (distance - w - h);
            y = top + h;
        } else {
            x = left;
            y = top + h - (distance - 2 * w - h);
        }
    }
}