package application.view.gestionSoldable.offre.crudOffre;

import application.model.vendable.Produit;
import application.model.vendable.Type;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerProduitListeElement {
    public Label nomProduit;
    public CheckBox checkboxProduit;
    Produit produit;
    CrudOffreViewController vue;

    /**
     * Permet d'initialiser un element dynamique d'une produit choisi lors
     * de la creation d'une offre.
     * @param pBlacklist si le produit est deja present dans la blacklist (si il doit etre decoche)
     * @param pVue l'objet vue associe, necessaire pour appeler ses fonctions
     * @param pProduit le type relie a cet element
     */
    public void initialize(boolean pBlacklist, CrudOffreViewController pVue, Produit pProduit){
        produit = pProduit;
        nomProduit.setText(pProduit.toString());
        vue = pVue;

        checkboxProduit.setSelected(pBlacklist);
        checkboxProduit.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue)
                    vue.retirerBlacklist(pProduit);
                else
                    vue.ajouterBlacklist(pProduit);
            }
        });
    }
}
