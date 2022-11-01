package Model.Soldable;

import Model.Stock;

import java.io.IOException;

/**
 * Describes a product that is offered for sale
 */
public class Product extends Soldable{

    Type type;
    boolean inStock;

    /**
     * Creates a new product and adds it to the stock
     * @param pName his name
     * @param pPurchasePrice his purchase price
     * @param pSoldPrice his sold price
     * @param pType his type
     * @throws IOException
     */
    public Product(String pName, float pPurchasePrice, float pSoldPrice, Type pType) throws IOException {
        super(pName, pPurchasePrice, pSoldPrice);
        type = pType;
        Stock.getInstance().addNewProduct(this);
    }

    /**
     * Allows to manage if the product will be displayed available or not
     * @param pInStock
     */
    public void setInStock(boolean pInStock){
        inStock = pInStock;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isInStock() {
        return inStock;
    }
}
