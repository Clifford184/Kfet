package application.view.produit;

import application.Model.Client.Client;
import application.controller.Observable;
import application.controller.produit.GestionProduitController;
import application.view.View;
import application.view.produit.crudProduit.CrudProduitView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionProduitView extends View {

    public GestionProduitView()  {
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
        String fileName = "/ressource/view/gestionProduit.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(GestionProduitView.class.getResource(fileName));

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
        Stage stage = new Stage();

        CrudProduitView crudProduitView = new CrudProduitView();
        crudProduitView.start(stage);
    }

    @Override
    public void update(Observable observable, String[] messages) {}

    public void changerScene(View view) throws Exception {
        Stage stage = (Stage) getViewController().getSliderMenu().getScene().getWindow();
        view.start(stage);
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
