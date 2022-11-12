package application.controller.gestionSoldable.produit;

import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.controller.Controller;

import java.util.ArrayList;

public class CrudProduitController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"type"};
        notifyObservers(messages);
    }

    public void creationProduit(String pNom, float pAchat, float pVente, Type pType, String pchemin){
        try {
            new Produit(pNom, pAchat, pVente, pType, pchemin);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

