package application.view.compte.argentConfirmation;


import application.Model.Client.Client;
import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ArgentConfirmationViewController extends ViewController {

    @FXML
    private AnchorPane viewArgentConfimation;

    @FXML
    private Label libelle;

    @FXML
    private Label somme;

    public ArgentConfirmationViewController(){}

    //TODO separer fenetre l'ajout d'argent et le debit
    public void initialise(Client cl, double somme, boolean ajoutArgent) {
        if(!ajoutArgent){
            libelle.setText("Somme à débiter pour "+cl.getFirstname() + " "+cl.getName()+":");
            this.somme.setText(somme+"€");
        }
        else {
            libelle.setText("Somme à ajouter pour "+cl.getFirstname() + " "+cl.getName()+":");
        }
    }

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
    public ArgentConfirmationView getView() {
        return (ArgentConfirmationView) super.getView();
    }

    public AnchorPane getViewArgentConfimation() {
        return viewArgentConfimation;
    }
}
