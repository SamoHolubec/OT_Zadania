module com.example.animals {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animals to javafx.fxml;
    exports com.example.animals;
}