package application.view.gestionSoldable.produit.stock;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.StockController;
import application.view.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionStockView extends View {

    /**
     * constructeur par défaut
     */
    public GestionStockView() {
        cheminVue = "/ressource/view/gestionSoldable/stock/stock.fxml";
        minWidth = 880;
        minHeight = 580;
        nomFenetre = "Gestion stock";
        setController(null);
    }

    /**
     * methode d'initialisation du controller de la vue
     */
    @Override
    public void initialize() {
        // Initialization of the controller.
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changerScene(View view) {
        try {
            Stage stage = (Stage) getViewController().getViewGestionStock().getScene().getWindow();
            view.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
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
