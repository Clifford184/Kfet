package application.view.priseCommande;

import application.model.Commande;
import application.model.Panier;
import application.model.Stock;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.model.vendable.Vendable;
import application.view.Menu;
import application.view.outils.ControllerEtPane;
import application.view.outils.SceneLoader;
import application.view.methodePayement.MethodePayementView;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import application.view.ViewController;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;


public class PriseCommandeViewController extends ViewController {

    public CheckBox prixMembreCheckbox;
    @FXML
    private BorderPane ViewPriseCommande;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private AnchorPane sliderPanier;

    @FXML
    private HBox zoneAffichageType;

    @FXML
    private VBox panierVBox;

    ArrayList<ProduitCommandeElement> produitControllerListe = new ArrayList<>();

    public void initialize(){
        prixMembreCheckbox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue){
                    for(ProduitCommandeElement c : produitControllerListe)
                        c.setPrixMembre();
                }else
                    for(ProduitCommandeElement c : produitControllerListe)
                        c.setPrixNormal();
            }
        });
    }

    /**
     * methode pour animation du menu
     */
    public void openMenu() {
//        if (!sliderMenu.isVisible()) {
//            TranslateTransition slide = new TranslateTransition();
//            slide.setDuration(Duration.seconds(0.4));
//            slide.setNode(sliderMenu);
//
//            slide.setToX(0);
//            slide.play();
//
//            sliderMenu.setTranslateX(-176);
//            sliderMenu.setVisible(true);
//        } else {
//            TranslateTransition slide = new TranslateTransition();
//            slide.setDuration(Duration.seconds(0.4));
//            slide.setNode(sliderMenu);
//
//            slide.setToX(-176);
//            slide.play();
//
//            sliderMenu.setTranslateX(0);
//            slide.setOnFinished((ActionEvent e) -> {
//                sliderMenu.setVisible(false);
//            });
//        }
    }

    /**
     * methode pour animation du panier
     */
    public void openPanier() {
        if (!sliderPanier.isVisible()) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderPanier);

            slide.setToY(0);
            slide.play();

            sliderPanier.setTranslateY(500);
            sliderPanier.setVisible(true);
        } else {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderPanier);

            slide.setToY(500);
            slide.play();

            sliderPanier.setTranslateY(0);
            slide.setOnFinished((ActionEvent e) -> {
                sliderPanier.setVisible(false);
            });
        }
    }

    /**
     * methode qui permet de cacher les slider a l'initialisation de la page
     */
    public void initialisationMenu() {

        ControllerEtPane controllerEtPane = SceneLoader.loadPane("/ressource/view/menu.fxml");
        Menu menuController = (Menu) controllerEtPane.getController();

        sliderMenu.getChildren().add(controllerEtPane.getPane());

        menuController.initialize(this, (Stage) ViewPriseCommande.getScene().getWindow());

//        sliderMenu.setVisible(false);
//        sliderMenu.setTranslateX(-176);
//        sliderPanier.setVisible(false);
//        sliderPanier.setTranslateY(500);
    }

    /**
     * methode de création de case pour chaque type existant
     */
    public void initialisationType() {

        for (Type type : Type.getTypeListe()) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(type.getName());
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> AffichagePlatType(type) );
            pane.setPadding(new Insets(50, 50, 50, 50));
            zoneAffichageType.getChildren().add(pane);
        }
    }

    public void AffichagePlatType(Type pType) {
        zoneAffichageType.getChildren().clear();
        produitControllerListe.clear();

        for(Produit produit : pType.getProduitListe()){

            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/priseCommande/affichageProduit.fxml");

            ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
            Pane pane = controllerEtPane.getPane();

            if(Stock.getInstance().combienEnStock(produit)==0)
                pane.setStyle("-fx-background-color: #BEBEBE");
            else{
                pane.setOnMouseClicked(event -> AjouterAuPanier(produit));
            }

            controller.initialize(produit);
            produitControllerListe.add(controller);
            zoneAffichageType.getChildren().add(pane);
        }
    }

    public void AjouterAuPanier(Produit pProduit) {
        getView().getController().ajouterAuPanier(pProduit);
    }


    /**
     * methode de redirection vers la page de methode de payement
     */
    public void redirectionMethodePayement() {
        try {
            MethodePayementView methodePayementView = new MethodePayementView();
            getView().changerPage(methodePayementView);
            methodePayementView.getController().setCommande(new Commande(getView().getController().getPanier()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * constructeur par défaut
     */
    public PriseCommandeViewController() {}

    /**
     * getter de la vue actuelle
     * @return PriseCommandeView la vue actuelle
     */
    @Override
    public PriseCommandeView getView() {
        return (PriseCommandeView) super.getView();
    }

    /**
     * getter de l'élément principal de la page (BorderPane)
     * @return BorderPane de la page
     */
    public BorderPane getViewPriseCommande() {
        return ViewPriseCommande;
    }

    public void setArticlePanier(Panier pPanier) {
        Vendable vendable = pPanier.getSoldableList().get(pPanier.getSoldableList().size()-1);
        Label produitLabel = new Label(vendable.getNom() + "    X1"+"    " +vendable.getPrixVente());
        produitLabel.setPadding(new Insets(0,2,0,0));
        panierVBox.getChildren().add(produitLabel);
    }
}


