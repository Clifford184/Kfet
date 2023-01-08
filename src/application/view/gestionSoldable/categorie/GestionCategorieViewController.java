package application.view.gestionSoldable.categorie;

import application.model.vendable.Categorie;
import application.model.vendable.Type;
import application.outils.ImageManager;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.crudCategorie.CrudCategorieView;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
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

public class GestionCategorieViewController extends ViewController {

    public ImageView ajouterImage;
    public ImageView modifierImage;
    public TableColumn<Categorie, String> nomCategorieColonne;
    public TableColumn<Categorie, String> listeTypeColonne;
    public TableView<Categorie> categorieTable;
    @FXML
    private BorderPane viewGestionCategorie;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private ListView<Categorie> listeCategorie;

    @FXML
    private Label titre;


    /**
     * Methode qui initialise les elements graphique de la vue
     */
    public void initialize(){

        ajouterImage.setImage(ImageManager.genererImage("/ressource/image/icone/ajouter.png"));
        ajouterImage.setOnMouseClicked(mouseEvent -> ajouterCategorie());

        modifierImage.setImage(ImageManager.genererImage("/ressource/image/icone/modifier.png"));
        modifierImage.setOnMouseClicked(mouseEvent -> modifierCategorie());

        nomCategorieColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        listeTypeColonne.setCellValueFactory(new PropertyValueFactory<>("typeListe"));

        categorieTable.getItems().addAll(Categorie.categorieListe);

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

    /**
     * Methode qui initialise le menu sur la vue
     */
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

    /**
     * Methode qui redirige vers la page d'ajout de categorie
     */
    public void ajouterCategorie(){
        CrudCategorieView crudCategorieView = new CrudCategorieView();
        getView().changerPage((Stage) getViewGestionCategorie().getScene().getWindow(), crudCategorieView);
    }

    /**
     * Methode qui redirige vers la page de modification de categorie
     */
    public void modifierCategorie(){

        Categorie p = categorieTable.getSelectionModel().getSelectedItem();
        if(p==null)
            return;

        CrudCategorieView crudTypeView = new CrudCategorieView();
        getView().changerPage((Stage) getViewGestionCategorie().getScene().getWindow(), crudTypeView);
        crudTypeView.getViewController().setContexteModification(p);

    }

    public GestionCategorieViewController(){}

    public GestionCategorieView getView(){
        return (GestionCategorieView) super.getView();
    }

    public BorderPane getViewGestionCategorie() {
        return viewGestionCategorie;
    }

}
