package application.view.commande;

import application.model.Commande;
import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class GestionCommandeViewController extends ViewController {

    public VBox listeCommandeVBox;

    public Button menuButton;
    public Label clientLabel;
    public Label heureCommandeLabel;
    public Label montantTotalLabel;
    public ComboBox etatActuelCombo;
    public Button validerModifButton;
    public VBox listeProduitVBox;
    public Button consulterHistoriqueButton;
    @FXML
    private AnchorPane viewGestionCommande;

    public void initialize(){

        //relier le menuButton



    }

    /**
     * Rempli le panneau de droite avec les informations de la commande
     * qui est focus.
     * @param pCommande la commande dont il faut afficher les details
     */
    public void focusCommande(Commande pCommande){
        clientLabel.setText(pCommande.getClient().getPrenom());
        montantTotalLabel.setText(pCommande.getCart().valeurPanier()+"e");

        //

    }

    /**
     * Appeler pour valider la mise a jour des données modifiees dans
     * le panneau de droite, concernant l'avance des produits et de la commande
     */
    public void validerModif(){

    }

    /**
     * Ouvre une nouvelle fenetre (?) permettant de consulter les commandes passees
     */
    public void consulterHistoirique(){

    }

    public GestionCommandeView getView() {
        return (GestionCommandeView) super.getView();
    }

    public AnchorPane getViewGestionCommande() {
        return viewGestionCommande;
    }
}
