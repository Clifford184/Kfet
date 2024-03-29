package application.view.gestionSoldable.produit.stock;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.StockController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionStockView extends View {

    /**
     * constructeur par défaut
     */
    public GestionStockView() {
        cheminVue = "/ressource/view/gestionSoldable/stock/stock.fxml";
        nomFenetre = "Gestion stock";
        setController(null);
    }

    /**
     * methode d'initialisation du controller de la vue
     */
    @Override
    public void initialize() {
        // Initialization of the controller
        if (getController() == null) {
            setController(new StockController());
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
            }
        }
    }

    @Override
    public StockController getController() {
        return (StockController) super.getController();
    }

    @Override
    public GestionStockViewController getViewController() {
        return (GestionStockViewController) super.getViewController();
    }
}
