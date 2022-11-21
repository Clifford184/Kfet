package application.model.vendable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Decrit un element qui est propose a la vente (menu ou produit)
 */
public abstract class Vendable implements Serializable {

    String nom;
    float prixAchat;
    float prixVente;
    String cheminImage;
    transient BufferedImage image;

    /**
     * Cree un nouvel element vendable
     * L'image correspondant au chemin passe en parametre sera copie dans le
     * repertoire de l'application. L'utilisateur n'a pas a garder son image.
     * @param pNom son nom
     * @param pPrixAchat son prix d'achat
     * @param pPrixVente son prix de vente
     * @param pCheminImage le chemin de l'image associee
     * @throws IOException si un probleme est rencontre lors de la lecture/ecriture de l'image
     */
    public Vendable(String pNom, float pPrixAchat, float pPrixVente, String pCheminImage) throws IOException {

        nom = pNom;
        prixVente = pPrixVente;
        prixAchat = 0;

        if(this instanceof Offre){
            for(Produit p : ((Offre) this).produitListe){
                pPrixAchat += p.prixAchat;
            }
            return;
        }else{
            prixAchat = pPrixAchat;
        }

        if(pCheminImage.equals("")){  //Utilisation de l'image par defaut.
            cheminImage = "asset"+File.separator+"image/vendable/imageParDefaut.png";
        }else{
            cheminImage = "asset/image/vendable/"+nom+"-"+UUID.randomUUID().toString()+".png";

            //image = ImageIO.read(new File(pCheminImage));
            //ImageIO.write(image, "png", new File(cheminImage));
        }

    }

    /**
     * Supprime de l'espace de stockage l'image associee a cet objet
     * @return true si l'image a bien ete supprimee
     */
    public boolean supprimerFichierImage(){
        File f = new File(cheminImage);
        return f.delete();
    }

    @Override
    public String toString(){
        return nom +" : "+ prixVente +"e";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
