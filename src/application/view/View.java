package application.view;

import application.controller.Controller;
import javafx.application.Application;

/**
 * View of a HIM.
 */
public abstract class View extends Application implements Observer {
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
}
