package application.view.compte;

import application.controller.Observable;
import application.controller.compte.CompteController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CompteView extends View {

    public CompteView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CompteController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "/ressource/view/compteView.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(CompteView.class.getResource(fileName));

        // Creation of the scene.
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("gestionnaire cafétéria");
        stage.setResizable(true);
        stage.setMinWidth(880);
        stage.setMinHeight(580);
        stage.setScene(scene);

        // Get the controller which controls the elements of the view.
        setViewController(fxmlLoader.getController());
        getViewController().setView(this);

        // Get the controller of the view.
        initialize();

        // Show the view.
        stage.show();
    }

    /**
     * methode pour changer de page
     * @param pPageDestination vue de destination
     */
    public void changerPage(View pPageDestination) {
        try {
            Stage stage = new Stage();
            pPageDestination.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable observable, String[] messages) {}

    @Override
    public CompteController getController() {
        return (CompteController) super.getController();
    }

    @Override
    public CompteViewController getViewController() {
        return (CompteViewController) super.getViewController();
    }
}
