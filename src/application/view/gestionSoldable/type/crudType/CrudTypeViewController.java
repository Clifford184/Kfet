package application.view.gestionSoldable.type.crudType;

import application.model.vendable.Categorie;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.GestionCategorieView;
import application.view.gestionSoldable.type.GestionTypeView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class CrudTypeViewController extends ViewController {

    @FXML
    private AnchorPane viewCrudType;
    @FXML
    private ComboBox<Categorie> listeCategorie;

    @FXML
    private TextField nomType;

    public void annuler(){
        GestionTypeView gestionTypeView = new GestionTypeView();
        getView().changerScene(gestionTypeView);
    }

    public void valider(){
        getView().getController().creationType(nomType.getText(), listeCategorie.getValue());
        annuler();
    }

    public CrudTypeViewController(){}

    public CrudTypeView getView(){
        return (CrudTypeView) super.getView();
    }

    public ComboBox<Categorie> getListeCategorie() {
        return listeCategorie;
    }

    public void setListeCategorie(ArrayList<Categorie> listeCategorie) {
        this.listeCategorie.getItems().setAll(listeCategorie);
    }

    public TextField getNomType() {
        return nomType;
    }

    public void setNomType(TextField nomType) {
        this.nomType = nomType;
    }

    public AnchorPane getViewCrudType() {
        return viewCrudType;
    }
}
