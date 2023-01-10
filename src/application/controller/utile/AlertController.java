package application.controller.utile;

import application.controller.Controller;

public class AlertController extends Controller {

    String message = "";

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"initialisationView"};
        notifyObservers(messages);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

        String[] messages = {"alertMessage"};
        notifyObservers(messages);
    }
}