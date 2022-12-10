package application.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SceneLoader {

    /**
     * Charge une scene et l'assigne a un objet Stage
     * @param stage le stage a qui il faudra assigner la scene
     * @param pChemin le chemin d'acces au fxml
     * @param pNom le nom de la fenetre
     * @param pMinWidth la longueur minimum de la fenetre
     * @param pMinHeight la hauteur minimum de la fenetre
     * @return
     */
    public static ViewController loadScene(Stage stage, String pChemin, String pNom, float pMinWidth, float pMinHeight){

        pChemin = pChemin.replaceAll("//", File.separator);

        FXMLLoader fxmlLoader = null;

        Scene scene = null;
        try {
            URL s = SceneLoader.class.getResource(pChemin);
            fxmlLoader = new FXMLLoader(s);
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {

            //affichage fenetre crash, sauvegarder et quitter.

        }
        stage.setTitle(pNom);
        stage.setResizable(true);
        stage.setMinWidth(pMinWidth);
        stage.setMinHeight(pMinHeight);
        stage.setScene(scene);

        return fxmlLoader.getController();

    }

    /*public FXMLLoader getLoader(ViewController pController, String pChemin){

    }*/

}
