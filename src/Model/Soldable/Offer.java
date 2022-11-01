package Model.Soldable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Describes an offer which has been chosen during an order.
 * The list of products has been chosen following the associated offerTemplate
 */
public class Offer extends Soldable{

    ArrayList<Product> productArrayList;

    public Offer(OfferTemplate pOfferTemplate, ArrayList<Product> pProducts) throws IOException {
        super(pOfferTemplate.getName(), 0, pOfferTemplate.getSellPrice());

        productArrayList = pProducts;
    }
}
