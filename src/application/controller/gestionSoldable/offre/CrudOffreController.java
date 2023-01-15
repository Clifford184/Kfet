package application.controller.gestionSoldable.offre;

import application.controller.Controller;
import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.outils.ImageManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CrudOffreController extends Controller {

    TemplateOffre templateOffre;
    ArrayList<Produit> blacklist = new ArrayList<>();

    @Override
    public void initialize() {}

    public HashMap<Integer,Float> intervalleCoutAchat(ArrayList<Categorie> pCategorieListe){
        HashMap<Integer,Float> intervalle = new HashMap<>();
        intervalle.put(0,0f);
        intervalle.put(1,0f);

        for(Categorie c : pCategorieListe){
            ArrayList<Produit> produitListe = c.listeTousLesProduits();
            produitListe.removeAll(blacklist);

            HashMap<Integer,Float> intervalleTmp = Produit.intervalleCoutAchat(produitListe);
            intervalle.put(0,intervalle.get(0)+intervalleTmp.get(0));
            intervalle.put(1,intervalle.get(1)+intervalleTmp.get(1));
        }

        return intervalle;
    }

    public void creerOffreTemplate(String pNom, float pPrixVente, float pPrixVenteMembre, ArrayList<Categorie> pCategorieListe,
                                   String pCheminImage) throws IOException {
        new TemplateOffre(pNom,pPrixVente,pPrixVenteMembre,pCategorieListe,blacklist,pCheminImage);
    }

    public void modificationOffre(String pNom, float pPrixVente, float pPrixVenteMembre, ArrayList<Categorie> pCategorieListe
                                   , String pCheminImage){
        templateOffre.setNom(pNom);
        templateOffre.setPrixVente(pPrixVente);
        templateOffre.setPrixMembre(pPrixVenteMembre);
        templateOffre.setCategorieListe(pCategorieListe);
        templateOffre.setBlackList(blacklist);
        templateOffre.setCheminImage(ImageManager.genererNouvelleImage(pCheminImage, pNom));
    }

    public void setTemplateOffre(TemplateOffre pOffre){
        templateOffre = pOffre;
    }

    public void ajouterBlacklist(Produit pProduit){
        blacklist.add(pProduit);
    }

    public void retirerBlacklist(Produit pProduit){
        blacklist.remove(pProduit);
    }

    public void setBlacklist(ArrayList<Produit> pListe){
        blacklist.addAll(pListe);
    }

    /**
     * Permet de savoir si un produit est deja dans la blacklist
     * @param produit le produit a verifier
     * @return true si il est dans la liste
     */
    public boolean blacklistContains(Produit produit){
        return blacklist.contains(produit);
    }

}
