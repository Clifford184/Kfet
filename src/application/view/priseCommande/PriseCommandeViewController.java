package application.view.priseCommande;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import application.view.ViewController;
import javafx.util.Duration;


public class PriseCommandeViewController extends ViewController {

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;

    @FXML
    private Label Panier;

    @FXML
    private Label PanierClose;

    @FXML
    private AnchorPane sliderPanier;

    @FXML
    private Label PageMenu;

    public void openMenu(){
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });

        MenuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });
    }

    public void openPanier(){
        Panier.setOnMouseClicked(event -> {
            sliderPanier.setVisible(true);
            Panier.setVisible(false);
            PanierClose.setVisible(true);
        });

        PanierClose.setOnMouseClicked(event -> {
            sliderPanier.setVisible(false);
            Panier.setVisible(true);
            PanierClose.setVisible(false);
        });
    }

    public void initialPage(){
        slider.setTranslateX(-176);
        sliderPanier.setVisible(false);
    }


    public PriseCommandeViewController() {}

    @Override
    public PriseCommandeView getView() {
        return (PriseCommandeView) super.getView();
    }

}
