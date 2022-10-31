package application.view.methodePayement;

import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class MethodePayementViewController extends ViewController {

    @FXML
    Pane payementCompte;

    public void redirectionPayementCompte() throws Exception {
        getView().changerScene();
    }

    public MethodePayementViewController(){}

    public MethodePayementView getView(){
        return (MethodePayementView) super.getView();
    }
}
