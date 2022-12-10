package application.view.gestionSoldable.type.crudType;

import application.controller.Observable;
import application.controller.gestionSoldable.type.CrudTypeController;
import application.model.vendable.Categorie;
import application.view.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrudTypeView extends View {

    public CrudTypeView()  {
        cheminVue = "/ressource/view/gestionSoldable/type/crudType.fxml";
        minWidth = 880;
        minHeight = 580;
        nomFenetre = "Gestion type";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudTypeController());
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
            Stage stage = (Stage) getViewController().getViewCrudType().getScene().getWindow();
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
                    case "categorie" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setListeCategorie(Categorie.categorieListe);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        Stage stage = (Stage)  getViewController().getNomType().getScene().getWindow();
        stage.close();
    }

    @Override
    public CrudTypeController getController() {
        return (CrudTypeController) super.getController();
    }

    @Override
    public CrudTypeViewController getViewController() {
        return (CrudTypeViewController) super.getViewController();
    }
}
