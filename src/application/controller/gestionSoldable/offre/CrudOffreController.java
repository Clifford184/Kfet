package application.controller.gestionSoldable.offre;

import application.controller.Controller;
import application.model.vendable.Categorie;
import application.model.vendable.Produit;

import java.util.ArrayList;
import java.util.HashMap;

public class CrudOffreController extends Controller {

    @Override
    public void initialize() {}

    public HashMap<Integer,Float> intervalleCoutAchat(ArrayList<Categorie> pCategorieListe, ArrayList<Produit> pBlacklist){
        HashMap<Integer,Float> intervalle = new HashMap<>();
        intervalle.put(0,0f);
        intervalle.put(1,0f);

        for(Categorie c : pCategorieListe){
            ArrayList<Produit> produitListe = c.listeTousLesProduits();
            produitListe.removeAll(pBlacklist);

            HashMap<Integer,Float> intervalleTmp = Produit.intervalleCoutAchat(produitListe);
            intervalle.put(0,intervalle.get(0)+intervalleTmp.get(0));
            intervalle.put(1,intervalle.get(1)+intervalleTmp.get(1));
        }

        return intervalle;
    }

}
