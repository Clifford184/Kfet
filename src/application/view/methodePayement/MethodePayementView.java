package application.view.methodePayement;

import application.controller.Observable;
import application.controller.methodePayement.MethodePayementController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MethodePayementView extends View {

    public MethodePayementView()  {
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
        String fileName = "/ressource/view/methodePayement/methodePayementView.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(MethodePayementView.class.getResource(fileName));

        // Creation of the scene.
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("gestionnaire cafétéria");
        stage.setResizable(true);
        stage.setMinWidth(880);
        stage.setMinHeight(580);
        stage.setWidth(880);
        stage.setHeight(580);
        stage.setScene(scene);

        // Get the controller which controls the elements of the view.
        setViewController(fxmlLoader.getController());
        getViewController().setView(this);

        // Get the controller of the view.
        initialize();

        // Show the view.
        stage.show();
    }

    @Override
    public void update(Observable observable, String[] messages) {}

    /**
     * methode pour changer de page
     * @param pPageDestination vue de destination
     */
    public void changerPage(View pPageDestination) {
        try {
            Stage stage = (Stage) getViewController().getViewModePayement().getScene().getWindow();
            pPageDestination.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public MethodePayementController getController() {
        return (MethodePayementController) super.getController();
    }


    @Override
    public MethodePayementViewController getViewController() {
        return (MethodePayementViewController) super.getViewController();
    }
}
