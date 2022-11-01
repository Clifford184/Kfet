package application.Model.Soldable;

import java.util.ArrayList;

/**
 * Defines how an offer could be formed
 */
public class OfferTemplate{

    ArrayList<Categorie> categorieList;
    String name;
    float sellPrice;

    ArrayList<Product> blackList;

    public static ArrayList<OfferTemplate> offerTemplateList = new ArrayList<>();

    /**
     * Create a new template
     * @param pName the name of the template
     * @param pSellPrice his price
     * @param pCategorieList
     */
    public OfferTemplate(String pName, float pSellPrice, ArrayList<Categorie> pCategorieList){
        name = pName;
        sellPrice = pSellPrice;
        categorieList = pCategorieList;
        blackList = new ArrayList<>();
    }

    /**
     * Add a product to the blacklist, it wouldn't be available for the offer
     * @param pProduct
     */
    public void addToBlackList(Product pProduct){
        blackList.add(pProduct);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setTypeList(ArrayList<Categorie> typeList) {
        this.categorieList = typeList;
    }


    public float getSellPrice() {
        return sellPrice;
    }
}
