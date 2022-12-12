package application.view.outils;

import application.view.ViewController;
import javafx.scene.layout.Pane;

public class ControllerEtPane {

    private ViewController controller;
    private Pane pane;

    public ControllerEtPane(ViewController pController, Pane pPane){
        controller = pController;
        pane = pPane;
    }


    public ViewController getController() {
        return controller;
    }

    public void setController(ViewController controller) {
        this.controller = controller;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }
}
