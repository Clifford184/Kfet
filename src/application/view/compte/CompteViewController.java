package application.view.compte;

import application.model.client.*;
import application.outils.ImageManager;
import application.view.Menu;
import application.view.ViewController;
import application.view.compte.DebitArgentCompte.DebitArgentCompteView;
import application.view.compte.ajoutArgentCompte.AjoutArgentCompteView;
import application.view.compte.crudClient.CrudClientView;
import application.view.compte.gestionGroupe.GestionGroupeView;
import application.view.utile.AlertView;
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
    ImageView modificationClientImageView;

    @FXML
    ImageView suppressionClientImageView;

    @FXML
    ImageView ajouterArgentImageView;

    @FXML
    ImageView gestionGroupeImageView;

    Client clientSelectionne;

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
     * Methode pour ajouter le menu a la vue
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
        menuController.initialize(this, (Stage) viewCompte.getScene().getWindow());
    }

    //

    /**
     * methode qui initialise les données pour la vue
     */
    public void initialiserView() {
        //Initialisation ImageView Creation Client

        ajouterClientImageView.setImage(ImageManager.genererImage("/ressource/image/icone/ajoutCompte.png"));
        ajouterClientImageView.setOnMouseClicked(mouseEvent -> redirectionAjoutCrudClient());

        modificationClientImageView.setImage(ImageManager.genererImage("/ressource/image/icone/modifierClient.png"));
        modificationClientImageView.setOnMouseClicked(mouseEvent -> redirectionModificationCrudClient());

        suppressionClientImageView.setImage(ImageManager.genererImage("/ressource/image/icone/supprimerClient.png"));
        suppressionClientImageView.setOnMouseClicked(mouseEvent -> supprimerClient());

        ajouterArgentImageView.setImage(ImageManager.genererImage("/ressource/image/icone/ajoutArgent.png"));
        ajouterArgentImageView.setOnMouseClicked(mouseEvent -> redirectionAjouterArgent());

        gestionGroupeImageView.setImage(ImageManager.genererImage("/ressource/image/icone/gestionGroupe.png"));
        gestionGroupeImageView.setOnMouseClicked(mouseEvent -> redirectionGestionGroupe());

        //Initailisation du tableau de visualisation des groupes et clients
        tablePromo.getTabs().clear();
        String[] listeEntete = {"nom", "prenom", "argent"};
        ArrayList<Groupe> listeGroupe = Groupe.getGroupeListe();

        for (Groupe promo : listeGroupe) {
            TableView<Client> tableView = new TableView<Client>();
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
                tableView.setOnMouseClicked(event -> {
                    sauvegardeDernierClientSelectionner(tableView.getSelectionModel().getSelectedItem());
                });

                ajouterArgentImageView.setOnMouseClicked(event -> {
                    redirectionAjouterArgent();
                });
            }

            Tab tab = new Tab(promo.getNom(), tableView);
            tablePromo.getTabs().add(tab);
        }
    }

    /**
     * Methode qui recupere le dernier client selectionne
     * utile pour la methode ajout argent au client selectionner
     *
     * @param pDernierClientSelected client selectionne en dernier
     */
    public void sauvegardeDernierClientSelectionner(Client pDernierClientSelected) {
        if (pDernierClientSelected != null) {
            clientSelectionne = pDernierClientSelected;
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

    /**
     * methode de redirection vers la page de  creation client
     */
    public void redirectionAjoutCrudClient() {
        CrudClientView crudClientView = new CrudClientView();
        getView().changerPage((Stage) getViewCompte().getScene().getWindow(), crudClientView);
    }

    /**
     * methode de redirection vers la page de modification de client
     */
    public void redirectionModificationCrudClient() {
        if (clientSelectionne != null) {
            CrudClientView crudClientView = new CrudClientView();
            getView().changerPage((Stage) getViewCompte().getScene().getWindow(), crudClientView);
            crudClientView.getController().setClient(clientSelectionne);
        } else {
            genererMessageErreur();
        }
    }

    /**
     * methode de redirection vers la page de gestion des groupes
     */
    public void redirectionGestionGroupe() {
        GestionGroupeView gestionGroupeView = new GestionGroupeView();
        getView().changerPage((Stage) getViewCompte().getScene().getWindow(), gestionGroupeView);
    }

    /**
     * methode qui supprime le client selectionne
     */
    public void supprimerClient() {
        if (clientSelectionne != null) {
            getView().getController().supprimerClient(clientSelectionne);
        } else {
            genererMessageErreur();
        }
    }

    /**
     * methode qui redirige vers la page pour agouter de l'argent a un client
     */
    public void redirectionAjouterArgent() {
        if (clientSelectionne != null) {
            AjoutArgentCompteView ajoutArgentCompteView = new AjoutArgentCompteView();
            getView().changerPage((Stage) getViewCompte().getScene().getWindow(), ajoutArgentCompteView);
            ajoutArgentCompteView.getController().setClient(clientSelectionne);
        } else {
            genererMessageErreur();
        }
    }

    /**
     * Methode qui permet de generer un msg d'erreur si un client n'est pas selectionne
     */
    public void genererMessageErreur(){
        AlertView alertView = new AlertView();
        getView().genererNouvellePage(alertView);
        String messageErreur = "Veuillez selectionner un client";
        alertView.getController().setMessage(messageErreur);
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
