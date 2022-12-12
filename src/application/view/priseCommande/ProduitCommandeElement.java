package application.view.priseCommande;

import application.model.Stock;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.model.vendable.Type;
import application.view.ViewController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ProduitCommandeElement extends ViewController {
    public ImageView imageView;
    public Label nomProduitLabel;
    public Label stockLabel;
    public Label prixLabel;

    Produit produit;
    Type type;

    /**
     * Initialisation d'une case selectionnable lors
     * de la prise de commande, representant un produit
     * @param pProduit le produit lie
     */
    public void initialize(Produit pProduit) {
        imageView.setImage(new Image(new File(pProduit.getCheminImage()).toURI().toString()));
        nomProduitLabel.setText(pProduit.getNom());
        prixLabel.setText(pProduit.getPrixVente()+"e");
        stockLabel.setText("("+ Stock.getInstance().combienEnStock(pProduit)+")");
    }

    /**
     * Initialisation d'une case selectionnable lors
     * de la prise de commande, representant un type
     * @param pType le type lie
     */
    public void initialize(Type pType) {
        imageView.setImage(new Image(new File(pType.getCheminImage()).toURI().toString()));
        nomProduitLabel.setText(pType.getNom());
        prixLabel.setText("");
        stockLabel.setText("");
    }

    public void initialize(TemplateOffre pTemplateOffre){
        imageView.setImage(new Image(new File(pTemplateOffre.getCheminImage()).toURI().toString()));
        nomProduitLabel.setText(pTemplateOffre.getNom());
        prixLabel.setText("");
        stockLabel.setText("");
    }

    /**
     * Initialisation d'une case selectionnable lors
     * de la prise de commande, representant le cas special des offres
     */
    public void initializeOffre(){
        imageView.setImage(null);
        nomProduitLabel.setText("Offre");
        prixLabel.setText("");
        stockLabel.setText("");
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
