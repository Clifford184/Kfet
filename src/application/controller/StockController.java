package application.controller;

import application.model.vendable.Produit;
import application.model.Stock;
import application.model.vendable.Type;

import java.io.IOException;

public class StockController {

    public void createProduct(String pName, float pPurchasePrice, float pSoldPrice, Type pType, String pCheminImage){
        try {
            Produit produit = new Produit(pName,pPurchasePrice,pSoldPrice,pType, pCheminImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void incrementStock(Produit pProduit){
        Stock.getInstance().remplirStock(pProduit, 1);
    }

    public void decrementStock(Produit pProduit){
        Stock.getInstance().retirerDuStock(pProduit, 1);
    }

}
