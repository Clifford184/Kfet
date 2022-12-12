package application.view.compte;

import application.model.client.*;
import application.view.Menu;
import application.view.ViewController;
import application.view.compte.DebitArgentCompte.DebitArgentCompteView;
import application.view.compte.ajoutArgentCompte.AjoutArgentCompteView;
import application.view.compte.crudClient.CrudClientView;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CompteViewController extends ViewController {

    @FXML
    private BorderPane viewCompte;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private TabPane tablePromo;

    @FXML
    ImageView ajouterClientImageView;

    @FXML
    ImageView ajouterArgentImageView;

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
        menuController.initialize(this, (Stage) viewCompte.getScene().getWindow());
    }

    //

    /**
     * methode qui initialise les données pour la vue
     */
    public void initialiserView() {
        File cheminImage = new File("src" + File.separator + "ressource" + File.separator + "image" + File.separator + "icone" + File.separator + "ajoutCompte.png");
        ajouterClientImageView.setImage(new Image(cheminImage.toURI().toString()));
        ajouterClientImageView.setOnMouseClicked(mouseEvent -> redirectionCreationClient());

        cheminImage = new File("src" + File.separator + "ressource" + File.separator + "image" + File.separator + "icone" + File.separator + "ajoutArgent.png");
        ajouterArgentImageView.setImage(new Image(cheminImage.toURI().toString()));

        tablePromo.getTabs().clear();
        String[] listeEntete = {"nom", "prenom", "argent"};
        ArrayList<Groupe> listeGroupe = Groupe.getGroupeListe();

        for (Groupe promo : listeGroupe) {
            TableView<Client> tableView = new TableView();
            for (String entete : listeEntete) {
                TableColumn tableColumn = new TableColumn(entete);
                tableColumn.setCellValueFactory(new PropertyValueFactory(entete));
                tableView.getColumns().add(tableColumn);
            }
            for (Client client : promo.getClientListe()) {
                tableView.getItems().add(client);
            }

            if (getView().getController().isAchatContexte()) {
                tableView.setOnMouseClicked(event -> {
                    debiterClient(tableView.getSelectionModel().getSelectedItem());
                });
            } else {
                ajouterArgentImageView.setOnMouseClicked(mouseEvent ->
                        redirectionAjouterArgent(tableView.getSelectionModel().getSelectedItem()));
            }

            Tab tab = new Tab(promo.getNom(), tableView);
            tablePromo.getTabs().add(tab);
        }
    }

    /**
     * methode pour ouvrir la confirmation du debit pour un client
     *
     * @param pClient client à débiter
     */
    public void debiterClient(Client pClient) {
        if (pClient != null) {
            DebitArgentCompteView debitArgentCompteView = new DebitArgentCompteView();
            getView().changerPage((Stage) getViewCompte().getScene().getWindow(), debitArgentCompteView);
            debitArgentCompteView.getController().setPanier(getView().getController().getPanier());
            debitArgentCompteView.getController().setClient(pClient);
        }
    }

    public void redirectionCreationClient() {
        CrudClientView crudClientView = new CrudClientView();
        getView().changerPage((Stage) getViewCompte().getScene().getWindow(), crudClientView);
    }

    /**
     * methode pour ajouter de l'argent à un client
     */
    public void redirectionAjouterArgent(Client pClient) {
        if (pClient != null) {
            AjoutArgentCompteView ajoutArgentCompteView = new AjoutArgentCompteView();
            getView().changerPage((Stage) getViewCompte().getScene().getWindow(), ajoutArgentCompteView);
            ajoutArgentCompteView.getController().setClient(pClient);
        }
    }

    /**
     * constructeur par défaut
     */
    public CompteViewController() {
    }

    public CompteView getView() {
        return (CompteView) super.getView();
    }

    public BorderPane getViewCompte() {
        return viewCompte;
    }
}
