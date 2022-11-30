package application.view.gestionSoldable.produit.stock;

import application.model.vendable.Type;
import javafx.scene.control.Label;

public class TypeStockElementController {

    Label typeLabel;
    Type type;

    /**
     * Permet d'initialiser un element dynamique d'un type choisi lors
     * de la creation d'une offre.
     * @param pType le type relie a cet element
     */
    public void initialize(Type pType){
        typeLabel.setText(pType.toString());
        type = pType;

    }
}
