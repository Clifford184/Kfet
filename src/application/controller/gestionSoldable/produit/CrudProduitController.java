package application.controller.gestionSoldable.produit;

import application.controller.Controller;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.outils.ImageManager;

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
            e.printStackTrace();
        }
    }

    public void modificationProduit(String nomProduit, float prixAchatProduit, float prixVenteProduit, float prixVenteMembre, Type typeProduit, String pChemin) {
        produit.setNom(nomProduit);
        produit.setPrixAchat(prixAchatProduit);
        produit.setPrixVente(prixVenteProduit);
        produit.setPrixVenteMembre(prixVenteMembre);
        produit.setType(typeProduit);
        produit.setCheminImage(ImageManager.genererNouvelleImage(pChemin, nomProduit));
    }

    public void setProduit(Produit pProduit){
        produit = pProduit;
    }


}

