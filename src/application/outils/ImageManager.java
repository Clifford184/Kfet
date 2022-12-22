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

    public static Image genererImage(String pChemin){
        Image image = null;
        try{
            image = new Image(ImageManager.class.getResource(pChemin).toString());
        }catch(Exception e){

        }
        return image;
    }

    public static String genererNouvelleImage(String pCheminImage, String pNom){

        String nouveauChemin;

        if(pCheminImage.equals("")){  //Utilisation de l'image par defaut.
            nouveauChemin = "asset"+File.separator+"image"+File.separator+"vendable"+File.separator+"imageParDefaut.png";
        }else{
            nouveauChemin = "asset"+File.separator+"image"+File.separator+"vendable"+File.separator+pNom+"-"+ UUID.randomUUID().toString()+".png";
            copierImage(pCheminImage, nouveauChemin);
        }
        return nouveauChemin;
    }

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
