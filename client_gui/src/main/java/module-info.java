module org.example.client_gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.client_gui to javafx.fxml;
    exports org.example.client_gui;
}