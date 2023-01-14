package application.controller.gestionSoldable.type;

import application.controller.Controller;
import application.model.vendable.Type;

public class CrudTypeController extends Controller {

    Type type;

    @Override
    public void initialize() {
        String[] messages = {"categorie"};
        notifyObservers(messages);
    }

    public void creationType(String pNewType, String pChemin) {
        new Type(pNewType, pChemin);
    }

    public void modificationType(String nomProduit, String chemin) {
        type.setNom(nomProduit);
        type.setCheminImage(chemin);
    }

    public void setType(Type pType) {
        type = pType;
    }
}
