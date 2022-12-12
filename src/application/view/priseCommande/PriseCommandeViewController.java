package application.view.priseCommande;

import application.model.Panier;
import application.model.Stock;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.model.vendable.Type;
import application.model.vendable.Vendable;
import application.view.Menu;
import application.view.commande.GestionCommandeView;
import application.view.methodePayement.MethodePayementView;
import application.view.outils.ControllerEtPane;
import application.view.outils.SceneLoader;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import application.view.ViewController;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class PriseCommandeViewController extends ViewController {

    public CheckBox prixMembreCheckbox;
    public Button commandeBtn;
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

    @FXML
    private VBox listeTypeVBox;

    ArrayList<ProduitCommandeElement> produitControllerListe = new ArrayList<>();

    boolean isMenu = false;
    int etapeMenu = 0;
    TemplateOffre templateOffreSelectionner;

    public void initialize(){

        commandeBtn.setOnMouseClicked(mouseEvent -> afficherGestionCommande());

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
    public void initialisationSliderMenu() {

        ControllerEtPane controllerEtPane = SceneLoader.loadPane("/ressource/view/menu.fxml");
        Menu menuController = (Menu) controllerEtPane.getController();

        sliderMenu.getChildren().add(controllerEtPane.getPane());

        menuController.initialize(this, (Stage) ViewPriseCommande.getScene().getWindow());

        sliderMenu.setVisible(true);
        sliderMenu.setTranslateX(0);
        sliderPanier.setVisible(false);
        sliderPanier.setTranslateY(500);
    }

    /**
     * methode de création de case pour chaque type existant
     */
    public void InitialiserAffichageType() {

        for (Type type : Type.getTypeListe()) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(type.getName());
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> AffichagePlatType(type) );
            pane.setPadding(new Insets(50, 50, 50, 50));
            zoneAffichageType.getChildren().add(pane);
        }

        Pane pane = new Pane();
        Label label = new Label();
        label.setText("Menu");
        pane.getChildren().add(label);
        pane.setOnMouseClicked(event -> AffichageOffre());
        pane.setPadding(new Insets(50, 50, 50, 50));
        zoneAffichageType.getChildren().add(pane);
    }

    public void AffichageOffre(){
        isMenu = true;
        etapeMenu = 0;
        zoneAffichageType.getChildren().clear();
        for (TemplateOffre templateOffre : TemplateOffre.getTemplateOffreListe()) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(templateOffre.getNom());
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> AffichageTypeOffre(templateOffre) );
            pane.setPadding(new Insets(50, 50, 50, 50));
            zoneAffichageType.getChildren().add(pane);
        }

        afficherListeHorizontalType();
    }

    public void AffichageTypeOffre(TemplateOffre pTemplateOffre){
        templateOffreSelectionner = pTemplateOffre;
        zoneAffichageType.getChildren().clear();
        if (etapeMenu < pTemplateOffre.getCategorieListe().size()) {
            for (Type typeMenu : pTemplateOffre.getCategorieListe().get(etapeMenu).getTypeListe()) {
                Pane pane = new Pane();
                Label label = new Label();
                label.setText(typeMenu.getName());
                pane.getChildren().add(label);
                pane.setOnMouseClicked(event -> AffichagePlatTypeMenu(typeMenu));
                pane.setPadding(new Insets(50, 50, 50, 50));
                zoneAffichageType.getChildren().add(pane);
            }
            etapeMenu++;
        }
        else {
            getView().getController().ajouterAuPanier(templateOffreSelectionner);
            reinitialiserMenu();
        }
    }

    public void reinitialiserMenu(){
        isMenu = false;
        etapeMenu = 0;
        templateOffreSelectionner = null;
        getView().getController().AnnulerMenu();
    }

    public void afficherListeHorizontalType(){
        listeTypeVBox.getChildren().clear();
        for (Type type : Type.getTypeListe()) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(type.getName());
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> AffichagePlatType(type) );
            pane.setPadding(new Insets(20, 0, 0, 0));
            listeTypeVBox.getChildren().add(pane);
        }

        Pane pane = new Pane();
        Label label = new Label();
        label.setText("Menu");
        pane.getChildren().add(label);
        pane.setOnMouseClicked(event -> AffichageOffre());
        pane.setPadding(new Insets(50, 50, 50, 50));
        listeTypeVBox.getChildren().add(pane);
    }

    public void AffichagePlatType(Type pType) {

        if(pType==null)
            return;

        getView().getController().focusType(pType);

        reinitialiserMenu();
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

        afficherListeHorizontalType();
    }

    public void AffichagePlatTypeMenu(Type pType) {
        zoneAffichageType.getChildren().clear();
        produitControllerListe.clear();

        for(Produit produit : pType.getProduitListe()){
            ControllerEtPane controllerEtPane = SceneLoader.loadPane("/ressource/view/priseCommande/affichageProduit.fxml");

            ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
            if(Stock.getInstance().combienEnStock(produit)==0)
                controllerEtPane.getPane().setStyle("-fx-background-color: #BEBEBE");
            else{
                controllerEtPane.getPane().setOnMouseClicked(event -> AjouterProduitMenu(produit));
            }

            controller.initialize(produit);
            produitControllerListe.add(controller);
            zoneAffichageType.getChildren().add(controllerEtPane.getPane());
        }

        afficherListeHorizontalType();
    }

    public void AjouterAuPanier(Produit pProduit) {
        getView().getController().ajouterAuPanier(pProduit);
    }

    public void AjouterProduitMenu(Produit pProduit) {
        getView().getController().AjoutProduitMenu(pProduit);
    }


    /**
     * methode de redirection vers la page de methode de payement
     */
    public void redirectionMethodePayement() {
        try {
            MethodePayementView methodePayementView = new MethodePayementView();
            getView().changerPage((Stage) getViewPriseCommande().getScene().getWindow(), methodePayementView);
            methodePayementView.getController().setPanier(getView().getController().getPanier());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void rechargerProduit() {
        AffichagePlatType(getView().getController().getType());
    }


    public void afficherGestionCommande(){

       GestionCommandeView gestionCommandeView = new GestionCommandeView();
        try {
            gestionCommandeView.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setArticlePanier(Panier pPanier) {
        panierVBox.getChildren().clear();
        for(Vendable v : pPanier.getVendableListe()){
            Label produitLabel = new Label(v.getNom() + "    X1"+"    " +v.getPrixVente());
            produitLabel.setPadding(new Insets(0,2,0,0));
            panierVBox.getChildren().add(produitLabel);
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

}


