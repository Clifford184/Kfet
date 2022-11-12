package application.model;

import application.model.vendable.Produit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Permet de gerer le nombre de chaque produit disponible a la vente.
 * Gestion du stock en temps reel.
 */
public class Stock implements Serializable {

    private HashMap<Produit, Integer> stock = new HashMap<>();

    static Stock singleton;

//    private void Stock(){
//        stock = new HashMap<>();
//    }

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
     */
    public void retirerDuStock(Produit pProduit, int pNombre){
        Integer nombre = stock.get(pProduit);
        if(nombre<pNombre){
            //ERREURUUEUURURUEU
        }
        nombre -= pNombre;
        stock.put(pProduit, nombre);
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

    public ArrayList<Produit> afficherListeProduit(){
        Set<Produit> set =  stock.keySet();
        ArrayList<Produit> listeProduit = new ArrayList<>();
        listeProduit.addAll(set);
        return listeProduit;
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
