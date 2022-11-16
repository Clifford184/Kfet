module Kfet {
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.fxml;
    requires java.logging;

    opens application to javafx.fxml;
    exports application;

    //model
    exports application.model to javafx.fxml;
    opens application.model;
    exports application.model.Client to javafx.fxml;
    opens application.model.Client;
    exports application.model.vendable to javafx.fxml;
    opens application.model.vendable;

    //view
    exports application.view to javafx.fxml;
    opens application.view;
    exports application.view.priseCommande to javafx.fxml;
    opens application.view.priseCommande;
    exports application.view.methodePayement to javafx.fxml;
    opens application.view.methodePayement;
    exports application.view.compte to javafx.fxml;
    opens application.view.compte;
    exports application.view.compte.DebitArgentCompte to javafx.fxml;
    opens application.view.compte.DebitArgentCompte;
    exports application.view.gestionSoldable.produit to javafx.fxml;
    opens application.view.gestionSoldable.produit;
    exports application.view.gestionSoldable.type.crudType to javafx.fxml;
    opens application.view.gestionSoldable.type.crudType;
    exports application.view.gestionSoldable.categorie to javafx.fxml;
    opens application.view.gestionSoldable.categorie;
    exports application.view.gestionSoldable.categorie.crudCategorie to javafx.fxml;
    opens application.view.gestionSoldable.categorie.crudCategorie;
    exports application.view.gestionSoldable.type to javafx.fxml;
    opens application.view.gestionSoldable.type;
    exports application.view.gestionSoldable.offre to javafx.fxml;
    opens application.view.gestionSoldable.offre;
    exports application.view.gestionSoldable.offre.crudOffre to javafx.fxml;
    opens application.view.gestionSoldable.offre.crudOffre;

    //controller
    exports application.controller to javafx.fxml;
    opens application.controller;
    exports application.controller.priseCommande to javafx.fxml;
    opens application.controller.priseCommande;
    exports application.controller.methodePayement to javafx.fxml;
    opens application.controller.methodePayement;
    exports application.controller.compte to javafx.fxml;
    opens application.controller.compte;
    exports application.controller.compte.DebitArgentCompte to javafx.fxml;
    opens application.controller.compte.DebitArgentCompte;
    exports application.view.gestionSoldable.produit.crudProduit to javafx.fxml;
    opens application.view.gestionSoldable.produit.crudProduit;
    exports application.controller.gestionSoldable.type to javafx.fxml;
    opens application.controller.gestionSoldable.type;
    exports application.controller.gestionSoldable.produit to javafx.fxml;
    opens application.controller.gestionSoldable.produit;
    exports application.controller.gestionSoldable.categorie to javafx.fxml;
    opens application.controller.gestionSoldable.categorie;
    exports application.controller.gestionSoldable.offre to javafx.fxml;
    opens application.controller.gestionSoldable.offre;


}