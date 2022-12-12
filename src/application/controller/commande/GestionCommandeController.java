package application.controller.commande;

import application.controller.Controller;
import application.model.Commande;
import application.model.vendable.ProduitCommande;

public class GestionCommandeController extends Controller {

    Commande selectionnee;

    @Override
    public void initialize() {

    }

    public void focusCommande(Commande pCommande){
        selectionnee = pCommande;
    }

    public void changerEtatProduit(ProduitCommande pProduit, ProduitCommande.Etat valueOf) {
        pProduit.changerEtat(valueOf);
    }

    public void majCommande() {
        selectionnee.maj();
        String[] messages = {"commande_modifiee"};
        notifyObservers(messages);
    }
}
