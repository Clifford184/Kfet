package application.outils;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Permet de gerer les images. Leur chargement et gestion de la copie locale
 */
public class ImageManager {

    /**
     * Charge une image pour affichage
     * @param pChemin son chemin
     * @return l'image
     */
    public static Image chargerImage(String pChemin){
        if(pChemin==null)
            return null;
        if(pChemin.equals(""))
            return null;

        pChemin = pChemin.replaceAll("//", File.separator);

        Image image = null;
        try{
            if(pChemin.startsWith("asset")) {//image dynamique
                image = new Image("file:"+pChemin);
            }else{  //image ressource
                image = new Image(ImageManager.class.getResource(pChemin).toString());
            }

        }catch(Exception e){
            image = new Image("file:asset"+File.separator+"image"+File.separator+"probleme.png");
        }
        return image;
    }

    /**
     * Fait une copie locale d'une image
     * @param pCheminImage l'image a copier
     * @param pNom le nom a donner
     * @return le chemin de la nouvelle image
     */
    public static String genererNouvelleImage(String pCheminImage, String pNom){
        if (pCheminImage != null) {
            pCheminImage = pCheminImage.replaceAll("//", File.separator);
        }
        String nouveauChemin;

        if(pCheminImage == null || pCheminImage.equals("")){  //Utilisation de l'image par defaut.
            nouveauChemin = "asset"+File.separator+"image"+File.separator+"vendable"+File.separator+"imageParDefaut.png";
        }else{
            nouveauChemin = "asset"+File.separator+"image"+File.separator+"vendable"+File.separator+pNom+"-"+ UUID.randomUUID().toString()+".png";
            copierImage(pCheminImage, nouveauChemin);
        }
        return nouveauChemin;
    }

    /**
     * Copie une image
     * @param pACopier le chemin de l'image a copier
     * @param pNouveauChemin sa destination
     */
    private static void copierImage(String pACopier, String pNouveauChemin){
        try {
            BufferedImage image = ImageIO.read(new File(pACopier));
            ImageIO.write(image, "png", new File(pNouveauChemin));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Supprime de l'espace de stockage l'image associee
     * @return true si l'image a bien ete supprimee
     */
    public static boolean supprimerImage(String pCheminImage){
        File f = new File(pCheminImage);
        return f.delete();
    }

}
