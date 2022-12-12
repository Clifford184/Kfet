package application.view.gestionSoldable.type.crudType;

import application.model.vendable.Categorie;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.GestionCategorieView;
import application.view.gestionSoldable.type.GestionTypeView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class CrudTypeViewController extends ViewController {

    @FXML
    private AnchorPane viewCrudType;
    @FXML
    private ComboBox<Categorie> listeCategorie;
    @FXML
    private TextField nomType;

    private String image;

    @FXML
    public void ChoisirImage() {
        final FileChooser selecteurDeFichier = new FileChooser();
        selecteurDeFichier.setTitle("choisir une image");
        File fichier = selecteurDeFichier.showOpenDialog(null);
        image = fichier.getPath();
    }

    public void annuler(){
        GestionTypeView gestionTypeView = new GestionTypeView();
        getView().changerPage((Stage) getViewCrudType().getScene().getWindow(), gestionTypeView);
    }

    public void valider(){
        getView().getController().creationType(nomType.getText(), listeCategorie.getValue(), image);
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
