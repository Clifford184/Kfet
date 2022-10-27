package application.view.compte;

import application.view.ViewController;
import application.view.methodePayement.MethodePayementView;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CompteViewController extends ViewController {

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private TabPane tablePromo;

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

    // Initialise les données pour la vue
    public void initialize(){
        String[] listePromo = {"DI3","DI4","DI5"};
        String[] listeEntete = {"Nom","Prénom","Solde"};
        String[] aurelien = {"DaFonseca","Aurelien","4"};
        String[] charles = {"Caillon","Charles","8"};
        ObservableList<String[]> listeEtuDI4 = FXCollections.observableArrayList(charles, aurelien);
        // TODO pane.setOnMouseClicked(event -> choixPlat() );

        for (String promo: listePromo) {
            TableView tableView = new TableView();  //TODO mettre le modele fait
            tableView.getItems().add(charles);
            tableView.getItems().add(aurelien);
            //tableView.setItems(listeEtuDI4);
            for (String entete : listeEntete){
                TableColumn tableColumn = new TableColumn<>(entete);
                tableView.getColumns().add(tableColumn);
            }
            Tab tab = new Tab(promo, tableView);
            tablePromo.getTabs().add(tab);
        }
    }

    public void ajouterArgent(){

    }
    public CompteViewController(){}

    public MethodePayementView getView(){
        return (MethodePayementView) super.getView();
    }
}
