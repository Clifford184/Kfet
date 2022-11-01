package application.view.priseCommande;

import application.Model.Cart;
import application.Model.Soldable.Product;
import application.Model.Soldable.Soldable;
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
        getViewController().initialPage();
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
                    case "cart" -> {
                        // Update du menu en fonctions des soldable existant
                        Cart cart  = getController().getCart();
                        getViewController().initializeType(cart);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PriseCommandeController getController() {
        return (PriseCommandeController) super.getController();
    }

    @Override
    public PriseCommandeViewController getViewController() {
        return (PriseCommandeViewController) super.getViewController();
    }

    public void changerScene(View view) throws Exception {
        Stage stage = (Stage) getViewController().payementIcone.getScene().getWindow();
        view.start(stage);
    }
}
