package application.view.commande;

import application.model.Commande;
import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Arrays;


public class GestionCommandeViewController extends ViewController {

    public VBox listeCommandeVBox;
    public Button menuButton;
    public Button consulterHistoriqueButton;

    public Label clientLabel;
    public Label heureCommandeLabel;
    public Label montantTotalLabel;
    public VBox listeProduitVBox;
    public Button validerModifButton;
    public Label etatCommandeLabel;

    @FXML
    private AnchorPane viewGestionCommande;

    public void initialize(){

        for(Commande commande : Commande.getCommandeListe()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/gestionCommandeElement.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //faire un tri pour afficher en premier les commandes commencée, en cours, et terminée
            GestionCommandeElementController controller = loader.getController();
            controller.initialize(commande);
            listeCommandeVBox.getChildren().add(pane);
        }
        //relier le menuButton

    }

    /**
     * Remplie le panneau de droite avec les informations de la commande
     * qui est focus.
     * @param pCommande la commande dont il faut afficher les details
     */
    public void focusCommande(Commande pCommande){

        clientLabel.setText(pCommande.getClient().getPrenom()+pCommande.getClient().getNom());
        heureCommandeLabel.setText(pCommande.getDate().toString());
        montantTotalLabel.setText(pCommande.getCart().valeurPanier()+"e");

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
