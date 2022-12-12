package application.model;

import application.model.client.Client;
import application.model.vendable.Offre;
import application.model.vendable.Produit;
import application.model.vendable.ProduitCommande;
import application.model.vendable.Vendable;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Decrit une commande qui a ete passee sur l'application
 */
public class Commande implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    LocalDateTime date;
    Client client;
    Panier panier;  //Utiliser pour les fonctionnalitees propres au panier
    ArrayList<ProduitCommande> produitCommandeListe = new ArrayList<>(); //Utiliser pour gerer l'avancement
    //de chaque article pendant la preparation de la commande.

    //Si la commande n'est pas relie a un client ayant un compte, on le designe juste par son prenom
    String prenomClient;

    Etat etatActuel;

    public enum Etat {
        COMMENCEE,
        EN_COURS,
        TERMINEE
    }

    static ArrayList<Commande> commandeListe = new ArrayList<>();

    /**
     * Cree une nouvelle commande
     * @param pPanier l'objet panier de la commande
     */
    public static Commande creerCommande(Panier pPanier, Client pClient){
        Commande commande = new Commande(pPanier, pClient.getPrenom()+" "+pClient.getNom());
        commande.client = pClient;
        return commande;
    }

    /**
     * Cree une nouvelle commande
     * @param pPanier l'objet panier de la commande
     */
    public static Commande creerCommande(Panier pPanier, String pClient){
        return new Commande(pPanier,pClient);
    }

    /**
     * Constructeur privee de commande, il faut passer par creerCommande pour instancier un objet
     * @param pPanier l'objet panier de la commande
     * @param pClient le nom du client
     */
    private Commande(Panier pPanier, String pClient){
        id = UUID.randomUUID();

        prenomClient = pClient;

        panier = pPanier;
        date = LocalDateTime.now();
        etatActuel = Etat.COMMENCEE;
        commandeListe.add(this);

        for(Vendable v : panier.getSoldableList()){
            if(v instanceof Offre){
                for(Produit p : ((Offre)v).getProduitListe())
                    produitCommandeListe.add(new ProduitCommande(p));
            }
            if(v instanceof Produit)
                produitCommandeListe.add(new ProduitCommande((Produit)v));
        }
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Commande p : commandeListe){
            if(p.id.equals(this.id))
                return p;
        }
        commandeListe.add(this);
        return this;
    }

    /**
     * Verifie l'etat de tous les produits pour mettre a jour l'etat de la commande
     * en consequence.
     **/
    public void maj() {
        boolean fini=true;
        boolean commencee=true;

        for(ProduitCommande p : produitCommandeListe){

            if(p.getEtat()!=ProduitCommande.Etat.COMMENCE)
                commencee=false;

            if(p.getEtat()!= ProduitCommande.Etat.SERVI)
                fini = false;

            if(p.getEtat()== ProduitCommande.Etat.EN_COURS){
                etatActuel = Etat.EN_COURS;
            }
        }

        if(fini){
            etatActuel = Etat.TERMINEE;
        }
        if(commencee)
            etatActuel = Etat.COMMENCEE;

    }

    public String getIdentiteClient(){
        if(client!=null){
            return client.getPrenom()+" "+client.getNom();
        }else
            return prenomClient;
    }

    public ArrayList<ProduitCommande> getProduitCommandeListe() {
        return produitCommandeListe;
    }

    public static ArrayList<Commande> getCommandeListe() {
        return commandeListe;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Etat getEtatActuel() {
        return etatActuel;
    }

    public void setEtatActuel(Etat etatActuel) {
        this.etatActuel = etatActuel;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
