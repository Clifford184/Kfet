package application.model.vendable;

import application.model.Stock;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Decrit un produit qui est propose a la vente
 */
public class Produit extends Vendable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    Type type;

    public static ArrayList<Produit> produitListe = new ArrayList<>();

    /**
     * Cree un nouveau produit et ajoute sa reference au stock (avec 0 exemplaire)
     * @param pNom son nom
     * @param pPrixAchat son prix d'achat
     * @param pPrixVente son prix de vente
     * @param pPrixVente son prix de vente pour un membre
     * @param pType son type
     * @param pCheminImage le chemin de son image
     */
    public Produit(String pNom, float pPrixAchat, float pPrixVente, float pPrixVenteMembre, Type pType, String pCheminImage) {
        super(pNom, pPrixAchat, pPrixVente, pPrixVenteMembre, pCheminImage);
        id = UUID.randomUUID();
        type = pType;

        type.ajouterProduit(this);

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
     * Permet de determiner le prix d'achat et le plus bas et le plus haut d'une liste
     * de produits. Utile pour calculer l'intervalle du cout de revient d'une categorie
     * et d'une offre en generale.
     * @param pListe la liste de produits a examiner
     * @return une hashmap. La cle '0' donne le prix d'achat minimal, '1' le maximal.
     */
    public static HashMap<Integer,Float> intervalleCoutAchat(ArrayList<Produit> pListe){
        HashMap<Integer, Float> intervalle = new HashMap<>();
        float minimum = 0, maximum = 0;
        for(Produit p : pListe){
            if(minimum==0){ //On initialise les valeurs a celles du premier produit
                minimum = p.prixAchat;
                maximum = p.prixAchat;
            }
            if(p.prixAchat<minimum)
                minimum = p.prixAchat;
            if(p.prixAchat>maximum)
                maximum = p.prixAchat;
        }
        intervalle.put(0,minimum);
        intervalle.put(1,maximum);
        return intervalle;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
