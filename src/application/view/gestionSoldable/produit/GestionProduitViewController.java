package application.view.gestionSoldable.produit;

import application.model.vendable.Produit;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.crudCategorie.CrudCategorieView;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.gestionSoldable.produit.crudProduit.CrudProduitView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class GestionProduitViewController extends ViewController {

    @FXML
    private BorderPane viewGestionProduit;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private ListView<Produit> listeProduit;

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

    public void initialisationMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/menu.fxml"));
        VBox vboxMenu = null;
        try {
            vboxMenu = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sliderMenu.getChildren().add(vboxMenu);

        Menu menuController = loader.getController();
        menuController.initialize(this, (Stage) viewGestionProduit.getScene().getWindow());
    }

    public void ajouterProduit() {
        CrudProduitView crudProduitView = new CrudProduitView();
        getView().changerScene(crudProduitView);
    }

    public void redirectionPriseCommande() {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerScene(priseCommandeView);
    }

    public GestionProduitViewController(){}

    public GestionProduitView getView(){
        return (GestionProduitView) super.getView();
    }

    public BorderPane getViewGestionProduit() {
        return viewGestionProduit;
    }

    public ListView<Produit> getListeProduit() {
        return listeProduit;
    }

    public void setListeProduit(ArrayList<Produit> listeProduit) {
        this.listeProduit.getItems().setAll(listeProduit);
    }
}
