package application.view.compte.DebitArgentCompte;

import application.controller.Observable;
import application.controller.compte.DebitArgentCompte.DebitArgentCompteController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class DebitArgentCompteView extends View {

    public DebitArgentCompteView()  {
        cheminVue = "/ressource/view/compte/debitArgentCompte.fxml";
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
        ViewController viewController = SceneLoader.loadScene(stage,cheminVue,nomFenetre);

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
                        // Update de la commande pour le debit
                        getViewController().setSomme(getController().getSommeAdebiter());
                    }
                    case "client" -> {
                        // Update ddu client a debiter
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
