package application.view.compte.DebitArgentCompte;


import application.model.client.Client;
import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DebitArgentCompteViewController extends ViewController {

    @FXML
    private AnchorPane viewArgentConfimation;

    @FXML
    private Label libelleClient;

    @FXML
    private Label somme;

    public DebitArgentCompteViewController(){}

//    //TODO separer fenetre l'ajout d'argent et le debit
//    public void initialise(boolean ajoutArgent) {
//        if(!ajoutArgent){
//            libelle.setText("Somme à débiter pour "+cl.getPrenom() + " "+cl.getNom()+":");
//            this.somme.setText(somme+"€");
//        }
//        else {
//            libelle.setText("Somme à ajouter pour "+cl.getPrenom() + " "+cl.getNom()+":");
//        }
//    }

    /**
     * methode qui annule le debit pour ce client
     */
    public void annuler(){
        getView().close();
    }

    /**
     * methode qui confirme le debit pour ce client
     */
    public void valider(){
        getView().close();
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
