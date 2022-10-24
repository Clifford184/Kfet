package application.view.priseCommande;

import application.controller.Observable;
import application.controller.priseCommande.PriseCommandeController;
import application.view.View;
import application.view.methodePayement.MethodePayementView;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PriseCommandeView extends View {

    public PriseCommandeView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new PriseCommandeController());
        }
        getController().initialize();
        getViewController().initializeType();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // In the case of the separator for the resources, it's the same for every OS: '/'.
        // So there is no need to use File.separator.
        String fileName = "/ressource/view/priseCommandeView.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(PriseCommandeView.class.getResource(fileName));

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

        getViewController().initialPage();

        // Get the controller of the view.
        initialize();

        // Show the view.
        stage.show();
    }

    @Override
    public void update(Observable observable, String[] messages) {}

    @Override
    public PriseCommandeController getController() {
        return (PriseCommandeController) super.getController();
    }

    @Override
    public PriseCommandeViewController getViewController() {
        return (PriseCommandeViewController) super.getViewController();
    }

    public void changerScene() throws Exception {
        MethodePayementView methodePayementView = new MethodePayementView();
        methodePayementView.start(new Stage());
    }

    public void close() {
        Stage stage = (Stage) getViewController().payementIcone.getScene().getWindow();
        stage.close();
    }
}
