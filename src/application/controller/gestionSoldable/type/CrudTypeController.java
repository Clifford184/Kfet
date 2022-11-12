package application.controller.gestionSoldable.type;

import application.controller.Controller;
import application.model.vendable.Categorie;
import application.model.vendable.Type;

public class CrudTypeController extends Controller {

    @Override
    public void initialize() {
        String[] messages = {"categorie"};
        notifyObservers(messages);
    }

    public void creationType(String pNewType, Categorie pCategorie){
        new Type(pNewType, pCategorie);
    }
}
