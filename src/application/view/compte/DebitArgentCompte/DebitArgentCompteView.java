package application.view.compte.DebitArgentCompte;

import application.controller.Observable;
import application.controller.compte.DebitArgentCompte.DebitArgentCompteController;
import application.view.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class DebitArgentCompteView extends View {

    public DebitArgentCompteView()  {
        cheminVue = "/ressource/view/compte/debitArgentCompte.fxml";
        minWidth = 440;
        minHeight = 250;
        nomFenetre = "Debit argent";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new DebitArgentCompteController());
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
                    case "commande" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setSomme(getController().getSommeAdebiter());
                    }
                    case "client" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setLibelleClient(getController().getClient());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DebitArgentCompteController getController() {
        return (DebitArgentCompteController) super.getController();
    }

    @Override
    public DebitArgentCompteViewController getViewController() {
        return (DebitArgentCompteViewController) super.getViewController();
    }

}
