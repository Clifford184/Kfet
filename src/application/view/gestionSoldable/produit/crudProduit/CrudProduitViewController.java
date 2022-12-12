package application.view.gestionSoldable.produit.crudProduit;

import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.view.ViewController;
import application.view.gestionSoldable.produit.GestionProduitView;
import application.view.gestionSoldable.type.GestionTypeView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class CrudProduitViewController extends ViewController {

    @FXML
    private AnchorPane viewCrudProduit;

    @FXML
    private ComboBox<Type> listeType;

    @FXML
    private TextField nomProduit;

    @FXML
    private TextField prixAchat;

    @FXML
    private TextField prixVente;

    private String image;


    @FXML
    public void ChoisirImage() {
        final FileChooser selecteurDeFichier = new FileChooser();
        selecteurDeFichier.setTitle("choisir une image");
        File fichier = selecteurDeFichier.showOpenDialog(null);
        image = fichier.getPath();
    }

    public void annuler(){
        GestionProduitView gestionProduitView = new GestionProduitView();
        getView().changerPage((Stage) getViewCrudProduit().getScene().getWindow() ,gestionProduitView);
    }

    public void valider(){
        // TODO Gerer les exceptions + ou mettre le new produit
        // TODO faire le champs interface prix vente membre
        // TODO afficher marge comme creation offre
        float prixVenteMembre = 0;
        try {
            String nomProduit = this.nomProduit.getText();
            float prixAchatProduit = Float.parseFloat(prixAchat.getText());
            float prixVenteProduit = Float.parseFloat(prixVente.getText());
            Type typeProduit = listeType.getValue();
            String chemin = image;
            getView().getController().creationProduit(nomProduit, prixAchatProduit, prixVenteProduit,prixVenteMembre, typeProduit, chemin);

            annuler();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public CrudProduitViewController(){}

    public CrudProduitView getView(){
        return (CrudProduitView) super.getView();
    }

    public ComboBox<Type> getListeType() {
        return listeType;
    }

    public void setListeType(ArrayList<Type> listeType) {
        this.listeType.getItems().setAll(listeType);
    }

    public AnchorPane getViewCrudProduit() {
        return viewCrudProduit;
    }
}
