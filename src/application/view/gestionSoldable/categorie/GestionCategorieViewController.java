package application.view.gestionSoldable.categorie;

import application.Model.Soldable.Categorie;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.crudCategorie.CrudCategorieView;
import application.view.gestionSoldable.produit.crudProduit.CrudProduitView;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.util.ArrayList;

public class GestionCategorieViewController extends ViewController {

    @FXML
    private BorderPane viewGestionCategorie;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private ListView<Categorie> listeCategorie;

    @FXML
    private Label titre;


    /**
     * methode pour animation du menu
     */
    public void openMenu(){
        if(!sliderMenu.isVisible()){
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderMenu);

            slide.setToX(0);
            slide.play();

            sliderMenu.setTranslateX(-176);
            sliderMenu.setVisible(true);
        }
        else {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderMenu);

            slide.setToX(-176);
            slide.play();

            sliderMenu.setTranslateX(0);
            slide.setOnFinished((ActionEvent e) -> {
                sliderMenu.setVisible(false);
            });
        }
    }

    public void ajouterCategorie() throws Exception {
        CrudCategorieView crudCategorieView = new CrudCategorieView();
        getView().changerScene(crudCategorieView);
    }

    public void redirectionPriseCommande() throws Exception {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerScene(priseCommandeView);
    }

    public GestionCategorieViewController(){}

    public GestionCategorieView getView(){
        return (GestionCategorieView) super.getView();
    }

    public BorderPane getViewGestionCategorie() {
        return viewGestionCategorie;
    }

    public ListView<Categorie> getListeCategorie() {
        return listeCategorie;
    }

    public void setListeCategorie(ArrayList<Categorie> listeCategorie) {
        this.listeCategorie.getItems().setAll(listeCategorie);
    }
}
