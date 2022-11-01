package application.view.gestionSoldable.categorie.crudCategorie;

import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CrudCategorieViewController extends ViewController {

    @FXML
    private TextField nomCategorie;


    public void annuler() {
        getView().close();
    }

    public void valider() {
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

    public CrudCategorieViewController() {
    }

    public CrudCategorieView getView() {
        return (CrudCategorieView) super.getView();
    }

    public TextField getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(TextField nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
}
