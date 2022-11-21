package application.view.gestionSoldable.offre.crudOffre;

import application.model.vendable.Categorie;
import application.model.vendable.Type;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerTypeListeElement {

    public Label nomType;
    CrudOffreViewController vue;
    Type type;

    /**
     * Permet d'initialiser un element dynamique d'un type choisi lors
     * de la creation d'une offre.
     * @param pVue l'objet vue associe, necessaire pour appeler ses fonctions
     * @param pType le type relie a cet element
     */
    public void initialize(Pane pPane, CrudOffreViewController pVue, Type pType){
        type = pType;
        nomType.setText(pType.toString());
        vue = pVue;

        pPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                vue.focusType(type);
            }
        });
    }


}
