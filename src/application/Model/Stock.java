package application.Model;

import application.Model.Soldable.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock {

    HashMap<Product, Integer> stock;

    static Stock singleton;

    private void Stock(){

    }

    public void addNewProduct(Product pProduct){
        if(stock.get(pProduct)!=null)
            return; //Gerer l'erreur
        stock.put(pProduct,0);
    }

    public void deleteProduct(Product pProduct){
        if(stock.get(pProduct)==null)
            return; //Gerer l'erreur
        stock.put(pProduct,0);
    }

    public void removeFromStock(ArrayList<Product> pProductsList){
        for(Product p : pProductsList){
            Integer number = stock.get(p);
            if(number == 0){
                //ERREURUURUURRUR
            }
            number--;
            stock.put(p,number);
        }
    }

    public void removeFromStock(Product pProduct, int pNumber){
        Integer number = stock.get(pProduct);
        number -= pNumber;
        stock.put(pProduct, pNumber);
    }

    public void addToStock(Product pProduct, int pNumber){
        Integer number = stock.get(pProduct);
        number += pNumber;
        stock.put(pProduct, pNumber);
    }

    public static Stock getInstance(){
        return singleton;
    }

}
