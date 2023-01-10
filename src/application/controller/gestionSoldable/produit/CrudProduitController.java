package application.controller.gestionSoldable.produit;

import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.controller.Controller;
import application.view.utile.AlertView;

import java.util.ArrayList;

public class CrudProduitController extends Controller {

    Produit produit;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {

    }

    public void creationProduit(String pNom, float pAchat, float pVente, float pPrixVenteMembre, Type pType, String pchemin){
        try {
            new Produit(pNom, pAchat, pVente, pPrixVenteMembre, pType, pchemin);
        }
        catch (Exception e){
            AlertView alertView = new AlertView();
            alertView.getController().setMessage("Echec de la creation du produit "+pNom);
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

