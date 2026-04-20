module com.trabajofinal_programacion {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.trabajofinal_programacion to javafx.fxml;
    exports com.trabajofinal_programacion;
}
