package application.view.compte.argentConfirmation;


import application.Model.Client.Client;
import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ArgentConfirmationViewController extends ViewController {

    public ArgentConfirmationViewController(){}

    @FXML
    Label libelle;

    @FXML
    Label somme;

    public void initialise(Client cl, double somme, boolean ajoutArgent) {
        if(!ajoutArgent){
            libelle.setText("Somme à débiter pour "+cl.getFirstname() + " "+cl.getName()+":");
            this.somme.setText(somme+"€");
        }
        else {
            libelle.setText("Somme à ajouter pour "+cl.getFirstname() + " "+cl.getName()+":");
        }
    }

    public void annuler(){
        getView().close();
    }

    public void valider(){
        getView().close();
    }

    @Override
    public ArgentConfirmationView getView() {
        return (ArgentConfirmationView) super.getView();
    }
}
