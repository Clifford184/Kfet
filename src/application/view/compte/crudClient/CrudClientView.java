package application.view.compte.crudClient;

import application.controller.Observable;
import application.controller.compte.crudClient.CrudClientController;
import application.model.client.Groupe;
import application.view.View;
import application.view.ViewController;
import application.view.outils.SceneLoader;
import javafx.stage.Stage;

public class CrudClientView extends View {

    public CrudClientView()  {
        cheminVue = "/ressource/view/compte/crudClient.fxml";
        minWidth = 880;
        minHeight = 580;
        nomFenetre = "Nouveau client";
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudClientController());
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
                    case "initialiseView" -> {
                        // Update de la vue pour initialiser les imagesView
                        getViewController().initialiserView();
                    }
                    case "promo" -> {
                        // Update de la comboBox des promo
                        getViewController().setPromoComboBox(Groupe.getGroupeListe());
                    }
                    case "client" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setClient(getController().getClient());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CrudClientController getController() {
        return (CrudClientController) super.getController();
    }

    @Override
    public CrudClientViewController getViewController() {
        return (CrudClientViewController) super.getViewController();
    }

}
