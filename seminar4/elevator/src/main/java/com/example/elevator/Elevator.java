package com.example.elevator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final Rectangle node;
    private double x = 150;
    private double y;
    private double speed = 2.0;

    private int currentFloor = 0;
    private int targetFloor = 0;
    private boolean moving = false;
    private int waitFrames = 0;

    private final List<Integer> requests = new ArrayList<>();

    public Elevator() {
        node = new Rectangle(50, 40);
        node.setFill(Color.RED);
        this.y = getFloorY(0);
        draw();
    }

    public Rectangle getNode() {
        return node;
    }

    public void addRequest(int floor) {
        requests.add(floor);
    }

    public int getNearestFloor() {
        return (int) Math.round((450 - y) / 50.0);
    }

    public void update() {
        if (waitFrames > 0) {
            waitFrames--;
            return;
        }

        if (!moving && !requests.isEmpty()) {
            targetFloor = requests.remove(0);
            if (targetFloor != currentFloor) {
                moving = true;
            }
        }

        if (moving) {
            double targetY = getFloorY(targetFloor);

            if (y < targetY) {
                y += speed;
                if (y >= targetY) {
                    y = targetY;
                    finishMove();
                }
            } else if (y > targetY) {
                y -= speed;
                if (y <= targetY) {
                    y = targetY;
                    finishMove();
                }
            } else {
                finishMove();
            }
        }
    }

    private void finishMove() {
        currentFloor = targetFloor;
        moving = false;
        waitFrames = 100;
    }

    public void draw() {
        node.setX(x);
        node.setY(y);
    }

    private double getFloorY(int floor) {
        return 450 - (floor * 50);
    }
}