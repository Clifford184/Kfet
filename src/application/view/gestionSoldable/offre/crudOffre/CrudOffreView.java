package application.view.gestionSoldable.offre.crudOffre;

import application.controller.Observable;
import application.controller.gestionSoldable.offre.CrudOffreController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrudOffreView extends View {

    public CrudOffreView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudOffreController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "/ressource/view/crudOffre.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(CrudOffreView.class.getResource(fileName));

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

    public void changerScene() throws Exception {

    }

    @Override
    public void update(Observable observable, String[] messages) {}

    public void changerScene(View view)  {
        try {
            Stage stage = (Stage) getViewController().getViewCrudOffre().getScene().getWindow();
            view.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public CrudOffreController getController() {
        return (CrudOffreController) super.getController();
    }

    @Override
    public CrudOffreViewController getViewController() {
        return (CrudOffreViewController) super.getViewController();
    }
}
