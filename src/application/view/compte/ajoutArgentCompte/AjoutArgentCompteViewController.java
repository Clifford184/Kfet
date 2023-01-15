package application.view.compte.ajoutArgentCompte;


import application.model.client.Client;
import application.outils.ImageManager;
import application.view.ViewController;
import application.view.compte.CompteView;
import application.view.utile.AlertView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

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


    /**
     * methode qui charge les elements graphique de la vue
     */
    public void initialiserView(){
        annulerImageView.setImage(ImageManager.chargerImage("/ressource/image/icone/annuler.png"));
        annulerImageView.setOnMouseClicked(mouseEvent -> close());

        validerImageView.setImage(ImageManager.chargerImage("/ressource/image/icone/valide.png"));
        validerImageView.setOnMouseClicked(mouseEvent -> valider());

        UnaryOperator<TextFormatter.Change> filtrePrix = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d{0,3}([.]\\d{0,2})?")) {
                return change;
            }
            return null;
        };

        argentAjouterTextField.setTextFormatter(new TextFormatter<>(filtrePrix));
    }

    /**
     * Méthode qui lors de la validation ajoute le somme d argent au client
     */
    public void valider() {
        if(argentAjouterTextField.getText() != null){
            try{
                float argentAAjouter = Float.parseFloat(argentAjouterTextField.getText());

                getView().getController().ajouterAgentClient(argentAAjouter);
                close();
            }
            catch(NumberFormatException exception){
                AlertView alertView = new AlertView();
                getView().genererNouvellePage(alertView);
                alertView.getController().setMessage(" format de la somme a ajouter incorrect");
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
