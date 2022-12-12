package application.view.methodePayement;

import application.model.Commande;
import application.view.ViewController;
import application.view.compte.CompteView;
import application.view.priseCommande.PriseCommandeView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MethodePayementViewController extends ViewController {

    public Button annulerCommandeBtn;
    public Pane autreMethodePaiementPane;
    public TextField prenomClientTextField;
    @FXML
    private BorderPane viewModePayement;

    @FXML
    private Pane payementCompte;

    public void initialize(){
        payementCompte.onMouseClickedProperty().set(mouseEvent -> redirectionPayementCompte());
        autreMethodePaiementPane.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String prenomClient = prenomClientTextField.getText();
                if(prenomClient.equals(""))
                    prenomClient = "Non renseigné";
                Commande.creerCommande(getView().getController().getPanier(),prenomClient);
                PriseCommandeView priseCommandeView = new PriseCommandeView();
                getView().changerPage((Stage) getViewModePayement().getScene().getWindow(), priseCommandeView);
            }
        });
    }

    /**
     * methode de redirection vers la page de payement par compte
     */
    public void redirectionPayementCompte() {
        try {
            CompteView compteView = new CompteView();
            getView().changerPage((Stage) getViewModePayement().getScene().getWindow(), compteView);
            compteView.getController().setAchatContexte(true);
            compteView.getController().setPanier(getView().getController().getPanier());
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
