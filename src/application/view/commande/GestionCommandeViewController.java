package application.view.commande;

import application.model.Commande;
import application.model.vendable.ProduitCommande;
import application.view.outils.ControllerEtPane;
import application.view.outils.SceneLoader;
import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class GestionCommandeViewController extends ViewController {

    public VBox listeCommandeVBox;
    public Button menuButton;
    public Button consulterHistoriqueButton;

    public Label clientLabel;
    public Label heureCommandeLabel;
    public Label montantTotalLabel;
    public VBox listeProduitVBox;
    public Button validerModifButton;
    public Label etatCommandeLabel;

    @FXML
    private AnchorPane viewGestionCommande;

    public void initialize(){

        for(Commande commande : Commande.getCommandeListe()){

            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/commande/gestionCommandeElement.fxml");
            Pane pane = controllerEtPane.getPane();

            //faire un tri pour afficher en premier les commandes commencée, en cours, et terminée
            GestionCommandeElementController controller = (GestionCommandeElementController) controllerEtPane.getController();
            controller.initialize(commande);
            pane.setOnMouseClicked(mouseEvent -> focusCommande(commande));

            listeCommandeVBox.getChildren().add(pane);
        }

    }

    public void recharger() {
        listeCommandeVBox.getChildren().clear();
        initialize();
    }

    /**
     * Remplie le panneau de droite avec les informations de la commande
     * qui est focus.
     * @param pCommande la commande dont il faut afficher les details
     */
    public void focusCommande(Commande pCommande){

        getView().getController().focusCommande(pCommande);

        clientLabel.setText(pCommande.getIdentiteClient());
        heureCommandeLabel.setText(pCommande.getDate().getHour()+":"+pCommande.getDate().getMinute());
        montantTotalLabel.setText(pCommande.getPanier().valeurPanier()+"e");
        etatCommandeLabel.setText(pCommande.getEtatActuel().name());

        for(ProduitCommande p : pCommande.getProduitCommandeListe()){
            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/commande/gestionCommandeProduitElement.fxml");
            Pane pane = controllerEtPane.getPane();

            //faire un tri pour afficher en premier les commandes commencée, en cours, et terminée
            GestionComProduitElementController controller = (GestionComProduitElementController) controllerEtPane.getController();
            controller.initialize(p, getView().getController());

            listeProduitVBox.getChildren().add(pane);
        }

    }


    /**
     * Ouvre une nouvelle fenetre (?) permettant de consulter les commandes passees
     */
    public void consulterHistorique(){

    }

    public GestionCommandeView getView() {
        return (GestionCommandeView) super.getView();
    }

    public AnchorPane getViewGestionCommande() {
        return viewGestionCommande;
    }
}
