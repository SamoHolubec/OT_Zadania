module com.example.space {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.space to javafx.fxml;
    exports com.example.space;
}