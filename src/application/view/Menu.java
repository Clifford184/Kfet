package application.view;

import application.model.Commande;
import application.view.compte.CompteView;
import application.view.gestionSoldable.categorie.GestionCategorieView;
import application.view.gestionSoldable.offre.GestionOffreView;
import application.view.gestionSoldable.produit.GestionProduitView;
import application.view.gestionSoldable.produit.stock.GestionStockView;
import application.view.gestionSoldable.type.GestionTypeView;
import application.view.methodePayement.MethodePayementView;
import application.view.priseCommande.PriseCommandeView;
import javafx.stage.Stage;

public class Menu {

    private ViewController viewController;
    private Stage stage;

    public void initialize(ViewController pViewController, Stage pStage) {
        viewController = pViewController;
        stage = pStage;
    }


    /**
     * methode de redirection vers la page de prise de commande
     */
    public void redirectionPriseCommande() {
        try {
            PriseCommandeView priseCommandeView = new PriseCommandeView();
            viewController.getView().changerPage(stage, priseCommandeView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des produits
     */
    public void redirectionGestionProduit() {
        try {
            GestionProduitView gestionProduitView = new GestionProduitView();
            viewController.getView().changerPage(stage, gestionProduitView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des types
     */
    public void redirectionGestionType() {
        try {
            GestionTypeView gestionTypeView = new GestionTypeView();
            viewController.getView().changerPage(stage, gestionTypeView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des catégories
     */
    public void redirectionGestionCategorie() {
        try {
            GestionCategorieView gestionCategorieView = new GestionCategorieView();
            viewController.getView().changerPage(stage, gestionCategorieView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des offres
     */
    public void redirectionGestionOffre() {
        try {
            GestionOffreView gestionOffreView = new GestionOffreView();
            viewController.getView().changerPage(stage, gestionOffreView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des comptes
     */
    public void redirectionCompte() {
        try {
            CompteView compteView = new CompteView();
            viewController.getView().changerPage(stage, compteView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion du stock
     */
    public void redirectionStock() {
        try {
            GestionStockView stockView = new GestionStockView();
            viewController.getView().changerPage(stage, stockView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
