package application.view.gestionSoldable.offre;

import application.model.vendable.Categorie;
import application.model.vendable.Offre;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.offre.crudOffre.CrudOffreView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class GestionOffreViewController extends ViewController {

    public ImageView ajouterBtn;
    public ImageView modifierBtn;
    public TableView<TemplateOffre> offreTable;
    public TableColumn<TemplateOffre,String> nomOffreColonne;
    public TableColumn<TemplateOffre,String> catOffreColonne;
    @FXML
    private BorderPane viewGestionOffre;

    @FXML
    private AnchorPane sliderMenu;


    public void initialize(){
        ajouterBtn.setImage(new Image(getClass().getResource("/ressource/image/icone/ajouter.png").toString()));
        ajouterBtn.onMouseClickedProperty().set(mouseEvent -> ajouterOffre());

        modifierBtn.setImage(new Image(getClass().getResource("/ressource/image/icone/modifier.png").toString()));
        modifierBtn.onMouseClickedProperty().set(mouseEvent -> modifierOffre());

        nomOffreColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        catOffreColonne.setCellValueFactory(new PropertyValueFactory<>("categorieListe"));

        offreTable.getItems().addAll(TemplateOffre.templateOffreListe);

    }


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
        menuController.initialize(this, (Stage) viewGestionOffre.getScene().getWindow());
    }

    public void ajouterOffre(){
        CrudOffreView crudOffreView = new CrudOffreView();
        getView().changerPage((Stage) getViewGestionOffre().getScene().getWindow(), crudOffreView);
    }

    public void modifierOffre(){

        TemplateOffre p = offreTable.getSelectionModel().getSelectedItem();
        if(p==null)
            return;

        CrudOffreView crudProduitView = new CrudOffreView();
        getView().changerPage((Stage) getViewGestionOffre().getScene().getWindow(), crudProduitView);
        crudProduitView.getViewController().setContexteModification(p);
    }

    public void redirectionPriseCommande() throws Exception {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerPage((Stage) getViewGestionOffre().getScene().getWindow(), priseCommandeView);
    }

    public GestionOffreViewController(){}

    public GestionOffreView getView(){
        return (GestionOffreView) super.getView();
    }

    public BorderPane getViewGestionOffre() {
        return viewGestionOffre;
    }

}
