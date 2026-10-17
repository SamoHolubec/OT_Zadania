package com.example.animals;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Pane pane;
    @FXML
    private Button stopButton;

    private final List<Animal> animals = new ArrayList<>();
    private Timeline timeline;
    private boolean stopped = false;

    @FXML
    public void initialize() {
        timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void update() {
        double w = pane.getWidth();
        double h = pane.getHeight();
        for (Animal animal : animals) {
            if (animal.isMoving()) {
                animal.move(w, h);
            }
            animal.draw();
        }
    }

    private void addAnimal(Animal animal) {
        animal.setMoving(!stopped);
        animal.placeRandomly(pane.getWidth(), pane.getHeight());
        animal.draw();
        animals.add(animal);
        pane.getChildren().add(animal.getNode());
    }

    @FXML
    public void addHerbivore() {
        addAnimal(new Herbivore());
    }

    @FXML
    public void addCarnivore() {
        addAnimal(new Carnivore());
    }

    @FXML
    public void reverseCarnivores() {
        for (Animal animal : animals) {
            if (animal instanceof Carnivore) {
                ((Carnivore) animal).changeDirection();
            }
        }
    }

    @FXML
    public void toggleStop() {
        stopped = !stopped;
        for (Animal animal : animals) {
            animal.setMoving(!stopped);
        }
        stopButton.setText(stopped ? "Start" : "Stop");
    }
}