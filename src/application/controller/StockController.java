package application.controller;

import application.Model.Soldable.Produit;
import application.Model.Stock;
import application.Model.Soldable.Type;

import java.io.IOException;

public class StockController {

    public void createProduct(String pName, float pPurchasePrice, float pSoldPrice, Type pType){
        try {
            Produit produit = new Produit(pName,pPurchasePrice,pSoldPrice,pType);
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
