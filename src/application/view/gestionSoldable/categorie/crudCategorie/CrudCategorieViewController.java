package application.view.gestionSoldable.categorie.crudCategorie;

import application.model.vendable.Categorie;
import application.model.vendable.Type;
import application.outils.ImageManager;
import application.view.ViewController;
import application.view.gestionSoldable.categorie.GestionCategorieView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CrudCategorieViewController extends ViewController {

    public ImageView annulerImageBtn;
    public ImageView validerImageBtn;
    public TableView<Type> tousTypeTable;
    public TableColumn<Type,String> nomTousTypeColonne;
    public TableView<Type> typeCategorieTable;
    public TableColumn<Type,String> nomCatTypeColonne;
    public Button ajouterTypeBtn;
    public Button retirerTypeBtn;
    @FXML
    private AnchorPane viewCrudCategorie;
    @FXML
    private TextField nomCategorie;

    boolean contexteModification = false;


    public void initialize(){

        nomTousTypeColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tousTypeTable.getItems().addAll(Type.getTypeListe());

        nomCatTypeColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));

        annulerImageBtn.setImage(ImageManager.genererImage("/ressource/image/icone/annuler.png"));
        annulerImageBtn.setOnMouseClicked(mouseEvent -> annuler());

        validerImageBtn.setImage(ImageManager.genererImage("/ressource/image/icone/valide.png"));
        validerImageBtn.setOnMouseClicked(mouseEvent -> valider());

        ajouterTypeBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Type type = tousTypeTable.getSelectionModel().getSelectedItem();
                if(type==null)
                    return;
                typeCategorieTable.getItems().add(type);
                tousTypeTable.getItems().remove(type);
            }
        });
        retirerTypeBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Type type = typeCategorieTable.getSelectionModel().getSelectedItem();
                if(type==null)
                    return;
                tousTypeTable.getItems().add(type);
                typeCategorieTable.getItems().remove(type);
            }
        });

    }


    public void annuler() {
        GestionCategorieView gestionCategorieView = new GestionCategorieView();
        getView().changerPage((Stage) getViewCrudCategorie().getScene().getWindow(), gestionCategorieView);
    }

    public void valider() {

        ArrayList<Type> typeListe = new ArrayList<>(typeCategorieTable.getItems());

        if(contexteModification){
            getView().getController().modificationCategorie(nomCategorie.getText(), typeListe);
        }else{
            getView().getController().creationCategorie(nomCategorie.getText(), typeListe);
        }

        annuler();
    }

    public void setContexteModification(Categorie pCategorie) {

        contexteModification = true;

        getView().getController().setCategorie(pCategorie);

        ArrayList<Type> typeSansDoublon = new ArrayList<>(Type.getTypeListe());
        typeSansDoublon.removeAll(pCategorie.getTypeListe());
        tousTypeTable.getItems().clear();
        tousTypeTable.getItems().addAll(typeSansDoublon);

        typeCategorieTable.getItems().addAll(pCategorie.getTypeListe());
        nomCategorie.setText(pCategorie.getNom());
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
