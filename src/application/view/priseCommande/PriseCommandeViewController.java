package application.view.priseCommande;

import application.model.Panier;
import application.model.Stock;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.model.vendable.Type;
import application.model.vendable.Vendable;
import application.outils.ControllerEtPane;
import application.outils.SceneLoader;
import application.view.Menu;
import application.view.ViewController;
import application.view.commande.GestionCommandeView;
import application.view.methodePayement.MethodePayementView;
import application.view.utile.AlertView;
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

    /**
     * Initialise la vue avec les produits et event de clique
     */
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
        if (!sliderMenu.isVisible()) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderMenu);

            slide.setToX(0);
            slide.play();

            sliderMenu.setTranslateX(-176);
            sliderMenu.setVisible(true);
        } else {
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
    public void initialiserAffichageType() {

        for (Type type : Type.getTypeListe()) {
            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/priseCommande/affichageElement.fxml");

            ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
            Pane pane = controllerEtPane.getPane();
            pane.setOnMouseClicked(event -> affichagePlatType(type) );
            controller.initialize(type);
            zoneAffichageType.getChildren().add(pane);
        }

        ControllerEtPane controllerEtPane =
                SceneLoader.loadPane("/ressource/view/priseCommande/affichageElement.fxml");

        ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
        Pane pane = controllerEtPane.getPane();
        pane.setOnMouseClicked(event -> affichageOffre());
        controller.initializeOffre();
        zoneAffichageType.getChildren().add(pane);

    }

    /**
     * Affichage les offres disponible
     */
    public void affichageOffre(){
        produitControllerListe.clear();
        isMenu = true;
        etapeMenu = 0;
        zoneAffichageType.getChildren().clear();
        for (TemplateOffre templateOffre : TemplateOffre.getTemplateOffreListe()) {

            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/priseCommande/affichageElement.fxml");

            ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
            Pane pane = controllerEtPane.getPane();
            pane.setOnMouseClicked(event -> affichageTypeOffre(templateOffre) );
            controller.initialize(templateOffre, !prixMembreCheckbox.isSelected());
            zoneAffichageType.getChildren().add(pane);

            produitControllerListe.add(controller);

        }

        afficherListeHorizontalType();
    }

    /**
     * Affiche les types de produits de l'offre selectionne
     * @param pTemplateOffre offre selectionne
     */
    public void affichageTypeOffre(TemplateOffre pTemplateOffre){
        templateOffreSelectionner = pTemplateOffre;
        zoneAffichageType.getChildren().clear();
        if (etapeMenu < pTemplateOffre.getCategorieListe().size()) {
            for (Type typeMenu : pTemplateOffre.getCategorieListe().get(etapeMenu).getTypeListe()) {

                ControllerEtPane controllerEtPane =
                        SceneLoader.loadPane("/ressource/view/priseCommande/affichageElement.fxml");

                ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
                Pane pane = controllerEtPane.getPane();
                pane.setOnMouseClicked(event -> affichagePlatTypeMenu(typeMenu));
                controller.initialize(typeMenu);
                zoneAffichageType.getChildren().add(pane);
            }
            etapeMenu++;
        }
        else {
            try {
                getView().getController().ajouterAuPanier(templateOffreSelectionner);
                reinitialiserMenu();
            }catch (Exception e){
                AlertView alertView = new AlertView();
                getView().genererNouvellePage(alertView);
                alertView.getController().setMessage("Echec de ajout de offre au panier"+e.getMessage());
            }
        }
    }

    /**
     * Renitialise a l'etat initiale l'offre si on quitte l'offre sans la complete
     */
    public void reinitialiserMenu(){
        isMenu = false;
        etapeMenu = 0;
        templateOffreSelectionner = null;
        getView().getController().AnnulerMenu();
    }

    /**
     * Affichage des Autres Types possible en liste horizontal à droite
     */
    public void afficherListeHorizontalType(){
        listeTypeVBox.getChildren().clear();
        for (Type type : Type.getTypeListe()) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(type.getNom());
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> affichagePlatType(type) );
            pane.setPadding(new Insets(20, 0, 0, 0));
            listeTypeVBox.getChildren().add(pane);
        }

        Pane pane = new Pane();
        Label label = new Label();
        label.setText("Menu");
        pane.getChildren().add(label);
        pane.setOnMouseClicked(event -> affichageOffre());
        pane.setPadding(new Insets(50, 50, 50, 50));
        listeTypeVBox.getChildren().add(pane);
    }

    /**
     * Affiche tout les produits d'un type selectionne
     * @param pType le type selectionne
     */
    public void affichagePlatType(Type pType) {

        if(pType==null)
            return;

        getView().getController().focusType(pType);

        reinitialiserMenu();
        zoneAffichageType.getChildren().clear();
        produitControllerListe.clear();

        for(Produit produit : pType.getProduitListe()) {
                ControllerEtPane controllerEtPane =
                        SceneLoader.loadPane("/ressource/view/priseCommande/affichageElement.fxml");

                ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
                Pane pane = controllerEtPane.getPane();

                if (Stock.getInstance().combienEnStock(produit) == 0)
                    pane.setStyle("-fx-background-color: #BEBEBE");
                else {
                    pane.setOnMouseClicked(event -> ajouterAuPanier(produit));
                }

                controller.initialize(produit, !prixMembreCheckbox.isSelected());
                produitControllerListe.add(controller);
                zoneAffichageType.getChildren().add(pane);
        }
        afficherListeHorizontalType();
    }

    /**
     * Affichage de tout les produits d'un type pour un menu
     * @param pType type selectionne
     */
    public void affichagePlatTypeMenu(Type pType) {
        zoneAffichageType.getChildren().clear();
        produitControllerListe.clear();

        for(Produit produit : pType.getProduitListe()) {
            if (!templateOffreSelectionner.getBlackList().contains(produit)) {
                ControllerEtPane controllerEtPane = SceneLoader.loadPane("/ressource/view/priseCommande/affichageElement.fxml");

                ProduitCommandeElement controller = (ProduitCommandeElement) controllerEtPane.getController();
                if (Stock.getInstance().combienEnStock(produit) == 0)
                    controllerEtPane.getPane().setStyle("-fx-background-color: #BEBEBE");
                else {
                    controllerEtPane.getPane().setOnMouseClicked(event -> ajouterProduitMenu(produit));
                }

                controller.initialize(produit, !prixMembreCheckbox.isSelected());
                produitControllerListe.add(controller);
                zoneAffichageType.getChildren().add(controllerEtPane.getPane());
            }
        }

        afficherListeHorizontalType();
    }

    /**
     * Ajoute le produit choisi au panier
     * @param pProduit produit selectionne
     */
    public void ajouterAuPanier(Produit pProduit) {
        getView().getController().ajouterAuPanier(pProduit);
    }

    /**
     * Ajoute le produit selectionne au menu
     * @param pProduit produit selectionne
     */
    public void ajouterProduitMenu(Produit pProduit) {
        getView().getController().AjoutProduitMenu(pProduit);
    }


    /**
     * methode de redirection vers la page de methode de payement
     */
    public void redirectionMethodePayement() {

        if(getView().getController().getPanier().getVendableListe().size()==0)
            return;

        try {
            MethodePayementView methodePayementView = new MethodePayementView();
            getView().changerPage((Stage) getViewPriseCommande().getScene().getWindow(), methodePayementView);
            methodePayementView.getController().setPanier(getView().getController().getPanier());
        } catch (Exception e) {
            AlertView alertView = new AlertView();
            getView().genererNouvellePage(alertView);
            alertView.getController().setMessage("Impossible de changer de page "+e.getMessage());
        }

    }


    public void rechargerProduit() {
        affichagePlatType(getView().getController().getType());
    }

    /**
     * Redirige vers la page de gestion des commande
     */
    public void afficherGestionCommande(){
        if(!GestionCommandeView.dejaOuverte()){
            GestionCommandeView gestionCommandeView = GestionCommandeView.creerGestionCommandeView();
            try {
                gestionCommandeView.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * Affichage du panier
     * @param pPanier panier
     */
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


