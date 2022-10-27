package Model.Soldable;

import java.io.IOException;

public class Product extends Soldable{

    Type type;
    boolean inStock;

    public Product(String pName, float pPurchasePrice, float pSoldPrice, Type pType) throws IOException {
        super(pName, pPurchasePrice, pSoldPrice);
        type = pType;
    }

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
