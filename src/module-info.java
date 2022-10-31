module Kfet {
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.fxml;

    opens application to javafx.fxml;
    exports application;

    //model
    exports application.Model to javafx.fxml;
    opens application.Model;
    exports application.Model.Client to javafx.fxml;
    opens application.Model.Client;
    exports application.Model.Soldable to javafx.fxml;
    opens application.Model.Soldable;

    //view
    exports application.view to javafx.fxml;
    opens application.view;
    exports application.view.priseCommande to javafx.fxml;
    opens application.view.priseCommande;
    exports application.view.methodePayement to javafx.fxml;
    opens application.view.methodePayement;
    exports application.view.compte to javafx.fxml;
    opens application.view.compte;
    exports application.view.compte.argentConfirmation to javafx.fxml;
    opens application.view.compte.argentConfirmation;

    //controller
    exports application.controller to javafx.fxml;
    opens application.controller;
    exports application.controller.priseCommande to javafx.fxml;
    opens application.controller.priseCommande;
    exports application.controller.methodePayement to javafx.fxml;
    opens application.controller.methodePayement;
    exports application.controller.compte to javafx.fxml;
    opens application.controller.compte;
    exports application.controller.compte.argentConfirmation to javafx.fxml;
    opens application.controller.compte.argentConfirmation;
}