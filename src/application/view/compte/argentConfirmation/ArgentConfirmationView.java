package application.view.compte.argentConfirmation;

import application.controller.Observable;
import application.controller.compte.argentConfirmation.ArgentConfirmationController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArgentConfirmationView extends View {

    public ArgentConfirmationView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new ArgentConfirmationController());
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
        String fileName = "/ressource/view/argentConfirmation.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(ArgentConfirmationView.class.getResource(fileName));

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
    public void update(Observable observable, String[] messages) {}

    /**
     * methode pour fermer la fenetre de comfirmation
     */
    public void close() {
        Stage stage = (Stage)  getViewController().getViewArgentConfimation().getScene().getWindow();
        stage.close();
    }

    @Override
    public ArgentConfirmationController getController() {
        return (ArgentConfirmationController) super.getController();
    }

    @Override
    public ArgentConfirmationViewController getViewController() {
        return (ArgentConfirmationViewController) super.getViewController();
    }

}
