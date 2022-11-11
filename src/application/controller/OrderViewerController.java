package application.controller;

import application.Model.Commande;

public class OrderViewerController {

    public void changeOrderState(Commande pCommande, Commande.State pState){
        pCommande.setEtatActuel(pState);
    }

}
