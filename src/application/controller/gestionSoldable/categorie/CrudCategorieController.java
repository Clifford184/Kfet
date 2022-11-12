package application.controller.gestionSoldable.categorie;


import application.Model.Soldable.Categorie;
import application.controller.Controller;

public class CrudCategorieController extends Controller {

    @Override
    public void initialize() {}

    public void creationCategorie(String pNewCategorie){
        new Categorie(pNewCategorie, null);
    }
}
