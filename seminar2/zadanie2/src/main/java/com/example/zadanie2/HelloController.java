package com.example.zadanie2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField tfheight, tfweight;
    @FXML
    private Label lblresult;

    @FXML
    protected void calculate(){
        float h =  (float) Integer.parseInt(tfheight.getText()) /100;
        int  w = Integer.parseInt(tfweight.getText());

        float bmi =  w /(h*h);
        if(bmi < 18.5){
            lblresult.setText("podvaha");
        }else if (18.5 <= bmi && bmi <= 24.9) {
            lblresult.setText("normalna");
        } else if (25 <= bmi && bmi <= 29.9) {
            lblresult.setText("nadvaha");
        }else {
            lblresult.setText("obezita");
        }
    }
}
