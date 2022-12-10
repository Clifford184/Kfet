package application.view.compte.DebitArgentCompte;

import application.controller.Observable;
import application.controller.compte.DebitArgentCompte.DebitArgentCompteController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DebitArgentCompteView extends View {

    public DebitArgentCompteView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new DebitArgentCompteController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // In the case of the separator for the resources, it's the same for every OS: '/'.
        // So there is no need to use File.separator.
        String fileName = "/ressource/view/compte/debitArgentCompte.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(DebitArgentCompteView.class.getResource(fileName));

        // Creation of the scene.
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("gestionnaire cafétéria");
        stage.setResizable(true);
        stage.setMinWidth(440);
        stage.setMinHeight(250);
        stage.setScene(scene);

        // Get the controller which controls the elements of the view.
        setViewController(fxmlLoader.getController());
        getViewController().setView(this);

        // Get the controller of the view.
        initialize();
        //getViewController().initialise();

        // Show the view.
        stage.show();
    }

    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "commande" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setSomme(getController().getSommeAdebiter());
                    }
                    case "client" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setLibelleClient(getController().getClient());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * methode pour fermer la fenetre de comfirmation
     */
    public void changerPage(View pPageDestination) {
        try {
            Stage stage = (Stage) getViewController().getViewArgentConfimation().getScene().getWindow();
            pPageDestination.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public DebitArgentCompteController getController() {
        return (DebitArgentCompteController) super.getController();
    }

    @Override
    public DebitArgentCompteViewController getViewController() {
        return (DebitArgentCompteViewController) super.getViewController();
    }

}
