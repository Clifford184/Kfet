package application.view.compte.DebitArgentCompte;


import application.model.client.Client;
import application.outils.ImageManager;
import application.view.ViewController;
import application.view.compte.CompteView;
import application.view.priseCommande.PriseCommandeView;
import application.view.utile.AlertView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DebitArgentCompteViewController extends ViewController {

    public ImageView validerImgBtn;
    public ImageView annulerImgBtn;
    @FXML
    private AnchorPane viewArgentConfimation;

    @FXML
    private Label libelleClient;

    @FXML
    private Label somme;

    public DebitArgentCompteViewController(){}

    /**
     * Initialise les elements graphiques de la vue
     */
    public void initialize(){
        annulerImgBtn.setImage(ImageManager.chargerImage("/ressource/image/icone/annuler.png"));
        annulerImgBtn.setOnMouseClicked(mouseEvent -> annuler());

        validerImgBtn.setImage(ImageManager.chargerImage("/ressource/image/icone/valide.png"));
        validerImgBtn.setOnMouseClicked(mouseEvent -> valider());
    }

    /**
     * methode qui annule le debit pour ce client
     */
    public void annuler(){
        try {
            CompteView compteView = new CompteView();
            getView().changerPage((Stage) getViewArgentConfimation().getScene().getWindow(), compteView);
            compteView.getController().setPanier(getView().getController().getPanier());
        } catch (Exception e) {
            AlertView alertView = new AlertView();
            getView().genererNouvellePage(alertView);
            alertView.getController().setMessage("Echec de l'annulation du debit");
        }
    }

    /**
     * methode qui confirme le debit pour ce client
     */
    public void valider(){
        float sommeDebit =  Float.parseFloat(somme.getText());
        getView().getController().debiterClient(sommeDebit);
        try {
            PriseCommandeView priseCommandeView = new PriseCommandeView();
            getView().changerPage((Stage) getViewArgentConfimation().getScene().getWindow(), priseCommandeView);
        } catch (Exception e) {
            AlertView alertView = new AlertView();
            getView().genererNouvellePage(alertView);
            alertView.getController().setMessage("Impossible de debiter le client");
        }
    }

    @Override
    public DebitArgentCompteView getView() {
        return (DebitArgentCompteView) super.getView();
    }

    public AnchorPane getViewArgentConfimation() {
        return viewArgentConfimation;
    }

    public Label getLibelleClient() {
        return libelleClient;
    }

    public void setLibelleClient(Client client) {
        this.libelleClient.setText("somme à débiter pour "+client.getNom());
    }

    public Label getSomme() {
        return somme;
    }

    public void setSomme(float valeurPanier) {
        this.somme.setText(String.valueOf(valeurPanier));
    }
}
