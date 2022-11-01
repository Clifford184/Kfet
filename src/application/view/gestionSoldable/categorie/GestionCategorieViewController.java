package application.view.gestionSoldable.categorie;

import application.view.ViewController;
import application.view.gestionSoldable.categorie.crudCategorie.CrudCategorieView;
import application.view.gestionSoldable.produit.crudProduit.CrudProduitView;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class GestionCategorieViewController extends ViewController {

    @FXML
    private BorderPane viewGestionCategorie;

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

    public void ajouterCategorie() throws Exception {
        CrudCategorieView crudCategorieView = new CrudCategorieView();
        getView().changerScene(crudCategorieView,true);
    }

    public void redirectionPriseCommande() throws Exception {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerScene(priseCommandeView,false);
    }

    public GestionCategorieViewController(){}

    public GestionCategorieView getView(){
        return (GestionCategorieView) super.getView();
    }

    public BorderPane getViewGestionCategorie() {
        return viewGestionCategorie;
    }
}
