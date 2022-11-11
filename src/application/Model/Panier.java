package application.Model;


import application.Model.Soldable.Vendable;

import java.util.ArrayList;

/**
 * Decrit le panier d'une commande
 */
public class Panier {

    ArrayList<Vendable> vendableListe;

    /**
     * Cree un nouveau panier vide
     */
    public Panier(){

        vendableListe = new ArrayList<>();
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
