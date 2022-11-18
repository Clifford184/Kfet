package application.model.vendable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Regroupe diffents produits qui ont un attribut commun
 * Par exemple le Type Pizza peut regrouper Pizza royale, Pizza 4 fromage, ...
 * Le Type Snack peut regrouper Snickers, Mars, Kinder Bueno, ...
 */
public class Type implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    String nom;
    Categorie categorie;
    ArrayList<Produit> produitListe = new ArrayList<>();

    String cheminImage;
    transient BufferedImage image;

    private static ArrayList<Type> typeListe = new ArrayList<>();

    /**
     * Cree un nouveau type
     * @param pNom son nom
     * @param pCategorie sa categorie associee
     * @param pCheminImage le chemin de son image
     * @throws IOException si un probleme est rencontre lors de la lecture/ecriture de l'image
     */
    public Type(String pNom, Categorie pCategorie, String pCheminImage) throws IOException {
        nom = pNom;
        categorie = pCategorie;
        typeListe.add(this);

        if(pCheminImage==null){  //Utilisation de l'image par defaut.
            cheminImage = "src/ressource/image/type/imageParDefaut.png";
        }else{
            cheminImage = "src/ressource/image/type/"+nom+"-"+ UUID.randomUUID().toString()+".png";
            image = ImageIO.read(new File(pCheminImage));
            ImageIO.write(image, "png", new File(cheminImage));
        }
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Type p : typeListe){
            if(p.id.equals(this.id))
                return p;
        }
        typeListe.add(this);
        return this;
    }

    public ArrayList<Produit> getProduitListe() {
        return produitListe;
    }

    public void setName(String pNewName){
        nom = pNewName;
    }

    public String getName() {
        return nom;
    }

    public static void deleteType(Type pType){
        typeListe.remove(pType);
    }

    public static ArrayList<Type> getTypeListe() {
        return typeListe;
    }

    @Override
    public String toString() {
        return nom;
    }

}
