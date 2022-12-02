package application.model.vendable;

public class ProduitCommande {

    Produit produit;
    Etat etat;

    public enum Etat{
        COMMENCE,
        EN_COURS,
        SERVI
    }

    public ProduitCommande(Produit pProduit){
        produit = pProduit;
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
