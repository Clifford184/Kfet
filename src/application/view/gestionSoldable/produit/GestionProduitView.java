package application.view.gestionSoldable.produit;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.GestionProduitController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionProduitView extends View {

    public GestionProduitView()  {
        cheminVue = "/ressource/view/gestionSoldable/produit/gestionProduit.fxml";
        nomFenetre = "Gestion produit";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionProduitController());
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
                    case "produit" -> {
                        // Update du menu en fonctions des soldable existant
                        //getViewController().setListeProduit(Stock.getInstance());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GestionProduitController getController() {
        return (GestionProduitController) super.getController();
    }

    @Override
    public GestionProduitViewController getViewController() {
        return (GestionProduitViewController) super.getViewController();
    }


}
