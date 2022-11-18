package application.view.gestionSoldable.offre;

import application.model.vendable.Categorie;
import application.model.vendable.Offre;
import application.view.ViewController;
import application.view.gestionSoldable.offre.crudOffre.CrudOffreView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.util.ArrayList;

public class GestionOffreViewController extends ViewController {

    @FXML
    private BorderPane viewGestionOffre;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private ListView<Offre> listeOffre;


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

    public void ajouterOffre() throws Exception {
        CrudOffreView crudOffreView = new CrudOffreView();
        getView().changerScene(crudOffreView);
    }

    public void redirectionPriseCommande() throws Exception {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerScene(priseCommandeView);
    }

    public GestionOffreViewController(){}

    public GestionOffreView getView(){
        return (GestionOffreView) super.getView();
    }

    public BorderPane getViewGestionOffre() {
        return viewGestionOffre;
    }

    public ListView<Offre> getListeOffre() {
        return listeOffre;
    }

    public void setListeOffre(ArrayList<Offre> listeCategorie) {
        this.listeOffre.getItems().setAll(listeCategorie);
    }
}
