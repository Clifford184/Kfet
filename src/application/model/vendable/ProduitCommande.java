package application.model.vendable;

import java.io.Serializable;

/**
 * Decrit un produit a ete commande. Permet une gestion
 * de son avancement de preparation
 **/
public class ProduitCommande implements Serializable {

    Produit produit;
    Etat etat;

    public enum Etat{
        COMMENCE,
        EN_COURS,
        SERVI
    }

    /** Constructeur d'un produit commande
     * @param pProduit le produit a decrire.
     */
    public ProduitCommande(Produit pProduit){
        produit = pProduit;
        etat = Etat.COMMENCE;
    }

    public Etat getEtat() {
        return etat;
    }

    public void changerEtat(Etat pEtat){
        etat = pEtat;
    }

    public Produit getProduit(){
        return produit;
    }

}
