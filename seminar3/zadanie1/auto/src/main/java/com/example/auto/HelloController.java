package com.example.auto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane pane;

    @FXML
    private Button btnmanual, btnauto;

    private Auto auto;

    @FXML
    public void initialize() {
        auto = new Auto();
        auto.widthProperty().bind(pane.widthProperty());
        auto.heightProperty().bind(pane.heightProperty());
        pane.getChildren().add(0, auto);

        pane.sceneProperty().addListener((obs, stara, scena) -> {
            if (scena != null) {
                scena.addEventFilter(KeyEvent.KEY_PRESSED, auto.getKeyHandler());
            }
        });
    }

    @FXML
    protected void setAuto() {
        auto.setAuto();
    }

    @FXML
    protected void setManual() {
        auto.setManual();
    }
}