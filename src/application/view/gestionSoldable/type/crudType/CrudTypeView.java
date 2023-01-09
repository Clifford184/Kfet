package application.view.gestionSoldable.type.crudType;

import application.controller.Observable;
import application.controller.gestionSoldable.type.CrudTypeController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class CrudTypeView extends View {

    public CrudTypeView()  {
        cheminVue = "/ressource/view/gestionSoldable/type/crudType.fxml";
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
        ViewController viewController = SceneLoader.loadScene(stage,cheminVue,nomFenetre);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();

        stage.show();
    }

    @Override
    public void update(Observable observable, String[] messages) {

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
