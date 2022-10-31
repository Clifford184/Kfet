package application.Model.Soldable;

import java.io.IOException;
import java.util.ArrayList;

public class OfferTemplate{

    ArrayList<Categorie> categorieList;
    String name;
    float sellPrice;

    public static ArrayList<OfferTemplate> offerTemplateList = new ArrayList<>();

    public OfferTemplate(String pName, float pSellPrice, ArrayList<Categorie> pCategorieList) throws IOException {
        sellPrice = pSellPrice;
        categorieList = pCategorieList;
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


}
