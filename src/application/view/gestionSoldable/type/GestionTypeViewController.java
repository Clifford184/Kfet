package application.view.gestionSoldable.type;

import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.produit.crudProduit.CrudProduitView;
import application.view.gestionSoldable.type.crudType.CrudTypeView;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

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


    public void initialize(){

        ajouterImage.setImage(new Image(getClass().getResource("/ressource/image/icone/ajouter.png").toString()));
        ajouterImage.onMouseClickedProperty().set(mouseEvent -> ajouterType());

        modifierImage.setImage(new Image(getClass().getResource("/ressource/image/icone/modifier.png").toString()));
        modifierImage.onMouseClickedProperty().set(mouseEvent -> modifierType());

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

    public void ajouterType() {
        CrudTypeView crudTypeView = new CrudTypeView();
        getView().changerPage((Stage) getViewGestionType().getScene().getWindow(), crudTypeView);
    }

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
