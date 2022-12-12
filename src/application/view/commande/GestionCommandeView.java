package application.view.commande;

import application.controller.Observable;
import application.controller.commande.GestionCommandeController;
import application.controller.gestionSoldable.produit.StockController;
import application.view.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionCommandeView extends View {
    /**
     * constructeur par défaut
     */
    public GestionCommandeView() {
        cheminVue = "/ressource/view/commande/gestionCommande.fxml";
        minWidth = 880;
        minHeight = 490;
        nomFenetre = "Gestion commande";
        setController(null);
    }

    /**
     * methode d'initialisation du controller de la vue
     */
    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionCommandeController());
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

    public void changerScene() throws Exception {

    }

    @Override
    public void update(Observable observable, String[] messages) {
        for (String message : messages) {
            switch (message) {
                case "commande_modifiee" -> {
                    // Update du menu en fonctions des soldable existant
                    getViewController().recharger();
                }
            }
        }
    }

    public void changerScene(View view) {
        try {
            Stage stage = (Stage) getViewController().getViewGestionCommande().getScene().getWindow();
            view.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GestionCommandeController getController() {
        return (GestionCommandeController) super.getController();
    }

    @Override
    public GestionCommandeViewController getViewController() {
        return (GestionCommandeViewController) super.getViewController();
    }
}
