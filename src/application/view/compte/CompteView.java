package application.view.compte;

import application.controller.Observable;
import application.controller.compte.CompteController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
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
                        // Update des elements graphiques et de la liste des clients
                       getViewController().initialiserView();
                    }
                }
            }
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
