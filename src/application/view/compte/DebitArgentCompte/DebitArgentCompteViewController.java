package application.view.compte.DebitArgentCompte;


import application.model.client.Client;
import application.view.ViewController;
import application.view.compte.CompteView;
import application.view.gestionSoldable.offre.GestionOffreView;
import application.view.priseCommande.PriseCommandeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DebitArgentCompteViewController extends ViewController {

    @FXML
    private AnchorPane viewArgentConfimation;

    @FXML
    private Label libelleClient;

    @FXML
    private Label somme;

    public DebitArgentCompteViewController(){}

    /**
     * methode qui annule le debit pour ce client
     */
    public void annuler(){
        try {
            CompteView compteView = new CompteView();
            getView().changerPage((Stage) getViewArgentConfimation().getScene().getWindow(), compteView);
            compteView.getController().setCommande(getView().getController().getCommande());
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
