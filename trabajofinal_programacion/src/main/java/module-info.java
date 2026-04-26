module com.trabajofinal_programacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires com.google.gson;

    opens com.trabajofinal_programacion to javafx.fxml;
    opens com.trabajofinal_programacion.controller to javafx.fxml;
    opens com.trabajofinal_programacion.model to com.google.gson;

    exports com.trabajofinal_programacion;
}