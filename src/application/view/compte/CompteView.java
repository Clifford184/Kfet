package application.view.compte;

import application.controller.Observable;
import application.controller.compte.CompteController;
import application.view.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CompteView extends View {

    public CompteView()  {
        cheminVue = "/ressource/view/compte/compteView.fxml";
        minWidth = 880;
        minHeight = 580;
        nomFenetre = "Compte";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CompteController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewController viewController = SceneLoader.loadScene(stage,cheminVue,nomFenetre,minWidth,minHeight);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();

        stage.show();
    }

    /**
     * methode pour changer de page
     * @param pPageDestination vue de destination
     */
    public void changerPage(View pPageDestination) {
        try {
            Stage stage = (Stage) getViewController().getViewCompte().getScene().getWindow();
            pPageDestination.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "menu" -> {
                        // initialise le menu
                        getViewController().initialisationMenu();
                    }
                    case "client" -> {
                        // Update du menu en fonctions des soldable existant
                       getViewController().initialize(); //TODO modification
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changerScene(View view) {
        try {
            Stage stage = (Stage) getViewController().getViewCompte().getScene().getWindow();
            view.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CompteController getController() {
        return (CompteController) super.getController();
    }

    @Override
    public CompteViewController getViewController() {
        return (CompteViewController) super.getViewController();
    }
}
