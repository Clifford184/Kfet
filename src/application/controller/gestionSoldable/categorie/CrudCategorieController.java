package application.controller.gestionSoldable.categorie;

import application.controller.Controller;
import application.model.vendable.Categorie;

public class CrudCategorieController extends Controller {

    @Override
    public void initialize() {}

    public void creationCategorie(String pNewCategorie){
        new Categorie(pNewCategorie);
    }
}
