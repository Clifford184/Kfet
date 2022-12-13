package application.controller.gestionSoldable.produit;

import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.controller.Controller;

import java.util.ArrayList;

public class CrudProduitController extends Controller {

    Produit produit;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"type"};
        notifyObservers(messages);
    }

    public void creationProduit(String pNom, float pAchat, float pVente, float pPrixVenteMembre, Type pType, String pchemin){
        try {
            new Produit(pNom, pAchat, pVente, pPrixVenteMembre, pType, pchemin);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modificationProduit(String nomProduit, float prixAchatProduit, float prixVenteProduit, float prixVenteMembre, Type typeProduit, String chemin) {
        produit.setNom(nomProduit);
        produit.setPrixAchat(prixAchatProduit);
        produit.setPrixVente(prixVenteProduit);
        produit.setPrixVenteMembre(prixVenteMembre);
        produit.setType(typeProduit);
        produit.setCheminImage(chemin);
    }

    public void setProduit(Produit pProduit){
        produit = pProduit;
    }


}

