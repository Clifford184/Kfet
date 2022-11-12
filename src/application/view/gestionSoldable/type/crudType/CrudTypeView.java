package application.view.gestionSoldable.type.crudType;

import application.Model.Soldable.Categorie;
import application.controller.Observable;
import application.controller.gestionSoldable.type.CrudTypeController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CrudTypeView extends View {

    public CrudTypeView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new CrudTypeController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "/ressource/view/crudType.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(CrudTypeView.class.getResource(fileName));

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

    public void changerScene(View view) {
        try {
            Stage stage = (Stage) getViewController().getViewCrudType().getScene().getWindow();
            view.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "categorie" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setListeCategorie(Categorie.getCategorieArrayList());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        Stage stage = (Stage)  getViewController().getNomType().getScene().getWindow();
        stage.close();
    }

    @Override
    public CrudTypeController getController() {
        return (CrudTypeController) super.getController();
    }

    @Override
    public CrudTypeViewController getViewController() {
        return (CrudTypeViewController) super.getViewController();
    }
}
