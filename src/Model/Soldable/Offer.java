package Model.Soldable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represente une offre qui aura ete selectionnee lors d'une commande, a partir d'un OfferTemplate
 */
public class Offer extends Soldable{

    ArrayList<Product> productArrayList;

    public Offer(OfferTemplate pOfferTemplate, ArrayList<Product> pProducts) throws IOException {
        super(pOfferTemplate.getName(), 0, 0);

        productArrayList = pProducts;
    }
}
