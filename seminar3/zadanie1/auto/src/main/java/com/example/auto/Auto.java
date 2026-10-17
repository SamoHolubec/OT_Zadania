package com.example.auto;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto extends Canvas {

    private static final double sirka_auta = 80;
    private static final double vyska_auta = 40;
    private static final double horny_okraj = 80;
    private static final double rychlost_manual = 8;
    private static final double rychlost_auto = 3;

    private GraphicsContext gc;
    private Timeline t;
    private boolean bezi = false;
    private boolean manual = true;
    private double x = 50;
    private double smer = 1;

    private final EventHandler<KeyEvent> keyHandler = e -> {
        if (e.getCode() != KeyCode.LEFT && e.getCode() != KeyCode.RIGHT) {
            return;
        }
        e.consume();
        if (!manual) {
            return;
        }
        if (e.getCode() == KeyCode.LEFT) {
            x -= rychlost_manual;
        } else {
            x += rychlost_manual;
        }
        x = Math.max(0, Math.min(x, getWidth() - sirka_auta));
        vykresli();
    };

    public Auto() {
        gc = getGraphicsContext2D();

        widthProperty().addListener(e -> vykresli());
        heightProperty().addListener(e -> vykresli());

        setOnMousePressed(e -> {
            boolean naAute = e.getX() >= x && e.getX() <= x + sirka_auta
                    && e.getY() >= horny_okraj && e.getY() <= horny_okraj + vyska_auta;
            if (!manual && naAute) {
                start();
            }
        });

        t = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            x += smer * rychlost_auto;
            if (x <= 0) {
                x = 0;
                smer = 1;
            } else if (x + sirka_auta >= getWidth()) {
                x = getWidth() - sirka_auta;
                smer = -1;
            }
            vykresli();
        }));
        t.setCycleCount(Timeline.INDEFINITE);
    }

    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }

    public void start() {
        if (bezi) {
            t.stop();
            bezi = false;
        } else {
            t.play();
            bezi = true;
        }
    }

    public void setAuto() {
        manual = false;
        t.play();
        bezi = true;
    }

    public void setManual() {
        manual = true;
        t.stop();
        bezi = false;
    }

    private void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(Color.CRIMSON);
        gc.fillRect(x, horny_okraj, sirka_auta, vyska_auta);
    }
}