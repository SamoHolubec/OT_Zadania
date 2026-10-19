package com.example.space;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Pane pane;

    private final List<SpaceObject> objects = new ArrayList<>();
    private Timeline timeline;

    @FXML
    public void initialize() {
        timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void update() {
        double w = pane.getWidth();
        double h = pane.getHeight();
        if (w == 0 || h == 0) return;
        for (SpaceObject obj : objects) {
            obj.move(w, h);
            obj.draw();
        }
    }

    private void addObject(SpaceObject obj) {
        double w = pane.getWidth() > 0 ? pane.getWidth() : 800;
        double h = pane.getHeight() > 0 ? pane.getHeight() : 600;
        obj.placeRandomly(w, h);
        obj.draw();
        objects.add(obj);
        pane.getChildren().add(obj.getNode());
    }

    @FXML
    public void addPlanet() {
        addObject(new Planet());
    }

    @FXML
    public void addAsteroid() {
        addObject(new Asteroid());
    }

    @FXML
    public void addSatellite() {
        addObject(new Satellite());
    }

    @FXML
    public void makeAsteroidsRed() {
        for (SpaceObject obj : objects) {
            if (obj instanceof Asteroid) {
                ((Asteroid) obj).setColor(Color.RED);
            }
        }
    }

    @FXML
    public void shiftSatellitesRight() {
        for (SpaceObject obj : objects) {
            if (obj instanceof Satellite) {
                ((Satellite) obj).shiftRight(20);
            }
        }
    }
}