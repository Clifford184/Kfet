package application.model.vendable;

import application.model.Stock;

import java.io.IOException;
import java.io.Serializable;

/**
 * Decrit un produit qui est propose a la vente
 */
public class Produit extends Vendable implements Serializable {

    Type type;
    boolean enStock;

    /**
     * Cree un nouveau produit et ajoute sa reference au stock (avec 0 exemplaire)
     * @param pNom son nom
     * @param pPrixAchat son prix d'achat
     * @param pPrixVente son prix de vente
     * @param pType son type
     * @param pCheminImage le chemin de son image
     * @throws IOException
     */
    public Produit(String pNom, float pPrixAchat, float pPrixVente, Type pType, String pCheminImage) throws IOException {
        super(pNom, pPrixAchat, pPrixVente, pCheminImage);
        type = pType;
        Stock.getInstance().ajouterNouveauProduit(this);
    }

    /**
     * Permet de determiner si le produit est en stock
     * Evite d'aller chercher dans Stock a chaque fois
     * @param pInStock
     */
    public void setEnStock(boolean pInStock){
        enStock = pInStock;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean estEnStock() {
        return enStock;
    }
}
