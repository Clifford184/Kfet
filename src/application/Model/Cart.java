package Model;

import Model.Soldable.Soldable;

import java.util.ArrayList;

/**
 * Cart of the current order
 */
public class Cart {

    ArrayList<Soldable> soldableList;

    /**
     * Create a new empty cart
     */
    public Cart(){

        soldableList = new ArrayList<>();

    }

    /**
     * Add a soldable to the cart
     * @param pSoldable
     */
    public void addSoldable(Soldable pSoldable){
        soldableList.add(pSoldable);
    }

    /**
     * Remove a soldable from the cart
     * @param pSoldable
     */
    public void removeSoldable(Soldable pSoldable){
        soldableList.remove(pSoldable);
    }

    /**
     * Calculate the value of all the soldable in the cart
     * @return
     */
    public float cartValue(){

        float value=0;
        for(Soldable s : soldableList)
            value+=s.getSellPrice();

        return value;
    }

    public ArrayList<Soldable> getSoldableList(){
        return soldableList;
    }

}
