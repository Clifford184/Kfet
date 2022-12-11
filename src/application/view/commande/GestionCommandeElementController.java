package application.view.commande;

import application.model.Commande;
import application.view.ViewController;
import javafx.scene.control.Label;

public class GestionCommandeElementController extends ViewController {

    public Label listeClientLabel;
    public Label listeHeureLabel;
    public Label listePrixTotalLabel;
    public Label listeEtatLabel;
    public Label listeProduitLabel;

    Commande commande;

    public void initialize(Commande pCommande) {
        commande = pCommande;
        listeClientLabel.setText(commande.getClient().getPrenom());
        listeHeureLabel.setText(commande.getDate().toString());
        listePrixTotalLabel.setText(commande.getCart().valeurPanier()+"e");
        listeEtatLabel.setText(commande.getEtatActuel().name());
    }
}
