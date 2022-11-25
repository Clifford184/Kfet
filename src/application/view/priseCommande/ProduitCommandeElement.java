package application.view.priseCommande;

import application.model.Stock;
import application.model.vendable.Produit;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ProduitCommandeElement {
    public ImageView imageView;
    public Label nomProduitLabel;
    public Label stockLabel;
    public Label prixLabel;

    Produit produit;

    public void initialize(Produit pProduit) {
        imageView.setImage(new Image(new File(pProduit.getCheminImage()).toURI().toString()));
        nomProduitLabel.setText(pProduit.getNom());
        prixLabel.setText(pProduit.getPrixVente()+"e");
        produit = pProduit;
        stockLabel.setText("("+ Stock.getInstance().combienEnStock(pProduit)+")");
    }

    /**
     * Affichage du prix normal du produit
     */
    public void setPrixNormal(){
        prixLabel.setText(produit.getPrixVente()+"e");
    }

    /**
     * Affichage du prix membre du produit
     */
    public void setPrixMembre(){
        prixLabel.setText(produit.getPrixVenteMembre()+"e");
    }
}
