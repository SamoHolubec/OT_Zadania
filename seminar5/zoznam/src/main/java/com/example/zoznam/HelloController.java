package com.example.zoznam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ListView<String> list;
    @FXML
    private TextField name;

    private ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    protected void initialize(){
        list.setItems(items);
    }

    @FXML
    protected void onAdd() {
        String textAdd = name.getText();
        if(textAdd != null && textAdd != ""){
            items.add(textAdd);
        }
        name.setText("");
    }

    @FXML
    protected void onRemove(){
        String textRem = list.getSelectionModel().getSelectedItem();
        if(textRem == null || textRem == "") return;
        items.remove(textRem);
    }

    @FXML
    protected void onUpdate(){
        String textUpdt = list.getSelectionModel().getSelectedItem();
        if(textUpdt == null || textUpdt == "") return;
        items.remove(textUpdt);
        String textAdd = name.getText();if(textAdd != null && textAdd != ""){
            items.add(textAdd);
        }
        name.setText("");
    }
}