package com.example.elevator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Pane pane;
    @FXML
    private Label infoLabel;

    private Elevator elevator;
    private Timeline timeline;

    @FXML
    public void initialize() {
        elevator = new Elevator();
        pane.getChildren().add(elevator.getNode());

        pane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(event -> {
                    String keyPressed = event.getText();
                    if (keyPressed.matches("[0-8]")) {
                        int requestedFloor = Integer.parseInt(keyPressed);
                        elevator.addRequest(requestedFloor);
                    }
                });
            }
        });

        timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void update() {
        elevator.update();
        elevator.draw();
        infoLabel.setText("Aktuálne poschodie: " + elevator.getNearestFloor());
    }
}