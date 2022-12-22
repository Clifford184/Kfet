package application.view.gestionSoldable.produit;

import application.model.vendable.Produit;
import application.view.Menu;
import application.view.ViewController;
import application.view.gestionSoldable.produit.crudProduit.CrudProduitView;
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

public class GestionProduitViewController extends ViewController {

    public ImageView ajouterProduitImageBtn;
    public ImageView ModifierProduitImageBtn;
    public TableColumn<Produit, String> nomColonne;
    public TableColumn<Produit, String> prixColonne;
    public TableColumn<Produit, String> prixMColonne;
    public TableView<Produit> produitTable;
    @FXML
    private BorderPane viewGestionProduit;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private Label titre;


    public void initialize(){

        ajouterProduitImageBtn.setImage(new Image(getClass().getResource("/ressource/image/icone/ajouter.png").toString()));
        ajouterProduitImageBtn.onMouseClickedProperty().set(mouseEvent -> ajouterProduit());

        ModifierProduitImageBtn.setImage(new Image(getClass().getResource("/ressource/image/icone/modifier.png").toString()));
        ModifierProduitImageBtn.onMouseClickedProperty().set(mouseEvent -> modifierProduit());

        nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prixColonne.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        prixMColonne.setCellValueFactory(new PropertyValueFactory<>("prixVenteMembre"));

        produitTable.getItems().addAll(Produit.produitListe);

        nomColonne.setResizable(false);
        prixColonne.setResizable(false);
        prixMColonne.setResizable(false);

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
        menuController.initialize(this, (Stage) viewGestionProduit.getScene().getWindow());
    }

    public void modifierProduit(){

        Produit p = produitTable.getSelectionModel().getSelectedItem();
        if(p==null)
            return;

        CrudProduitView crudProduitView = new CrudProduitView();
        getView().changerPage((Stage) getViewGestionProduit().getScene().getWindow(), crudProduitView);
        crudProduitView.getViewController().setContexteModification(p);
    }

    public void ajouterProduit() {
        CrudProduitView crudProduitView = new CrudProduitView();
        getView().changerPage((Stage) getViewGestionProduit().getScene().getWindow(), crudProduitView);
    }

    public void redirectionPriseCommande() {
        PriseCommandeView priseCommandeView = new PriseCommandeView();
        getView().changerPage((Stage) getViewGestionProduit().getScene().getWindow(), priseCommandeView);
    }

    public GestionProduitViewController(){}

    public GestionProduitView getView(){
        return (GestionProduitView) super.getView();
    }

    public BorderPane getViewGestionProduit() {
        return viewGestionProduit;
    }


}
