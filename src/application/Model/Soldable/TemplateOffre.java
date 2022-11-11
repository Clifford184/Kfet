package application.Model.Soldable;

import java.util.ArrayList;

/**
 * Permet de definir les offres qui sont disponibles
 * Une offre est un ensemble de produits qui si prix ensemble, permet d'avoir
 * un prix avantageux.
 * Un template est compose d'une liste de categorie, qui correspond a tous les
 * choix de produits disponible a l'indice i.
 * Par exemple, pour decrire une offre pizza ou picard + boisson ou snack, on aurait
 * categorieListe.get(0) = plat_chaud -> la categorie plat_chaud decrit les types picard et pizza
 * categorieListe.get(1) = supplement -> la categorie supplement decrit les types snack et boisson
 */
public class TemplateOffre {

    ArrayList<Categorie> categorieListe;
    String nom;
    float prixVente;

    ArrayList<Produit> blackList;

    public static ArrayList<TemplateOffre> templateOffreListe = new ArrayList<>();

    /**
     * Cree un nouveau template
     * Son prix d'achat sera calcule automatiquement, il correspond
     * a la somme des prix d'achats des produits concernes.
     * La blacklist contient l'ensemble des produits qui ne sont pas
     * compatible avec cette offre. Elle est constituee des produits provenant
     * de tous les types de toute les categories de la liste pCategorieListe.
     * @param pNom son nom
     * @param pPrixVente son prix de vente
     * @param pCategorieListe la liste de categorie le constituant
     * @param pBlacklist la liste des produits non compatibles avec cet offre
     */
    public TemplateOffre(String pNom, float pPrixVente, ArrayList<Categorie> pCategorieListe,
                         ArrayList<Produit> pBlacklist){
        nom = pNom;
        prixVente = pPrixVente;
        categorieListe = pCategorieListe;
        blackList = pBlacklist;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Categorie> getCategorieListe() {
        return categorieListe;
    }

    public void setTypeList(ArrayList<Categorie> typeList) {
        this.categorieListe = typeList;
    }


    public float getPrixVente() {
        return prixVente;
    }
}
