package application.view.gestionSoldable.categorie.crudCategorie;

import application.controller.Observable;
import application.controller.gestionSoldable.categorie.CrudCategorieController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrudCategorieView extends View {

    public CrudCategorieView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudCategorieController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "/ressource/view/gestionSoldable/categorie/crudCategorie.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(CrudCategorieView.class.getResource(fileName));

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
            Stage stage = (Stage) getViewController().getViewCrudCategorie().getScene().getWindow();
            view.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close() {
        Stage stage = (Stage)  getViewController().getNomCategorie().getScene().getWindow();
        stage.close();
    }

    @Override
    public CrudCategorieController getController() {
        return (CrudCategorieController) super.getController();
    }

    @Override
    public CrudCategorieViewController getViewController() {
        return (CrudCategorieViewController) super.getViewController();
    }
}
