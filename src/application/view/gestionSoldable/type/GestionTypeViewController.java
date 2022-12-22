package application.view.gestionSoldable.type;

import application.model.vendable.Type;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class GestionTypeViewController extends ViewController {

    @FXML
    private BorderPane viewGestionType;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private ListView<Type> listeType;

    @FXML
    private ImageView ajouter;

    @FXML
    private Label titre;

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
        menuController.initialize(this, (Stage) viewGestionType.getScene().getWindow());
    }

    public void ajouterType() throws Exception {
        CrudTypeView crudTypeView = new CrudTypeView();
        getView().changerPage((Stage) getViewGestionType().getScene().getWindow(), crudTypeView);
    }

    public GestionTypeViewController(){}

    public GestionTypeView getView(){
        return (GestionTypeView) super.getView();
    }

    public BorderPane getViewGestionType() {
        return viewGestionType;
    }

    public ListView<Type> getListeType() {
        return listeType;
    }

    public void setListeType(ArrayList<Type> listeType) {
        this.listeType.getItems().setAll(listeType);
    }
}
