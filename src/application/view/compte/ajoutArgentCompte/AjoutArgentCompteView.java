package application.view.compte.ajoutArgentCompte;

import application.controller.Observable;
import application.controller.compte.ajoutArgentCompte.AjoutArgentCompteController;
import application.view.View;
import application.view.ViewController;
import application.outils.SceneLoader;
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
                        // Charge les elements graphiques de la vue
                        getViewController().initialiserView();
                    }
                    case "client" -> {
                        // Mise a jour du client a qui on ajoute argent
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
