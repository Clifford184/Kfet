package application.view.gestionSoldable.produit.stock;

import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.view.Menu;
import application.outils.ControllerEtPane;
import application.outils.SceneLoader;
import application.view.ViewController;
import application.view.utile.AlertView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GestionStockViewController extends ViewController {

    public VBox vboxStock;
    public HBox hboxType;
    public CheckBox checkboxModif;
    public Button buttonMenu;
    public Button validerModifButton;
    @FXML
    private AnchorPane viewGestionStock;
    @FXML
    private AnchorPane sliderMenu;

    boolean modifActivee = false;

    Type typeActuel;

    ArrayList<ProduitStockElementController> controllerProduitAfficheListe = new ArrayList<>();

    /**
     * Methode qui initialise les elements graphique de la vue
     */
    public void initialize(){

        for(Type type : Type.getTypeListe()){
            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/gestionSoldable/stock/stockTypeElement.fxml");

            TypeStockElementController controller = (TypeStockElementController) controllerEtPane.getController();
            controller.initialize(type);
            controllerEtPane.getPane().setOnMouseClicked(event -> focusType(type));
            hboxType.getChildren().add(controllerEtPane.getPane());
        }
        if(Type.getTypeListe().size()>0)
            focusType(Type.getTypeListe().get(0));

        validerModifButton.setVisible(false);
        checkboxModif.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                modifActivee = newValue;
                focusType(typeActuel);
                validerModifButton.setVisible(modifActivee);
            }
        });

        validerModifButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for(ProduitStockElementController controller : controllerProduitAfficheListe){
                    controller.validerAjoutStock();
                }
            }
        });
    }

    /**
     * Affiche la liste des produits correspondant a un type.
     * Les produits sont automatiquement decoche si ils sont deja present
     * dans la blacklist
     * @param pType le type dont les produits sont a afficher
     */
    public void focusType(Type pType){
        typeActuel = pType;
        vboxStock.getChildren().clear();
        controllerProduitAfficheListe.clear();

        for(Produit produit : pType.getProduitListe()){
            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/gestionSoldable/stock/stockProduitElement.fxml");

            ProduitStockElementController controller = (ProduitStockElementController) controllerEtPane.getController();
            controller.initialize(produit,modifActivee);
            controllerProduitAfficheListe.add(controller);
            vboxStock.getChildren().add(controllerEtPane.getPane());
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
            alertView.getController().setMessage("Echec initialisation du menu");
        }
        sliderMenu.getChildren().add(vboxMenu);

        Menu menuController = loader.getController();
        menuController.initialize(this, (Stage) viewGestionStock.getScene().getWindow());
    }

    public GestionStockView getView() {
        return (GestionStockView) super.getView();
    }

    public AnchorPane getViewGestionStock() {
        return viewGestionStock;
    }
}
