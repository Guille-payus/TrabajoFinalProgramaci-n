module com.guille {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.guille to javafx.fxml;
    exports com.guille;
}
