module com.example.survey_system {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.survey_system to javafx.fxml;
    exports com.example.survey_system;
}