package application.view.methodePayement;

import application.controller.Observable;
import application.controller.methodePayement.MethodePayementController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class MethodePayementView extends View {

    public MethodePayementView()  {
        cheminVue = "/ressource/view/methodePayement/methodePayementView.fxml";
        nomFenetre = "Choix methode paiement";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new MethodePayementController());
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
    public void update(Observable observable, String[] messages) {}

    @Override
    public MethodePayementController getController() {
        return (MethodePayementController) super.getController();
    }


    @Override
    public MethodePayementViewController getViewController() {
        return (MethodePayementViewController) super.getViewController();
    }
}
