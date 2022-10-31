package application.view.priseCommande;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import application.view.ViewController;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;



public class PriseCommandeViewController extends ViewController {

    @FXML
    private Label menu;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private Label panier;

    @FXML
    private AnchorPane sliderPanier;

    @FXML
    private Label PageMenu;

    @FXML
    private HBox box1;

    @FXML
    ImageView payementIcone;

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

    public void openPanier(){
        if (!sliderPanier.isVisible()){
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(sliderPanier);

            slide.setToY(0);
            slide.play();

            sliderPanier.setTranslateY(500);
            sliderPanier.setVisible(true);
        }
        else {
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

    public void initialPage(){
        sliderMenu.setVisible(false);
        sliderMenu.setTranslateX(-176);
        sliderPanier.setVisible(false);
        sliderPanier.setTranslateY(500);
    }

    public void initializeType(){
        String[] listeType = {"Pizza","Picard","Boisson","Snack","Autres plats chaud", "Menu"};
        for(int i = 0; i<listeType.length; i++) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(listeType[i]);
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> choixPlat() );
            pane.setPadding( new Insets(50,50,50,50));
            box1.getChildren().add(pane);
        }
    }

    public void choixPlat() {
        box1.getChildren().clear();
        String[] listePlat = {"plat + 1 article","plat + 2 articles","petit déjeuner","goûter"};
        //String[] listePlat = {"Pizza Chèvre","Pizza Kebab","Pizza Bolognaise","Pizza Royal","Pizza 3 fromages", "Pizza Chorizo"};
        for(int i = 0; i<listePlat.length; i++) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(listePlat[i]);
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> selectionMenu1() );
            pane.setPadding( new Insets(50,50,50,50));
            box1.getChildren().add(pane);
        }
    }

    public void selectionMenu1() {
        box1.getChildren().clear();
        String[] listePlat = {"Picard", "Pizza"};
        for(int i = 0; i<listePlat.length; i++) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(listePlat[i]);
            pane.getChildren().add(label);
            pane.setOnMouseClicked(event -> selectionMenu2() );
            pane.setPadding( new Insets(50,50,50,50));
            box1.getChildren().add(pane);
        }
    }

    public void selectionMenu2() {
        box1.getChildren().clear();
        String[] listePlat = {"Snack", "Boison"};
        for(int i = 0; i<listePlat.length; i++) {
            Pane pane = new Pane();
            Label label = new Label();
            label.setText(listePlat[i]);
            pane.getChildren().add(label);
            pane.setPadding( new Insets(50,50,50,50));
            box1.getChildren().add(pane);
        }
    }

    public void redirectionMethodePayement() throws Exception {
        getView().changerScene();
    }

    public PriseCommandeViewController() {}

    @Override
    public PriseCommandeView getView() {
        return (PriseCommandeView) super.getView();
    }

}
