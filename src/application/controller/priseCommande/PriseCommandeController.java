package application.controller.priseCommande;

import application.model.Panier;
import application.model.vendable.*;
import application.controller.Controller;

import java.util.ArrayList;

public class PriseCommandeController extends Controller {

    Panier panier = new Panier();

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize()  {
        Categorie platChaudCat = new Categorie("Plat Chaud");
        Categorie boissonCat = new Categorie("Boisson");
        ArrayList<Categorie> menuCat = new ArrayList<>();
        menuCat.add(platChaudCat);
        menuCat.add(boissonCat);
        try{
            Type.getTypeListe().clear();
            Type pizzaType =  new Type("Pizza",platChaudCat,null);
            new Produit("pizza chèvre",2f,2.5f,pizzaType,null);
            new Produit("pizza bolognaise",2f,2.5f,pizzaType,null);
            new Produit("Pizza kebab",2f,2.5f,pizzaType,null);
            new Produit("Pizza royal",2f,2.5f,pizzaType,null);
            new Produit("Pizza 3 fromages",2f,2.5f,pizzaType,null);
            new Produit("Pizza chorizo",2f,2.5f,pizzaType,null);

            Type picardType =  new Type("Picard",platChaudCat,null);
            new Produit("tagiatelle carbonara",2f,2.5f,picardType,null);

            Type boissonType = new Type("boisson",boissonCat, null);
            new Produit("orangina",2f,2.5f,boissonType,null);


//            Type menuType = new Type("menu",null, null);
//            TemplateOffre menuTemplate =  new TemplateOffre("menu midi", 3.1f,menuCat,null,null);
//            new Offre(menuTemplate,);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        String[] messages = {"type"};
        notifyObservers(messages);
    }

    public ArrayList<Produit> getProduitType(Type pType){
        int indexType = Type.getTypeListe().indexOf(pType);
        return Type.getTypeListe().get(indexType).getProduitListe();
    }

    public void ajouterAuPanier(Produit pProduit){
        panier.ajouterElement(pProduit);

        String[] messages = {"panier"};
        notifyObservers(messages);
    }

    public Panier getPanier() {
        return panier;
    }
}
