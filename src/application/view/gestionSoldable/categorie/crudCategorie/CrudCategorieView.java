package application.view.gestionSoldable.categorie.crudCategorie;

import application.controller.Observable;
import application.controller.gestionSoldable.categorie.CrudCategorieController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class CrudCategorieView extends View {

    public CrudCategorieView()  {

        cheminVue = "/ressource/view/gestionSoldable/categorie/crudCategorie.fxml";
        nomFenetre = "Gestion categorie";

        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudCategorieController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewController viewController = SceneLoader.loadScene(stage, cheminVue, nomFenetre);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();

        stage.show();
    }

    @Override
    public void update(Observable observable, String[] messages) {}


    public void close() {
        Stage stage = (Stage)  getViewController().getNomCategorie().getScene().getWindow();
        stage.close();
    }

    @Override
    public CrudCategorieController getController() {
        return (CrudCategorieController) super.getController();
    }

    @Override
    public CrudCategorieViewController getViewController() {
        return (CrudCategorieViewController) super.getViewController();
    }
}
