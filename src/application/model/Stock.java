package application.model;

import application.model.vendable.Produit;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Permet de gerer le nombre de chaque produit disponible a la vente.
 * Gestion du stock en temps reel.
 */
public class Stock implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    HashMap<Produit, Integer> stock;

    static Stock singleton;

    private Stock(){
        stock = new HashMap<>();
    }

    /**
     * Permet de savoir combien d'exemplaire il y a de ce produit
     * @param pProduit le produit a regarder
     * @return son nombre en stock
     */
    public int combienEnStock(Produit pProduit){
        return stock.get(pProduit);
    }

    /**
     * Ajoute un nouveau produit disponible a la vente
     * Il sera ajoute en 0 exemplaire
     * @param pProduit le produit a ajouter
     */
    public void ajouterNouveauProduit(Produit pProduit){
        if(stock.get(pProduit)!=null)
            return; //Gerer l'erreur
        stock.put(pProduit,0);
    }

    /**
     * Supprime un produit disponible a la vente.
     * Il sera supprime et ne sera plus accessible
     * @param pProduit le produit a retirer
     */
    public void supprimerProduit(Produit pProduit){
        if(stock.get(pProduit)==null)
            return; //Gerer l'erreur
        stock.remove(pProduit);
    }

    /**
     * Retire 1 exemplaire de chaque produits de la liste
     * @param pProduitListe la liste des produits
     */
    public void retirerDuStock(ArrayList<Produit> pProduitListe){
        for(Produit p : pProduitListe){
            Integer nombre = stock.get(p);
            if(nombre == 0){
                //ERREURUURUURRUR
            }
            nombre--;
            stock.put(p,nombre);
        }
    }

    /**
     * Retire pNombre exemplaire du produit du stock
     * @param pProduit le produit concerne
     * @param pNombre son nombre d'exemplaire a retirer
     * @return true si succes
     */
    public boolean retirerDuStock(Produit pProduit, int pNombre){
        Integer nombre = stock.get(pProduit);
        if(nombre<pNombre){
            return false;
        }
        nombre -= pNombre;
        stock.put(pProduit, nombre);
        return true;
    }

    /**
     * Remplis de pNombre exemplaire le nombre de pProduit en stock
     * @param pProduit le produit concerne
     * @param pNombre son nombre d'exemplaire a ajouter
     */
    public void remplirStock(Produit pProduit, int pNombre){
        Integer nombre = stock.get(pProduit);
        nombre += pNombre;
        stock.put(pProduit, nombre);
    }

    /**
     * Recupere l'unique instance de Stock (singleton)
     * @return l'objet Stock
     */
    public static Stock getInstance(){
        if(singleton==null)
            singleton=new Stock();
        return singleton;
    }

}
