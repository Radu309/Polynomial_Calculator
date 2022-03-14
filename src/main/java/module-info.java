module com.example.ex.assigment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ex.assigment1 to javafx.fxml;
    exports com.example.ex.assigment1;
    exports Methods;
    opens Methods to javafx.fxml;
}