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
    exports application.view.methodePayement to javafx.fxml;
    opens application.view.methodePayement;
    exports application.view.compte to javafx.fxml;
    opens application.view.compte;

    //controller
    exports application.controller to javafx.fxml;
    opens application.controller;
    exports application.controller.priseCommande to javafx.fxml;
    opens application.controller.priseCommande;
    exports application.controller.methodePayement to javafx.fxml;
    opens application.controller.methodePayement;
    exports application.controller.compte to javafx.fxml;
    opens application.controller.compte;
}