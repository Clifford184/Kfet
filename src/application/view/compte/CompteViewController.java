package application.view.compte;

import application.Model.Client.Client;
import application.Model.Client.Promo;
import application.view.ViewController;
import application.view.compte.argentConfirmation.ArgentConfirmationView;
import application.view.methodePayement.MethodePayementView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class CompteViewController extends ViewController {

    @FXML
    private BorderPane viewCompte;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private TabPane tablePromo;

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

    //

    /**
     * methode qui initialise les données pour la vue
     * TODO methode à revoir
     */
    public void initialize(){
        String[] listePromo = {"DI3","DI4","DI5"};
        String[] listeEntete = {"name","firstname","money"};
        String[] aurelien = {"DaFonseca","Aurelien","4"};
        String[] charles = {"Caillon","Charles","8"};
        Promo di3 = new Promo("DI3"); //TODO créer une arrayList de promo
        Client cl1 = new Client("Jean","Bon",di3);
        Client cl2 = new Client("jh","ok",di3);

        for (String promo: listePromo) {
            TableView<Client> tableView = new TableView();
            for (String entete : listeEntete){
                TableColumn tableColumn = new TableColumn(entete);
                tableColumn.setCellValueFactory(new PropertyValueFactory(entete));
                tableView.getColumns().add(tableColumn);
            }
            tableView.getItems().add(cl1);
            tableView.getItems().add(cl2);
            tableView.setOnMouseClicked(event -> {
                try {
                    debiterClient(tableView.getSelectionModel().getSelectedItem());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            Tab tab = new Tab(promo, tableView);
            tablePromo.getTabs().add(tab);
        }
    }

    /**
     * methode pour ouvrir la confirmation du debit pour un client
     * @param cl client à débiter
     */
    public void debiterClient(Client cl) {
        try {
            ArgentConfirmationView argentConfirmationView = new ArgentConfirmationView();
            getView().changerPage(argentConfirmationView);
            //TODO encore en phase de test
            argentConfirmationView.getViewController().initialise(cl,3.1,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode pour ajouter de l'argent à un client
     */
    public void ajouterArgent(){}

    /**
     * constructeur par défaut
     */
    public CompteViewController(){}

    public CompteView getView(){
        return (CompteView) super.getView();
    }

    public BorderPane getViewCompte() {
        return viewCompte;
    }
}
