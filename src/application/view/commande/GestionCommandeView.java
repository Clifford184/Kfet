package application.view.commande;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.StockController;
import application.view.View;
import application.view.gestionSoldable.produit.stock.GestionStockView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionCommandeView extends View {
    /**
     * constructeur par défaut
     */
    public GestionCommandeView() {
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
        String fileName = "/ressource/view/gestionCommande.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(GestionStockView.class.getResource(fileName));

        // Creation of the scene.
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("gestionnaire cafétéria");
        stage.setResizable(true);
        stage.setMinWidth(880);
        stage.setMinHeight(580);
        stage.setScene(scene);

        // Get the controller which controls the elements of the view.
        setViewController(fxmlLoader.getController());
        getViewController().setView(this);

        // Get the controller of the view.
        initialize();

        // Show the view.
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
