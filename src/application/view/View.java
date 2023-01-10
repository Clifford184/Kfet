package application.view;

import application.controller.Controller;
import application.model.Systeme;
import application.view.utile.AlertView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * View of a HIM.
 */
public abstract class View extends Application implements Observer {

    protected String cheminVue;
    protected String nomFenetre;

    /**
     * Controller which controls the elements of the view.
     */
    private ViewController viewController;

    /**
     * Controller of the view.
     */
    private Controller controller;

    /**
     * Initialize the view.
     */
    public abstract void initialize();


    /**
     * Show the view.
     */
    public abstract void show();

    /**
     * Get the controller of the view.
     * @return The controller of the view.
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Get the controller which controls the elements of the view.
     * @return The controller which controls the elements of the view.
     */
    public ViewController getViewController() {
        return viewController;
    }

    /**
     * Set the controller of the view.
     * @param controller The new controller of the view.
     */
    public void setController(Controller controller) {
        this.controller = controller;

        if (controller != null) {
            // The view observes the controller.
            this.controller.register(this);
        }
    }

    /**
     * Set the controller which controls the elements of the view.
     * @param viewController The new controller which controls the elements of the view.
     */
    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    /**
     * Appele automatiquement avant la fermeture complete de l'application
     */
    public void stop(){
        Systeme.saveAll();
    }

    /**
     * methode pour changer de page
     * @param pPageDestination vue de destination
     */
    public void changerPage(Stage pStage, View pPageDestination) {
        try {
            Stage stage = pStage;
            pPageDestination.start(stage);
        }
        catch (Exception e){
            AlertView alertView = new AlertView();
            genererNouvellePage(alertView);
            alertView.getController().setMessage("Echec du changement de page");
        }
    }

    public void genererNouvellePage(View pPageDestination){
        try {
            Stage stage = new Stage();
            pPageDestination.start(stage);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
