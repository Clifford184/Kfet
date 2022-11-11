package application.view.priseCommande;

import application.model.vendable.Type;
import application.view.compte.CompteView;
import application.view.gestionSoldable.categorie.GestionCategorieView;
import application.view.gestionSoldable.type.GestionTypeView;
import application.view.methodePayement.MethodePayementView;
import application.view.gestionSoldable.produit.GestionProduitView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import application.view.ViewController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class PriseCommandeViewController extends ViewController {

    @FXML
    private BorderPane ViewPriseCommande;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private AnchorPane sliderPanier;

    @FXML
    private HBox zoneAffichageType;

    @FXML
    private ImageView payementIcone;

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
    public void initialize() {
        sliderMenu.setVisible(false);
        sliderMenu.setTranslateX(-176);
        sliderPanier.setVisible(false);
        sliderPanier.setTranslateY(500);
    }

    /**
     * methode de création de case pour chaque type existant
     */
    public void initializeType() {
        for (Type type : Type.typeListe) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(type.getName());
            pane.getChildren().add(label);
            // pane.setOnMouseClicked(event -> choixPlat() );
            pane.setPadding(new Insets(50, 50, 50, 50));
            zoneAffichageType.getChildren().add(pane);
        }
    }

//    public void choixPlat() {
//        box1.getChildren().clear();
//        String[] listePlat = {"plat + 1 article","plat + 2 articles","petit déjeuner","goûter"};
//        //String[] listePlat = {"Pizza Chèvre","Pizza Kebab","Pizza Bolognaise","Pizza Royal","Pizza 3 fromages", "Pizza Chorizo"};
//        for(int i = 0; i<listePlat.length; i++) {
//            Pane pane = new Pane();
//            Label label = new Label();
//            label.setText(listePlat[i]);
//            pane.getChildren().add(label);
//            pane.setOnMouseClicked(event -> selectionMenu1() );
//            pane.setPadding( new Insets(50,50,50,50));
//            box1.getChildren().add(pane);
//        }
//    }
//
//    public void selectionMenu1() {
//        box1.getChildren().clear();
//        String[] listePlat = {"Picard", "Pizza"};
//        for(int i = 0; i<listePlat.length; i++) {
//            Pane pane = new Pane();
//            Label label = new Label();
//            label.setText(listePlat[i]);
//            pane.getChildren().add(label);
//            pane.setOnMouseClicked(event -> selectionMenu2() );
//            pane.setPadding( new Insets(50,50,50,50));
//            box1.getChildren().add(pane);
//        }
//    }
//
//    public void selectionMenu2() {
//        box1.getChildren().clear();
//        String[] listePlat = {"Snack", "Boison"};
//        for(int i = 0; i<listePlat.length; i++) {
//            Pane pane = new Pane();
//            Label label = new Label();
//            label.setText(listePlat[i]);
//            pane.getChildren().add(label);
//            pane.setPadding( new Insets(50,50,50,50));
//            box1.getChildren().add(pane);
//        }
//    }

    /**
     * methode de redirection vers la page de methode de payement
     */
    public void redirectionMethodePayement() {
        try {
            MethodePayementView methodePayementView = new MethodePayementView();
            getView().changerPage(methodePayementView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * methode de redirection vers la page de gestion des produits
     */
    public void redirectionGestionProduit() {
        try {
            GestionProduitView gestionProduitView = new GestionProduitView();
            getView().changerPage(gestionProduitView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des types
     */
    public void redirectionGestionType() {
        try {
            GestionTypeView gestionTypeView = new GestionTypeView();
            getView().changerPage(gestionTypeView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des catégories
     */
    public void redirectionGestionCategorie() {
        try {
            GestionCategorieView gestionCategorieView = new GestionCategorieView();
            getView().changerPage(gestionCategorieView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode de redirection vers la page de gestion des comptes
     */
    public void redirectionCompte() {
        try {
            CompteView compteView = new CompteView();
            getView().changerPage(compteView);
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
}
