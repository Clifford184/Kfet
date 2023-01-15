package application.view.gestionSoldable.type;

import application.model.vendable.Type;
import application.outils.ImageManager;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.utile.AlertView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GestionTypeViewController extends ViewController {

    public ImageView ajouterImage;
    public ImageView modifierImage;
    public TableColumn<Type,String> nomTypeColonne;
    public TableColumn<Type,String> produitTypeColonne;

    public TableView<Type> typeTable;
    @FXML
    private BorderPane viewGestionType;

    @FXML
    private AnchorPane sliderMenu;
    @FXML
    private Label titre;

    /**
     * Methode qui initialise les elements graphique de la vue
     */
    public void initialize(){

        ajouterImage.setImage(ImageManager.chargerImage("/ressource/image/icone/ajouter.png"));
        ajouterImage.setOnMouseClicked(mouseEvent -> ajouterType());

        modifierImage.setImage(ImageManager.chargerImage("/ressource/image/icone/modifier.png"));
        modifierImage.setOnMouseClicked(mouseEvent -> modifierType());

        nomTypeColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        produitTypeColonne.setCellValueFactory(new PropertyValueFactory<>("produitListe"));

        typeTable.getItems().addAll(Type.getTypeListe());

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
            AlertView alertView = new AlertView();
            getView().genererNouvellePage(alertView);
            alertView.getController().setMessage("Echec initialisation menu");
        }
        sliderMenu.getChildren().add(vboxMenu);

        Menu menuController = loader.getController();
        menuController.initialize(this, (Stage) viewGestionType.getScene().getWindow());
    }

    /**
     * Methode qui redirige vers la page de creation de type
     */
    public void ajouterType() {
        CrudTypeView crudTypeView = new CrudTypeView();
        getView().changerPage((Stage) getViewGestionType().getScene().getWindow(), crudTypeView);
    }

    /**
     * Methode qui redirige vers la page de modification de type
     */
    public void modifierType(){

        Type p = typeTable.getSelectionModel().getSelectedItem();
        if(p==null)
            return;

        CrudTypeView crudTypeView = new CrudTypeView();
        getView().changerPage((Stage) getViewGestionType().getScene().getWindow(), crudTypeView);
        crudTypeView.getViewController().setContexteModification(p);

    }

    public GestionTypeViewController(){}

    public GestionTypeView getView(){
        return (GestionTypeView) super.getView();
    }

    public BorderPane getViewGestionType() {
        return viewGestionType;
    }

}
