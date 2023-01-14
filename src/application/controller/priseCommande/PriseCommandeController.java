package application.controller.priseCommande;

import application.model.Panier;
import application.model.Stock;
import application.model.vendable.*;
import application.controller.Controller;

import java.util.ArrayList;

public class PriseCommandeController extends Controller {

    Panier panier;
    ArrayList<Produit> produitMenuSelectionnee = new ArrayList<>();

    Type typeSelectionne;

    public PriseCommandeController(){
        if(Panier.panierCourant==null)
            panier = new Panier();
        else{
            if(Panier.panierCourant.getTerminePanier())
                panier = new Panier();
            else
                panier = Panier.panierCourant;
        }
    }

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize()  {
        String[] messages = {"sliderMenu","type","panier"};
        notifyObservers(messages);
    }

    public void focusType(Type pType){
        typeSelectionne = pType;
    }

    public void ajouterAuPanier(Produit pProduit){
        panier.ajouterElement(pProduit);
        Stock.getInstance().retirerDuStock(pProduit,1);

        String[] messages = {"panier"};
        notifyObservers(messages);
    }

    public void ajouterAuPanier(TemplateOffre pTemplateOffre){
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

    public void viderPanier(){
        panier.viderPanier();
        String[] messages = {"panier","type"};
        notifyObservers(messages);
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

    public Type getType() {
        return typeSelectionne;
    }
}
