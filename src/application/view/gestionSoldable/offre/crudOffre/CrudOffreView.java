package application.view.gestionSoldable.offre.crudOffre;

import application.controller.Observable;
import application.controller.gestionSoldable.offre.CrudOffreController;
import application.view.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrudOffreView extends View {

    public CrudOffreView()  {
        cheminVue = "/ressource/view/gestionSoldable/offre/crudOffre.fxml";
        minWidth = 880;
        minHeight = 580;
        nomFenetre = "Gestion offre";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudOffreController());
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
    public void update(Observable observable, String[] messages) {}

    public void changerScene(View view)  {
        try {
            Stage stage = (Stage) getViewController().getViewCrudOffre().getScene().getWindow();
            view.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public CrudOffreController getController() {
        return (CrudOffreController) super.getController();
    }

    @Override
    public CrudOffreViewController getViewController() {
        return (CrudOffreViewController) super.getViewController();
    }
}
