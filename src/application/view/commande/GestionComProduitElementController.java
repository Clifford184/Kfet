package application.view.commande;

import application.controller.commande.GestionCommandeController;
import application.model.vendable.ProduitCommande;
import application.view.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.Arrays;

public class GestionComProduitElementController extends ViewController {

    public Label nomProduitLabel;
    public ComboBox<String> etatProduitCombo;

    GestionCommandeController controllerPrincipal;

    public void initialize(ProduitCommande pProduit, GestionCommandeController pController){

        controllerPrincipal = pController;

        nomProduitLabel.setText(pProduit.getProduit().getNom());

        String[] listeEnum = Arrays.stream(ProduitCommande.Etat.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
        ObservableList<String> list = FXCollections.observableArrayList(listeEnum);
        etatProduitCombo.setItems(list);
        etatProduitCombo.getSelectionModel().select(pProduit.getEtat().ordinal());
        etatProduitCombo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                controllerPrincipal.changerEtatProduit(pProduit, ProduitCommande.Etat.valueOf(newValue));
                controllerPrincipal.majCommande();
            }
        });

    }

}
