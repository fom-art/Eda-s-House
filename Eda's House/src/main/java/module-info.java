module com.example.edashouse {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.edashouse to javafx.fxml;
    exports com.example.edashouse.controller;
    exports com.example.edashouse.view;
    exports com.example.edashouse.model.constants;
    exports com.example.edashouse.model.utils;
    exports com.example.edashouse.model.constants.characters;
    exports com.example.edashouse.model.constants.characters_data;
    exports com.example.edashouse.model.constants.utils;
}