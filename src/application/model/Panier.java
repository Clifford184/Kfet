package application.model;


import application.model.vendable.Categorie;
import application.model.vendable.Vendable;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Decrit le panier d'une commande
 */
public class Panier implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    ArrayList<Vendable> vendableListe;

    static ArrayList<Panier> panierListe = new ArrayList<>();

    /**
     * Cree un nouveau panier vide
     */
    public Panier(){

        vendableListe = new ArrayList<>();
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Panier p : panierListe){
            if(p.id.equals(this.id))
                return p;
        }
        panierListe.add(this);
        return this;
    }

    /**
     * Ajoute un element au panier
     * @param pVendable l'element a ajouter
     */
    public void ajouterElement(Vendable pVendable){
        vendableListe.add(pVendable);
    }

    /**
     * Retire un element du panier
     * @param pVendable l'element a essayer de retirer
     */
    public void enleverElement(Vendable pVendable){
        vendableListe.remove(pVendable);
    }

    /**
     * Calcul la valeur totale du panier
     * @return la valeur du panier
     */
    public float valeurPanier(){

        float value=0;
        for(Vendable s : vendableListe)
            value+=s.getPrixVente();

        return value;
    }

    @Override
    public String toString(){
        StringBuilder aRetourner = new StringBuilder();
        for(Vendable p : vendableListe){
            aRetourner.append(p.toString()).append(" ");
        }
        return aRetourner.toString();
    }

    public ArrayList<Vendable> getSoldableList(){
        return vendableListe;
    }

}
