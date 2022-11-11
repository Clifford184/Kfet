package application.view.gestionSoldable.type.crudType;

import application.model.vendable.Categorie;
import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CrudTypeViewController extends ViewController {

    @FXML
    private ComboBox<Categorie> categorie;

    @FXML
    private TextField nomType;

    public void annuler(){
        getView().close();
    }

    public void valider(){
        // TODO Gerer les exceptions + ou mettre le new produit
//        try {
//            float pAchat = Float.parseFloat(prixAchat.getText());
//            float pVente = Float.parseFloat(prixVente.getText());
//            Product newProduit = new Product(nomProduit.getText(),pAchat, pVente,type.getValue());
//
//            getView().close();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }

    public CrudTypeViewController(){}

    public CrudTypeView getView(){
        return (CrudTypeView) super.getView();
    }

    public ComboBox<Categorie> getCategorie() {
        return categorie;
    }

    public void setCategorie(ComboBox<Categorie> categorie) {
        this.categorie = categorie;
    }

    public TextField getNomType() {
        return nomType;
    }

    public void setNomType(TextField nomType) {
        this.nomType = nomType;
    }
}
