package application.view.compte.crudGroupe;


import application.model.client.Groupe;
import application.view.ViewController;
import application.view.compte.CompteView;
import application.view.compte.gestionGroupe.GestionGroupeView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;

public class CrudGroupeViewController extends ViewController {

    @FXML
    private AnchorPane crudGroupeView;

    @FXML
    private TextField nomTextField;

    @FXML
    private ImageView validerImageView;

    @FXML
    private ImageView annulerImageView;
    /**
     * Methode d'initialisation des Imaages View annuler et valider
     */
    public void initialiserView() {
        File cheminImage = new File("src" + File.separator + "ressource" + File.separator + "image" + File.separator + "icone" + File.separator + "annuler.png");
        annulerImageView.setImage(new Image(cheminImage.toURI().toString()));
        annulerImageView.setOnMouseClicked(mouseEvent -> close());

        cheminImage = new File("src" + File.separator + "ressource" + File.separator + "image" + File.separator + "icone" + File.separator + "valide.png");
        validerImageView.setImage(new Image(cheminImage.toURI().toString()));
        validerImageView.setOnMouseClicked(mouseEvent -> valider());
    }

    /**
     * Méthode qui creer un client en fonction des données
     */
    public void valider() {
        if (nomTextField.getText() != null) {
            String nom = nomTextField.getText();
            if (getView().getController().getGroupe() == null){
                getView().getController().creerGroupe(nom);
            }
            else {
                getView().getController().modifierGroupe(nom);
            }
            close();
        }
    }

    /**
     * Méthode qui redirige vers la page de visualisation des comptes
     */
    public void close() {
        GestionGroupeView gestionGroupeView = new GestionGroupeView();
        getView().changerPage((Stage) crudGroupeView.getScene().getWindow(), gestionGroupeView);
    }

    public CrudGroupeViewController() {
    }

    @Override
    public CrudGroupeView getView() {
        return (CrudGroupeView) super.getView();
    }

    public TextField getNomTextField() {
        return nomTextField;
    }

    public void setNomTextField(Groupe groupe) {
        this.nomTextField.setText(groupe.getNom());
    }
}
