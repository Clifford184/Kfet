package application.view.compte.gestionGroupe;

import application.controller.Observable;
import application.controller.compte.gestionGroupe.GestionGroupeController;
import application.model.client.Groupe;
import application.view.View;
import application.view.ViewController;
import application.outils.SceneLoader;
import javafx.stage.Stage;

public class GestionGroupeView extends View {

    public GestionGroupeView()  {
        cheminVue = "/ressource/view/compte/gestionGroupe.fxml";
        nomFenetre = "Gestion groupe";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionGroupeController());
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
                    case "initialiseView" -> {
                        // Update de la vue pour initialiser les imagesView
                        getViewController().initialiserView();
                    }
                    case "menu" -> {
                        // initialise le menu
                        getViewController().initialisationMenu();
                    }
                    case "groupe" -> {
                        // Update de la liste des groupe de la view
                        getViewController().setGroupeListView(Groupe.getGroupeListe());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GestionGroupeController getController() {
        return (GestionGroupeController) super.getController();
    }

    @Override
    public GestionGroupeViewController getViewController() {
        return (GestionGroupeViewController) super.getViewController();
    }

}
