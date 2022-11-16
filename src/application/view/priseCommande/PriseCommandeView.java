package application.view.priseCommande;

import application.controller.Observable;
import application.controller.priseCommande.PriseCommandeController;
import application.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PriseCommandeView extends View {

    /**
     * constructeur par défaut
     */
    public PriseCommandeView()  {
        setController(null);
    }

    /**
     * methode d'initialisation du controller de la vue
     */
    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new PriseCommandeController());
        }
        getController().initialize();
        getViewController().initialisationMenu();
    }

    /**
     * methode d'affichage de la vue
     */
    @Override
    public void show() {
        View.launch();
    }

    /**
     * methode d'initialisation des paramètres de la vue puis la démarre
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
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

        // Get the controller of the view.
        initialize();

        // Show the view.
        stage.show();
    }

    /**
     * methode de mise à jour des différents éléments de la vue
     * @param observable The observable that the observer observes.
     * @param messages Messages sent by the observer to inform the observer of what to do.
     */
    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "type" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().InitialisationType();
                    }
                    case "panier" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().setArticlePanier(getController().getPanier());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getter du contoller de la vue
     * @return PriseCommandeController le controller de la vue
     */
    @Override
    public PriseCommandeController getController() {
        return (PriseCommandeController) super.getController();
    }

    /**
     * getter du viewContoller de la vue
     * @return PriseCommandeViewController le viewContoller de la vue
     */
    @Override
    public PriseCommandeViewController getViewController() {
        return (PriseCommandeViewController) super.getViewController();
    }

    /**
     * methode pour changer de page
     * @param pPageDestination vue de destination
     */
    public void changerPage(View pPageDestination) {
        try {
            Stage stage = (Stage) getViewController().getViewPriseCommande().getScene().getWindow();
            pPageDestination.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
