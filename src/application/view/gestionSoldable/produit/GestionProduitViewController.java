package application.view.gestionSoldable.produit;

import application.view.ViewController;
import application.view.gestionSoldable.categorie.crudCategorie.CrudCategorieView;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.gestionSoldable.produit.crudProduit.CrudProduitView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class GestionProduitViewController extends ViewController {

    @FXML
    private BorderPane viewGestionProduit;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private TabPane tablePromo;

    @FXML
    private ImageView ajouter;

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

    public void ajouterProduit() throws Exception {
        CrudProduitView crudProduitView = new CrudProduitView();
        getView().changerScene(crudProduitView,true);
    }

    public void redirectionPriseCommande() throws Exception {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerScene(priseCommandeView,false);
    }

    public GestionProduitViewController(){}

    public GestionProduitView getView(){
        return (GestionProduitView) super.getView();
    }

    public BorderPane getViewGestionProduit() {
        return viewGestionProduit;
    }
}
