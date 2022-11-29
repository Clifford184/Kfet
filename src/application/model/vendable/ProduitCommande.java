package application.model.vendable;

public class ProduitCommande {

    Produit produit;
    Etat etat;

    enum Etat{
        COMMENCE,
        EN_COURS,
        SERVI
    }

    public ProduitCommande(Produit pProduit){
        produit = pProduit;
    }

    public void changerEtat(Etat pEtat){
        etat = pEtat;
    }

}
