package application.view.gestionSoldable.categorie;

import application.controller.Observable;
import application.controller.gestionSoldable.categorie.GestionCategorieController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionCategorieView extends View {

    public GestionCategorieView()  {
        cheminVue = "/ressource/view/gestionSoldable/categorie/gestionCategorie.fxml";
        nomFenetre = "Gestion categorie";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionCategorieController());
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
    public GestionCategorieController getController() {
        return (GestionCategorieController) super.getController();
    }

    @Override
    public GestionCategorieViewController getViewController() {
        return (GestionCategorieViewController) super.getViewController();
    }


}
