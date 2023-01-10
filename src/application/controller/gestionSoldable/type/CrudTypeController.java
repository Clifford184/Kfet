package application.controller.gestionSoldable.type;

import application.controller.Controller;
import application.model.vendable.Categorie;
import application.model.vendable.Type;
import application.view.utile.AlertView;

public class CrudTypeController extends Controller {

    Type type;

    @Override
    public void initialize() {
        String[] messages = {"categorie"};
        notifyObservers(messages);
    }

    public void creationType(String pNewType, String pChemin){
        try {
            new Type(pNewType, pChemin);
        }
        catch (Exception e){
            AlertView alertView = new AlertView();
            alertView.getController().setMessage("Echec de la création de "+type.getNom());
        }
    }

    public void modificationType(String nomProduit,String chemin) {
        type.setNom(nomProduit);
        type.setCheminImage(chemin);
    }

    public void setType(Type pType) {
        type = pType;
    }
}
