package application.controller.gestionSoldable.offre;

import application.controller.Controller;
import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CrudOffreController extends Controller {

    TemplateOffre templateOffre;

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

    public void creerOffreTemplate(String pNom, float pPrixVente, float pPrixVenteMembre, ArrayList<Categorie> pCategorieListe,
                                   ArrayList<Produit> pBlacklist, String pCheminImage) throws IOException {
        new TemplateOffre(pNom,pPrixVente,pPrixVenteMembre,pCategorieListe,pBlacklist,pCheminImage);
    }

    public void modificationOffre(String pNom, float pPrixVente, float pPrixVenteMembre, ArrayList<Categorie> pCategorieListe,
                                   ArrayList<Produit> pBlacklist, String pCheminImage){
        templateOffre.setNom(pNom);
        templateOffre.setPrixVente(pPrixVente);
        templateOffre.setPrixMembre(pPrixVenteMembre);
        templateOffre.setCategorieListe(pCategorieListe);
        templateOffre.setBlackList(pBlacklist);
        templateOffre.setCheminImage(pCheminImage);
    }

    public void setTemplateOffre(TemplateOffre pOffre){
        templateOffre = pOffre;
    }

}
