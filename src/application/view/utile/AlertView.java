package application.view.utile;

import application.controller.Observable;
import application.controller.utile.AlertController;
import application.view.View;
import application.view.ViewController;
import application.view.outils.SceneLoader;
import javafx.stage.Stage;

public class AlertView extends View {

    public AlertView()  {
        cheminVue = "/ressource/view/utile/alertView.fxml";
        minWidth = 400;
        minHeight = 200;
        nomFenetre = "Alert";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new AlertController());
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

    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "alertMessage" -> {
                        // initialise le menu
                        getViewController().setAlertLabel(getController().getMessage());
                    }
                    case "initialisationView" -> {
                        // initialise le menu
                        getViewController().initialiserView();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AlertController getController() {
        return (AlertController) super.getController();
    }

    @Override
    public AlertViewController getViewController() {
        return (AlertViewController) super.getViewController();
    }
}