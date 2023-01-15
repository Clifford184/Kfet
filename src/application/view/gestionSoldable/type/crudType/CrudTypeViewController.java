package application.view.gestionSoldable.type.crudType;

import application.model.vendable.Type;
import application.outils.ImageManager;
import application.view.ViewController;
import application.view.gestionSoldable.type.GestionTypeView;
import application.view.utile.AlertView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class CrudTypeViewController extends ViewController {

    public ImageView typeImage;
    public ImageView annulerImgBtn;
    public ImageView validerImgBtn;
    public Button choisirImageBtn;
    @FXML
    private AnchorPane viewCrudType;
    @FXML
    private TextField nomType;

    private String cheminImage;
    boolean contexteModification = false;

    /**
     * Methode qui initialise les elements graphique de la vue
     */
    public void initialize() {

        annulerImgBtn.setImage(ImageManager.chargerImage("/ressource/image/icone/annuler.png"));
        annulerImgBtn.setOnMouseClicked(mouseEvent -> annuler());

        validerImgBtn.setImage(ImageManager.chargerImage("/ressource/image/icone/valide.png"));
        validerImgBtn.setOnMouseClicked(mouseEvent -> valider());

        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(imageFilter);
        choisirImageBtn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File fichierImage = fileChooser.showOpenDialog(new Stage());
                if (fichierImage == null)
                    return;
                cheminImage = fichierImage.getAbsolutePath();
                typeImage.setImage(new Image(cheminImage));
            }
        });

    }

    /**
     * Permet de signifier qu'on est en train de modifier un produit.
     * Va peupler les champs des valeurs du produit et le comportement
     * de la validation aura pour effet de modifier le produit
     *
     * @param pType le type sujet a la modification
     */
    public void setContexteModification(Type pType) {
        getView().getController().setType(pType);
        contexteModification = true;
        nomType.setText(pType.getNom());
        typeImage.setImage(new Image(new File(pType.getCheminImage()).toURI().toString()));
        cheminImage = pType.getCheminImage();
    }

    /**
     * Redirige vers la page de gestion de type
     */
    public void annuler() {
        GestionTypeView gestionTypeView = new GestionTypeView();
        getView().changerPage((Stage) getViewCrudType().getScene().getWindow(), gestionTypeView);
    }

    /**
     * creer ou modifie un type en fonction du contexte
     */
    public void valider() {
        try {
            if (contexteModification) {
                getView().getController().modificationType(nomType.getText(), cheminImage);
            } else {
                getView().getController().creationType(nomType.getText(), cheminImage);
            }
            annuler();
        } catch (Exception e) {
            AlertView alertView = new AlertView();
            getView().genererNouvellePage(alertView);
            alertView.getController().setMessage("Echec de la creation/modification type");
        }
    }

    public CrudTypeViewController() {
    }

    public CrudTypeView getView() {
        return (CrudTypeView) super.getView();
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
