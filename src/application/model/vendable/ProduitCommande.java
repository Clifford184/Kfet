package application.model.vendable;

public class ProduitCommande {

    Produit produit;
    Etat etat;

    public enum Etat{
        COMMENCE,
        EN_COURS,
        SERVI
    }

    /**
     * Decrit un produit a ete commande. Permet une gestion
     * de son avancement de preparation
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
