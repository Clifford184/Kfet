package application.view.gestionSoldable.offre;

import application.controller.Observable;
import application.controller.gestionSoldable.offre.GestionOffreController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionOffreView extends View {

    public GestionOffreView() {
        cheminVue = "/ressource/view/gestionSoldable/offre/gestionOffre.fxml";
        nomFenetre = "Gestion offre";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionOffreController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewController viewController = SceneLoader.loadScene(stage, cheminVue, nomFenetre);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();

        stage.show();
    }


    @Override
    public void update(Observable observable, String[] messages) {
        for (String message : messages) {
            switch (message) {
                case "menu" -> {
                    // initialise le menu
                    getViewController().initialisationMenu();
                }
                case "offre" -> {
                    // Update de offre
                    //getViewController().setListeCategorie(Categorie.getCategorieListe());
                }
            }
        }
    }

    @Override
    public GestionOffreController getController() {
        return (GestionOffreController) super.getController();
    }

    @Override
    public GestionOffreViewController getViewController() {
        return (GestionOffreViewController) super.getViewController();
    }


}
