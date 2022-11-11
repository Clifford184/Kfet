package application.model.vendable;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Decrit une offre qui a ete choisie lors d'une commande
 * La liste des produits a ete definis en suivant un template d'offre
 * Lors d'une commande, si l'utilisateur choisit une offre, nous appelons
 * le constructeur Vendable car nous avons besoin d'avoir un parent commmun entre
 * Offre et Produit pour le code lie au passage de la commande.
 * On peut voir une offre comme un Produit temporaire le temps d'une commande, et
 * ayant un comportement special.
 * Une des differences est qu'on ne doit pas creer une image lors qu'un objet Offre
 * est cree. Son image sera geree par TemplateOffre. De meme que pour son prix de vente.
 */
public class Offre extends Vendable implements Serializable {

    ArrayList<Produit> produitListe;

    public Offre(TemplateOffre pTemplateOffre, ArrayList<Produit> pProduits) throws IOException {
        super(pTemplateOffre.getNom(), 0, pTemplateOffre.getPrixVente(), "");

        image = ImageIO.read(new File(pTemplateOffre.cheminImage));

        produitListe = pProduits;
    }
}
