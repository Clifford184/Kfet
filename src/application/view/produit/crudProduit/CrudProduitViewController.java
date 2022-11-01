package application.view.produit.crudProduit;

import application.Model.Soldable.Categorie;
import application.Model.Soldable.Product;
import application.Model.Soldable.Type;
import application.view.ViewController;
import application.view.priseCommande.PriseCommandeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;

public class CrudProduitViewController extends ViewController {

    @FXML
    private ComboBox<Categorie> categorie;

    @FXML
    private ComboBox<Type> type;

    @FXML
    private TextField nomProduit;

    @FXML
    private TextField prixAchat;

    @FXML
    private TextField prixVente;

    public void annuler(){
        getView().close();
    }

    public void valider(){
        // TODO Gerer les exceptions + ou mettre le new produit
        try {
            float pAchat = Float.parseFloat(prixAchat.getText());
            float pVente = Float.parseFloat(prixVente.getText());
            Product newProduit = new Product(nomProduit.getText(),pAchat, pVente,type.getValue());

            getView().close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public CrudProduitViewController(){}

    public CrudProduitView getView(){
        return (CrudProduitView) super.getView();
    }

    public ComboBox<Categorie> getCategorie() {
        return categorie;
    }

    public void setCategorie(ArrayList<Categorie> categorie) {
        this.categorie.getItems().setAll(categorie);
    }

    public ComboBox<Type> getType() {
        return type;
    }

    public void setType(ArrayList<Type> type) {
        this.type.getItems().setAll(type);
    }

    public TextField getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(TextField nomProduit) {
        this.nomProduit = nomProduit;
    }

    public TextField getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(TextField prixAchat) {
        this.prixAchat = prixAchat;
    }

    public TextField getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(TextField prixVente) {
        this.prixVente = prixVente;
    }
}
