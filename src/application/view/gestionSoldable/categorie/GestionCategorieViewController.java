package application.view.gestionSoldable.categorie;

import application.model.vendable.Categorie;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.crudCategorie.CrudCategorieView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
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
        menuController.initialize(this, (Stage) viewGestionCategorie.getScene().getWindow());
    }

    public void ajouterCategorie() throws Exception {
        CrudCategorieView crudCategorieView = new CrudCategorieView();
        getView().changerPage((Stage) getViewGestionCategorie().getScene().getWindow(), crudCategorieView);
    }

    public void redirectionPriseCommande() throws Exception {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerPage((Stage) getViewGestionCategorie().getScene().getWindow(), priseCommandeView);
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
