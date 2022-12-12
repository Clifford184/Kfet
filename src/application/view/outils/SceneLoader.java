package application.view.outils;

import application.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

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
            fxmlLoader = new FXMLLoader(SceneLoader.class.getResource(pChemin));
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("Erreur chargement fxml");
            //affichage fenetre crash, sauvegarder et quitter.

        }
        stage.setTitle(pNom);
        stage.setResizable(true);
        stage.setMinWidth(pMinWidth);
        stage.setMinHeight(pMinHeight);
        stage.setScene(scene);

        return fxmlLoader.getController();
    }

    public static ControllerEtPane loadPane(String pChemin){
        pChemin = pChemin.replaceAll("//", File.separator);
        FXMLLoader loader = new FXMLLoader(SceneLoader.class.getResource(pChemin));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {

            //affichage fenetre crash, sauvegarder et quitter.

        }
        return new ControllerEtPane(loader.getController(),pane);
    }

}
