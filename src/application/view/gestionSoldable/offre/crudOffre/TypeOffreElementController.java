package application.view.gestionSoldable.offre.crudOffre;

import application.model.vendable.Type;
import application.view.ViewController;
import javafx.scene.control.Label;

public class TypeOffreElementController extends ViewController {

    public Label nomType;
    CrudOffreViewController vue;
    Type type;

    /**
     * Permet d'initialiser un element dynamique d'un type choisi lors
     * de la creation d'une offre.
     * @param pVue l'objet vue associe, necessaire pour appeler ses fonctions
     * @param pType le type relie a cet element
     */
    public void initialize(CrudOffreViewController pVue, Type pType){
        type = pType;
        nomType.setText(pType.toString());
        vue = pVue;

    }


}
