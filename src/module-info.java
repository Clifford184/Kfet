module Kfet {
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.fxml;

    opens application to javafx.fxml;
    exports application;

    //model
    /*
    exports application.model to javafx.fxml;
    opens application.model;
    */

    //view
    exports application.view to javafx.fxml;
    opens application.view;
    exports application.view.priseCommande to javafx.fxml;
    opens application.view.priseCommande;

    //controller
    exports application.controller to javafx.fxml;
    opens application.controller;
}