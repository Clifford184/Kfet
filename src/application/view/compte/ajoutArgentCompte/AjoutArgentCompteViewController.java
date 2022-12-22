package application.view.compte.ajoutArgentCompte;


import application.model.client.Client;
import application.outils.ImageManager;
import application.view.ViewController;
import application.view.compte.CompteView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;

public class AjoutArgentCompteViewController extends ViewController {
    @FXML
    private AnchorPane viewArgentConfimation;

    @FXML
    private ImageView annulerImageView;

    @FXML
    private ImageView validerImageView;

    @FXML
    private TextField argentAjouterTextField;

    @FXML
    private Label clientLabel;



    public void initialiserView(){
        annulerImageView.setImage(ImageManager.genererImage("/ressource/image/icone/annuler.png"));
        annulerImageView.setOnMouseClicked(mouseEvent -> close());

        validerImageView.setImage(ImageManager.genererImage("/ressource/image/icone/valide.png"));
        validerImageView.setOnMouseClicked(mouseEvent -> valider());
    }

    /**
     * Méthode qui creer un client en fonction des données
     */
    public void valider() {
        if(argentAjouterTextField.getText() != null){
            try{
                float argentAAjouter = Float.parseFloat(argentAjouterTextField.getText());

                getView().getController().ajouterAgentClient(argentAAjouter);
                close();
            }
            catch(NumberFormatException exception){
                exception.printStackTrace();
            }
        }
    }

    /**
     * Méthode qui redirige vers la page de visualisation des comptes
     */
    public void close() {
        CompteView compteView = new CompteView();
        getView().changerPage((Stage) viewArgentConfimation.getScene().getWindow(), compteView);
    }

    public AjoutArgentCompteViewController(){}

    @Override
    public AjoutArgentCompteView getView() {
        return (AjoutArgentCompteView) super.getView();
    }

    public Label getClientLabel() {
        return clientLabel;
    }

    public void setClientLabel(Client client) {
        this.clientLabel.setText(client.getNom());
    }
}
