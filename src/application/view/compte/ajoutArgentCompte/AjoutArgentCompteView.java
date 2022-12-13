package application.view.compte.ajoutArgentCompte;

import application.controller.Observable;
import application.controller.compte.ajoutArgentCompte.AjoutArgentCompteController;
import application.view.View;
import application.view.ViewController;
import application.view.outils.SceneLoader;
import javafx.stage.Stage;

public class AjoutArgentCompteView extends View {

    public AjoutArgentCompteView()  {
        cheminVue = "/ressource/view/compte/ajoutAgentCompte.fxml";
        minWidth = 440;
        minHeight = 250;
        nomFenetre = "Ajout argent";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new AjoutArgentCompteController());
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

    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "initialiseView" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().initialiserView();
                    }
                    case "client" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setClientLabel(getController().getClient());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AjoutArgentCompteController getController() {
        return (AjoutArgentCompteController) super.getController();
    }

    @Override
    public AjoutArgentCompteViewController getViewController() {
        return (AjoutArgentCompteViewController) super.getViewController();
    }

}