package application.view.gestionSoldable.produit.stock;

import application.model.vendable.Type;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TypeStockElementController {

    public Label typeLabel;
    GestionStockViewController vue;
    Type type;

    /**
     * Permet d'initialiser un element dynamique d'un type choisi lors
     * de la creation d'une offre.
     * @param pVue l'objet vue associe, necessaire pour appeler ses fonctions
     * @param pType le type relie a cet element
     */
    public void initialize(Pane pPane, GestionStockViewController pVue, Type pType){
        typeLabel.setText(pType.toString());
        vue = pVue;
        type = pType;

        pPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                vue.focusType(type);
            }
        });
    }
}
