package application.view.gestionSoldable.offre.crudOffre;

import application.model.vendable.Categorie;
import application.view.ViewController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class CategorieOffreElementController extends ViewController {

    public Label nomCategorie;
    public Button supprimerCategorie;
    CrudOffreViewController vue;
    Categorie categorie;

    /**
     * Permet d'initialiser un element dynamique d'une categorie choisie lors
     * de la creation d'une offre.
     * @param pVue l'objet vue associe, necessaire pour appeler ses fonctions
     * @param pCategorie la categorie relie a cet element
     */
    public void initialize(Pane pPane, CrudOffreViewController pVue, Categorie pCategorie){
        categorie = pCategorie;
        nomCategorie.setText(categorie.toString());
        vue = pVue;

        supprimerCategorie.setOnAction(actionEvent -> vue.retirerCategorie(pPane, categorie));
        pPane.setOnMouseClicked(mouseEvent -> vue.focusCategorie(categorie));
    }
}
