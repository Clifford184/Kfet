package application.controller.gestionSoldable.type;

import application.controller.Controller;
import application.model.vendable.Categorie;
import application.model.vendable.Type;

public class CrudTypeController extends Controller {

    Type type;

    @Override
    public void initialize() {
        String[] messages = {"categorie"};
        notifyObservers(messages);
    }

    public void creationType(String pNewType, Categorie pCategorie, String pChemin){
        try {
            new Type(pNewType, pCategorie, pChemin);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modificationType(String nomProduit, Categorie categorie, String chemin) {
        type.setNom(nomProduit);
        type.setCategorie(categorie);
        type.setCheminImage(chemin);
    }

    public void setType(Type pType) {
        type = pType;
    }
}
