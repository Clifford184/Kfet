package application.view.gestionSoldable.produit.crudProduit;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.CrudProduitController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class CrudProduitView extends View {

    public CrudProduitView() {
        cheminVue = "/ressource/view/gestionSoldable/produit/crudProduit.fxml";
        nomFenetre = "Gestion produit";
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
        ViewController viewController = SceneLoader.loadScene(stage,cheminVue,nomFenetre);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();

        stage.show();
    }

    @Override
    public void update(Observable observable, String[] messages) {

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
