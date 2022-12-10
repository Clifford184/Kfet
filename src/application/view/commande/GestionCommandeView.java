package application.view.commande;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.StockController;
import application.view.SceneLoader;
import application.view.View;
import application.view.ViewController;
import application.view.gestionSoldable.produit.stock.GestionStockView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionCommandeView extends View {
    /**
     * constructeur par défaut
     */
    public GestionCommandeView() {
        cheminVue = "/ressource/view/commande/gestionCommande.fxml";
        minWidth = 880;
        minHeight = 580;
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

    public void changerScene() throws Exception {

    }

    @Override
    public void update(Observable observable, String[] messages) {
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
    public StockController getController() {
        return (StockController) super.getController();
    }

    @Override
    public GestionCommandeViewController getViewController() {
        return (GestionCommandeViewController) super.getViewController();
    }
}
