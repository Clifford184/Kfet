package application.Model.Soldable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Decrit un element qui est propose a la vente (menu ou produit)
 */
public abstract class Vendable {

    String nom;
    float prixAchat;
    float prixVente;
    BufferedImage image;

    /**
     * Cree un nouvel element vendable
     * @param pNom son nom
     * @param pPrixAchat son prix d'achat
     * @param pPrixVente son prix de vente
     * @throws IOException si il y a un probleme lors de la manipulation de l'image
     */
    public Vendable(String pNom, float pPrixAchat, float pPrixVente) throws IOException {

        nom = pNom;
        prixVente = pPrixVente;
        prixAchat = 0;

        if(this instanceof Offre){
            for(Produit p : ((Offre) this).produitListe){
                pPrixAchat += p.prixAchat;
            }
        }else{
            prixAchat = pPrixAchat;
        }

        //A revoir
        image = ImageIO.read(new File("image/soldable"+ nom +".png"));
    }

    @Override
    public String toString(){
        return nom +":"+ prixVente +"e";
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
