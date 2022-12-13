package application.view.compte.crudGroupe;

import application.controller.Observable;
import application.controller.compte.crudGroupe.CrudGroupeController;
import application.view.View;
import application.view.ViewController;
import application.view.outils.SceneLoader;
import javafx.stage.Stage;

public class CrudGroupeView extends View {

    public CrudGroupeView()  {
        cheminVue = "/ressource/view/compte/crudGroupe.fxml";
        minWidth = 880;
        minHeight = 580;
        nomFenetre = "Gestion groupe";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudGroupeController());
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
                        // Update de la vue pour initialiser les imagesView
                        getViewController().initialiserView();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CrudGroupeController getController() {
        return (CrudGroupeController) super.getController();
    }

    @Override
    public CrudGroupeViewController getViewController() {
        return (CrudGroupeViewController) super.getViewController();
    }

}
