package application.view.gestionSoldable.type;

import application.controller.Observable;
import application.controller.gestionSoldable.type.GestionTypeController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionTypeView extends View {

    public GestionTypeView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionTypeController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "/ressource/view/gestionType.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(GestionTypeView.class.getResource(fileName));

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


    @Override
    public void update(Observable observable, String[] messages) {}

    public void changerScene(View view, boolean nouvelleFenetre) throws Exception {
        Stage stage;
        if(nouvelleFenetre){
            stage = new Stage();
        }
        else{
            stage = (Stage) getViewController().getViewGestionType().getScene().getWindow();
        }
        view.start(stage);
    }

    @Override
    public GestionTypeController getController() {
        return (GestionTypeController) super.getController();
    }

    @Override
    public GestionTypeViewController getViewController() {
        return (GestionTypeViewController) super.getViewController();
    }


}
