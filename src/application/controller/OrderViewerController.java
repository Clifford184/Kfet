package application.controller;

import application.model.Commande;

public class OrderViewerController {

    public void changeOrderState(Commande pCommande, Commande.Etat pEtat){
        pCommande.setEtatActuel(pEtat);
    }

}
