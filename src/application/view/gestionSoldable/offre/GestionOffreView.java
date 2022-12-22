package application.view.gestionSoldable.offre;

import application.controller.Observable;
import application.controller.gestionSoldable.offre.GestionOffreController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionOffreView extends View {

    public GestionOffreView()  {
        cheminVue = "/ressource/view/gestionSoldable/offre/gestionOffre.fxml";
        minWidth = 880;
        minHeight = 580;
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
                    case "offre" -> {
                        // Update du menu en fonctions des soldable existant
                        //getViewController().setListeCategorie(Categorie.getCategorieListe());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
