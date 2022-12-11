package application.view.gestionSoldable.produit.crudProduit;

import application.controller.Observable;
import application.controller.gestionSoldable.produit.CrudProduitController;
import application.model.vendable.Type;
import application.view.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class CrudProduitView extends View {

    public CrudProduitView() {
        cheminVue = "/ressource/view/gestionSoldable/produit/crudProduit.fxml";
        minWidth = 880;
        minHeight = 580;
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
        ViewController viewController = SceneLoader.loadScene(stage,cheminVue,nomFenetre,minWidth,minHeight);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();

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
