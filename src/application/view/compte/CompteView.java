package application.view.compte;

import application.Model.Client.Client;
import application.controller.Observable;
import application.controller.compte.CompteController;
import application.controller.methodePayement.MethodePayementController;
import application.view.View;
import application.view.compte.argentConfirmation.ArgentConfirmationView;
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

    public void changerScene(Client cl, double somme, boolean ajouterArgent) throws Exception {
        Stage stage = new Stage();

        ArgentConfirmationView argentConfirmationView = new ArgentConfirmationView();
        argentConfirmationView.start(stage);
        argentConfirmationView.getViewController().initialise(cl,somme,ajouterArgent);
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
