package application.model;


import application.model.vendable.Offre;
import application.model.vendable.Produit;
import application.model.vendable.Vendable;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Decrit le panier lors d'une prise de commande, puis ensuite associe
 * a une commande
 */
public class Panier implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    ArrayList<Vendable> vendableListe;

    static ArrayList<Panier> panierListe = new ArrayList<>();

    public static Panier panierCourant;
    boolean termine = false;

    /**
     * Cree un nouveau panier vide
     */
    public Panier(){
        id = UUID.randomUUID();

        vendableListe = new ArrayList<>();
        panierCourant = this;
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

    /**
     * Vide le panier de tous ses elements et remplis le stock
     */
    public void viderPanier(){
        Stock stock = Stock.getInstance();
        for(Vendable v : vendableListe){
            if(v instanceof Offre){
                for(Produit p : ((Offre)v).getProduitListe()){
                    stock.remplirStock(p,1);
                }
            }else{
                stock.remplirStock((Produit)v,1);
            }
        }
        vendableListe.clear();
    }

    @Override
    public String toString(){
        StringBuilder aRetourner = new StringBuilder();
        for(Vendable p : vendableListe){
            aRetourner.append(p.toString()).append(" ");
        }
        return aRetourner.toString();
    }

    public void terminerPanier(){
        termine = true;
    }

    public boolean getTerminePanier(){
        return termine;
    }

    public ArrayList<Vendable> getVendableListe(){
        return vendableListe;
    }

}
