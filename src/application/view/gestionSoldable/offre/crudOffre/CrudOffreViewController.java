package application.view.gestionSoldable.offre.crudOffre;

import application.view.ViewController;
import application.view.gestionSoldable.offre.GestionOffreView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CrudOffreViewController extends ViewController {

    @FXML
    private AnchorPane viewCrudOffre;


    public void annuler() {
        GestionOffreView gestionOffreView = new GestionOffreView();
        getView().changerScene(gestionOffreView);
    }

    public void valider() {
        annuler();
    }

    public CrudOffreViewController() {
    }

    public CrudOffreView getView() {
        return (CrudOffreView) super.getView();
    }


    public AnchorPane getViewCrudOffre() {
        return viewCrudOffre;
    }
}
