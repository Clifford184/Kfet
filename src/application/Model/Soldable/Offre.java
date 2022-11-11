package application.Model.Soldable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Decrit une offre qui a ete choisie lors d'une commande
 * La liste des produits a ete definis en suivant un template d'offre
 */
public class Offre extends Vendable {

    ArrayList<Produit> produitListe;

    public Offre(TemplateOffre pTemplateOffre, ArrayList<Produit> pProduits) throws IOException {
        super(pTemplateOffre.getNom(), 0, pTemplateOffre.getPrixVente());

        produitListe = pProduits;
    }
}
