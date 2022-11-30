package application.view.commande;

import application.model.Commande;
import application.model.vendable.Categorie;
import application.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class GestionCommandeViewController extends ViewController {

    public VBox listeCommandeVBox;
    public Button menuButton;
    public Button consulterHistoriqueButton;

    public Label clientLabel;
    public Label heureCommandeLabel;
    public Label montantTotalLabel;
    public ComboBox etatActuelCombo;
    public VBox listeProduitVBox;
    public Button validerModifButton;

    @FXML
    private AnchorPane viewGestionCommande;

    public void initialize(){

        for(Commande commande : Commande.getCommandeListe()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/gestionCommandeElement.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            GestionCommandeElementController controller = loader.getController();
            controller.initialize(commande);
            listeCommandeVBox.getChildren().add(pane);
        }

        //relier le menuButton

    }

    /**
     * Rempli le panneau de droite avec les informations de la commande
     * qui est focus.
     * @param pCommande la commande dont il faut afficher les details
     */
    public void focusCommande(Commande pCommande){
        clientLabel.setText(pCommande.getClient().getPrenom()+pCommande.getClient().getNom());
        heureCommandeLabel.setText(pCommande.getDate().toString());
        montantTotalLabel.setText(pCommande.getCart().valeurPanier()+"e");

        String[] listeEnum = Arrays.stream(Commande.State.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);

        ObservableList<String> list = FXCollections.observableArrayList(listeEnum);
        etatActuelCombo.setItems(list);
        etatActuelCombo.getSelectionModel().select(0);
    }

    /**
     * Appeler pour valider la mise a jour des données modifiees dans
     * le panneau de droite, concernant l'avance des produits et de la commande
     */
    public void validerModif(){

    }

    /**
     * Ouvre une nouvelle fenetre (?) permettant de consulter les commandes passees
     */
    public void consulterHistoirique(){

    }

    public GestionCommandeView getView() {
        return (GestionCommandeView) super.getView();
    }

    public AnchorPane getViewGestionCommande() {
        return viewGestionCommande;
    }
}
