package application.view.compte.crudClient;


import application.model.client.Client;
import application.model.client.Groupe;
import application.outils.ImageManager;
import application.view.ViewController;
import application.view.compte.CompteView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class CrudClientViewController extends ViewController {

    @FXML
    private AnchorPane crudClientView;

    @FXML
    private TextField nomTextField;

    @FXML
    private TextField prenomTextField;

    @FXML
    private ComboBox<Groupe> promoComboBox;

    @FXML
    private ImageView validerBouton;

    @FXML
    private ImageView annulerBouton;

    /**
     * Methode d'initialisation des Imaages View annuler et valider
     */
    public void initialiserView(){

        annulerBouton.setImage(ImageManager.genererImage("/ressource/image/icone/annuler.png"));
        annulerBouton.setOnMouseClicked(mouseEvent -> close());

        validerBouton.setImage(ImageManager.genererImage("/ressource/image/icone/valide.png"));
        validerBouton.setOnMouseClicked(mouseEvent -> valider());
    }

    /**
     * Méthode qui creer un client en fonction des données rempli
     */
    public void valider() {
        if(nomTextField.getText() != null && prenomTextField.getText() != null && promoComboBox.getValue() != null){
            String nom = nomTextField.getText();
            String prenom = prenomTextField.getText();
            Groupe promo = promoComboBox.getValue();

            if (getView().getController().getClient() == null){
                getView().getController().creerClient(nom, prenom, promo);
            }
            else {
                getView().getController().modifierClient(nom, prenom, promo);
            }

            close();
        }
    }

    /**
     * Méthode qui redirige vers la page de visualisation des comptes
     */
    public void close() {
        CompteView compteView = new CompteView();
        getView().changerPage((Stage) crudClientView.getScene().getWindow(), compteView);
    }

    public CrudClientViewController(){}

    @Override
    public CrudClientView getView() {
        return (CrudClientView) super.getView();
    }

    public ComboBox<Groupe> getPromoComboBox() {
        return promoComboBox;
    }

    public void setPromoComboBox(ArrayList<Groupe> plisteGroupe) {
        this.promoComboBox.getItems().setAll(plisteGroupe);
    }

    public void setClient(Client pClient){
        nomTextField.setText(pClient.getNom());
        prenomTextField.setText(pClient.getPrenom());
        promoComboBox.setValue(pClient.getPromo());
    }
}
