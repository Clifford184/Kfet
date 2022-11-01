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
//    exports application.view.gestionSoldable to javafx.fxml;
//    opens application.view.gestionSoldable;
    exports application.view.gestionSoldable.produit to javafx.fxml;
    opens application.view.gestionSoldable.produit;
    exports application.view.gestionSoldable.type.crudType to javafx.fxml;
    opens application.view.gestionSoldable.type.crudType;
    exports application.view.gestionSoldable.categorie to javafx.fxml;
    opens application.view.gestionSoldable.categorie;
    exports application.view.gestionSoldable.type to javafx.fxml;
    opens application.view.gestionSoldable.type;

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
//    exports application.controller.gestionSoldable to javafx.fxml;
//    opens application.controller.gestionSoldable;
    exports application.view.gestionSoldable.produit.crudProduit to javafx.fxml;
    opens application.view.gestionSoldable.produit.crudProduit;
    exports application.controller.gestionSoldable.type to javafx.fxml;
    opens application.controller.gestionSoldable.type;
    exports application.controller.gestionSoldable.produit to javafx.fxml;
    opens application.controller.gestionSoldable.produit;
    exports application.controller.gestionSoldable.categorie to javafx.fxml;
    opens application.controller.gestionSoldable.categorie;
    exports application.view.gestionSoldable.categorie.crudCategorie to javafx.fxml;
    opens application.view.gestionSoldable.categorie.crudCategorie;
}