package Model.Soldable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Describes a generic offered product
 */
public abstract class Soldable {

    String name;
    float purchasePrice;
    float sellPrice;
    BufferedImage image;

    /**
     * Create a new offered item
     * @param pName his name
     * @param pPurchasePrice his purchase price
     * @param pSoldPrice his sold price
     * @throws IOException if there is a problem during the loading of the image
     */
    public Soldable(String pName, float pPurchasePrice, float pSoldPrice) throws IOException {

        name = pName;
        sellPrice = pSoldPrice;
        purchasePrice = 0;

        if(this instanceof Offer){
            for(Product p : ((Offer) this).productArrayList){
                pPurchasePrice += p.purchasePrice;
            }
        }else{
            purchasePrice = pPurchasePrice;
        }

        //A revoir
        image = ImageIO.read(new File("image/soldable"+name+".png"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}