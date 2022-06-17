module com.example.javaprojektfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.javaprojektfx to javafx.fxml;
    opens com.example.javaprojektfx.model to javafx.fxml;
    exports com.example.javaprojektfx;
    exports com.example.javaprojektfx.controller;
    exports com.example.javaprojektfx.model;
    opens com.example.javaprojektfx.controller to javafx.fxml;
}