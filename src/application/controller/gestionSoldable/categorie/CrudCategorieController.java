package application.controller.gestionSoldable.categorie;

import application.controller.Controller;
import application.model.vendable.Categorie;
import application.model.vendable.Type;

import java.util.ArrayList;

public class CrudCategorieController extends Controller {

    Categorie categorie;

    @Override
    public void initialize() {}

    public void creationCategorie(String pNewCategorie, ArrayList<Type> pTypeListe){
        new Categorie(pNewCategorie, pTypeListe);
    }

    public void modificationCategorie(String pNom, ArrayList<Type> pTypeListe) {
        categorie.setNom(pNom);
        categorie.setTypeListe(pTypeListe);
    }

    public void setCategorie(Categorie pCategorie){
        categorie = pCategorie;
    }
}
