package application.view.gestionSoldable.categorie.crudCategorie;

import application.view.View;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.GestionCategorieView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class CrudCategorieViewController extends ViewController {

    @FXML
    private AnchorPane viewCrudCategorie;
    @FXML
    private TextField nomCategorie;


    public void annuler() {
        GestionCategorieView gestionCategorieView = new GestionCategorieView();
        getView().changerScene(gestionCategorieView);
    }

    public void valider() {
        getView().getController().creationCategorie(nomCategorie.getText());
        annuler();
    }

    public CrudCategorieViewController() {
    }

    public CrudCategorieView getView() {
        return (CrudCategorieView) super.getView();
    }

    public TextField getNomCategorie() {
        return nomCategorie;
    }

    public AnchorPane getViewCrudCategorie() {
        return viewCrudCategorie;
    }
}
