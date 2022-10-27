package Model;

import Model.Soldable.Offer;
import Model.Soldable.OfferTemplate;
import Model.Soldable.Product;
import Model.Soldable.Soldable;

import java.io.IOException;
import java.util.ArrayList;

public class Cart {

    ArrayList<Soldable> productList;

    public Cart(){

        productList = new ArrayList<>();

    }

    public void addSoldable(Soldable pSoldable){
        productList.add(pSoldable);
        searchForOffer();
    }

    public void removeSoldable(Soldable pSoldable){
        productList.remove(pSoldable);
    }

    public void replaceForOffer(ArrayList<Product> pToReplace, OfferTemplate pOfferTemplate) throws IOException {

        Offer offer = new Offer(pOfferTemplate,pToReplace);
        productList.removeAll(pToReplace);
        productList.add(offer);

    }

    public void searchForOffer(){

        //Faire un algo pour déterminer les matchs qui seront a faire
        //MAtch menu vers menu+, ou juste produits vers menu

        //Priorite pour la formation d'un nouveau menu
        //Si non, on regarde si on peut faire un menu+
        //mais dans le cas d'un refus pour x raison, il faudrait que l'interface ne soit pas envahissante ou bloquante.

        Soldable lastAdded = productList.get(productList.size()-1);

        if(lastAdded instanceof Offer){
            //On regarde si il n'y a pas un produit seul pouvant faire une offre+



        }else if(lastAdded instanceof Product){
            //On regarde si il n'y a pas un ensemble de produit ou une offre pour faire une offre+

        }

    }

    public float cartValue(){

        float value=0;
        for(Soldable s : productList)
            value+=s.getSellPrice();

        return value;
    }

    public ArrayList<Soldable> getProductList(){
        return productList;
    }

}
