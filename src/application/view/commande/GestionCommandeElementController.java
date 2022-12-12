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
        listeClientLabel.setText(commande.getIdentiteClient());
        listeHeureLabel.setText(commande.getDate().getHour()+":"+commande.getDate().getMinute());
        listePrixTotalLabel.setText(commande.getPanier().valeurPanier()+"e");
        listeEtatLabel.setText(commande.getEtatActuel().name());

        listeProduitLabel.setText(commande.getProduitCommandeListe().get(0).getProduit().getNom());

    }
}
