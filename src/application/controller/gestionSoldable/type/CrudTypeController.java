package application.controller.gestionSoldable.type;

import application.controller.Controller;
import application.model.vendable.Type;
import application.outils.ImageManager;

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

    public void modificationType(String pNom, String pChemin) {
        type.setNom(pNom);
        type.setCheminImage(ImageManager.genererNouvelleImage(pChemin, pNom));
    }

    public void setType(Type pType) {
        type = pType;
    }
}
