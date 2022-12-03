package application.view.gestionSoldable.categorie;

import application.controller.Observable;
import application.controller.gestionSoldable.categorie.GestionCategorieController;
import application.model.vendable.Categorie;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionCategorieView extends View {

    public GestionCategorieView()  {
        setController(null);
    }

    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionCategorieController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "/ressource/view/gestionCategorie.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(GestionCategorieView.class.getResource(fileName));

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
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "menu" -> {
                        // initialise le menu
                        getViewController().initialisationMenu();
                    }
                    case "categorie" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setListeCategorie(Categorie.categorieListe);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GestionCategorieController getController() {
        return (GestionCategorieController) super.getController();
    }

    @Override
    public GestionCategorieViewController getViewController() {
        return (GestionCategorieViewController) super.getViewController();
    }


}
