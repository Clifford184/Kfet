package application.view.gestionSoldable.type;

import application.controller.Observable;
import application.controller.gestionSoldable.type.GestionTypeController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionTypeView extends View {

    public GestionTypeView()  {
        cheminVue = "/ressource/view/gestionSoldable/type/gestionType.fxml";
        nomFenetre = "Gestion type";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionTypeController());
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
                    case "menu" -> {
                        // initialise le menu
                        getViewController().initialisationMenu();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GestionTypeController getController() {
        return (GestionTypeController) super.getController();
    }

    @Override
    public GestionTypeViewController getViewController() {
        return (GestionTypeViewController) super.getViewController();
    }


}
