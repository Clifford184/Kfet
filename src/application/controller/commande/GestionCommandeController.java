package application.controller.commande;

import application.controller.Controller;
import application.model.Commande;
import application.model.vendable.ProduitCommande;

import java.util.ArrayList;
import java.util.Comparator;

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

    public Commande getCommande(){
        return selectionnee;
    }

    public ArrayList<Commande> listeCommandesTriees() {

        ArrayList<Commande> listeTriee = new ArrayList<>(Commande.getCommandeListe());

        listeTriee.sort(new Comparator<Commande>() {
            @Override
            public int compare(Commande o1, Commande o2) {
                return o1.getEtatActuel().ordinal() - o2.getEtatActuel().ordinal();
            }
        });


        return listeTriee;

    }
}
