package application.model.vendable;

import application.model.Stock;
import application.model.client.Groupe;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Decrit un produit qui est propose a la vente
 */
public class Produit extends Vendable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    Type type;
    boolean enStock;

    public static ArrayList<Produit> produitListe = new ArrayList<>();

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
        produitListe.add(this);
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Produit p : produitListe){
            if(p.id.equals(this.id))
                return p;
        }
        produitListe.add(this);
        return this;
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
