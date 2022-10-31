package application.controller;

import application.Model.Soldable.Product;
import application.Model.Stock;
import application.Model.Soldable.Type;

import java.io.IOException;

public class StockController {

    public void createProduct(String pName, float pPurchasePrice, float pSoldPrice, Type pType){
        try {
            Product product = new Product(pName,pPurchasePrice,pSoldPrice,pType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void incrementStock(Product pProduct){
        Stock.getInstance().addToStock(pProduct, 1);
    }

    public void decrementStock(Product pProduct){
        Stock.getInstance().removeFromStock(pProduct, 1);
    }

}
