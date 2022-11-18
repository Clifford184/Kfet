package application.view.gestionSoldable.produit.crudProduit;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.CrudProduitController;
import application.model.vendable.Type;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrudProduitView extends View {

    public CrudProduitView() {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudProduitController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "/ressource/view/crudProduit.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(CrudProduitView.class.getResource(fileName));

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

    public void changerScene(View view) {
        try {
            Stage stage = (Stage) getViewController().getViewCrudProduit().getScene().getWindow();
            view.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "type":
                        getViewController().setListeType(Type.getTypeListe());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CrudProduitController getController() {
        return (CrudProduitController) super.getController();
    }

    @Override
    public CrudProduitViewController getViewController() {
        return (CrudProduitViewController) super.getViewController();
    }
}
