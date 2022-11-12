package application.controller.gestionSoldable.type;


import application.Model.Soldable.Categorie;
import application.Model.Soldable.Type;
import application.controller.Controller;

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
