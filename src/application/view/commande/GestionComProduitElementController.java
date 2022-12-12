package application.view.commande;

import application.model.Commande;
import application.model.vendable.Produit;
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
    public ComboBox etatProduitCombo;

    public void initialize(ProduitCommande pProduit, Commande pCommande){

        nomProduitLabel.setText(pProduit.getProduit().getNom());

        String[] listeEnum = Arrays.stream(ProduitCommande.Etat.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
        ObservableList<String> list = FXCollections.observableArrayList(listeEnum);
        etatProduitCombo.setItems(list);
        etatProduitCombo.getSelectionModel().select(pProduit.getEtat());
        etatProduitCombo.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                pCommande.maj();
            }
        });

    }

}
