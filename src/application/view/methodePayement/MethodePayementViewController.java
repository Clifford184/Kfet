package application.view.methodePayement;

import application.view.ViewController;
import application.view.compte.CompteView;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MethodePayementViewController extends ViewController {

    @FXML
    private BorderPane viewModePayement;

    @FXML
    private Pane payementCompte;

    /**
     * methode de redirection vers la page de payement par compte
     */
    public void redirectionPayementCompte() {
        try {
            CompteView compteView = new CompteView();
            getView().changerPage(compteView);
            compteView.getController().setAchatContexte(true);
            compteView.getController().setCommande(getView().getController().getCommande());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * constucteur par défaut
     */
    public MethodePayementViewController(){}

    public MethodePayementView getView(){
        return (MethodePayementView) super.getView();
    }

    /**
     * getter de l'élément principal de la page (BorderPane)
     * @return BorderPane de la page
     */
    public BorderPane getViewModePayement() {
        return viewModePayement;
    }
}
