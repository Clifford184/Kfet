package application.controller.priseCommande;

import application.model.Panier;
import application.model.Stock;
import application.model.vendable.*;
import application.controller.Controller;

import java.util.ArrayList;

public class PriseCommandeController extends Controller {

    Panier panier = new Panier();
    ArrayList<Produit> produitMenuSelectionnee = new ArrayList<>();


    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize()  {
        String[] messages = {"sliderMenu","type"};
        notifyObservers(messages);
    }

    public void ajouterAuPanier(Produit pProduit){
        panier.ajouterElement(pProduit);
        Stock.getInstance().retirerDuStock(pProduit,1);

        String[] messages = {"panier"};
        notifyObservers(messages);
    }

    public void ajouterAuPanier(TemplateOffre pTemplateOffre){
        try {
            Offre offre = new Offre(pTemplateOffre, produitMenuSelectionnee);
            panier.ajouterElement(offre);

            // On enleve du stock les produits du menu
            Stock stock = Stock.getInstance();
            for(Produit produit : offre.getProduitListe()){
                stock.retirerDuStock(produit,1);
            }

            //suppression des produits du menu selectionne mis dans le panier
            produitMenuSelectionnee.clear();

            String[] messages = {"panier","type"};
            notifyObservers(messages);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void viderPanier(){
        Stock stock = Stock.getInstance();
        for(Vendable v : panier.getSoldableList()){
            if(v instanceof Offre){
                for(Produit p : ((Offre)v).getProduitListe()){
                    stock.remplirStock(p,1);
                }
            }else{
                stock.remplirStock((Produit)v,1);
            }
        }
    }

    public void AjoutProduitMenu(Produit pProduit) {
        produitMenuSelectionnee.add(pProduit);

        String[] messages = {"menu"};
        notifyObservers(messages);
    }

    public void AnnulerMenu() {
        Stock stock = Stock.getInstance();
        for(Produit p: produitMenuSelectionnee){
            stock.remplirStock(p,1);
        }
        produitMenuSelectionnee.clear();
    }

    public Panier getPanier() {
        return panier;
    }
}
