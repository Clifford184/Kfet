package application.view.gestionSoldable.produit.crudProduit;

import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.outils.ImageManager;
import application.view.ViewController;
import application.view.gestionSoldable.produit.GestionProduitView;
import application.view.utile.AlertView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class CrudProduitViewController extends ViewController {

    public TextField prixMembre;
    public TextField champMarge;
    public ImageView validerImageBtn;
    public ImageView annulerImageBtn;
    public Button choisirImageBtn;
    public ImageView imageProduit;
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

    private String cheminImage;

    boolean contexteModification = false;

    /**
     * Methode qui initialise les elements graphique de la vue
     */
    public void initialize(){

        listeType.getItems().setAll(Type.getTypeListe());

        champMarge.setEditable(false);

        validerImageBtn.setImage(ImageManager.genererImage("/ressource/image/icone/valide.png"));
        validerImageBtn.onMouseClickedProperty().set(mouseEvent -> valider());

        annulerImageBtn.setImage(ImageManager.genererImage("/ressource/image/icone/annuler.png"));
        annulerImageBtn.onMouseClickedProperty().set(mouseEvent -> annuler());

        UnaryOperator<TextFormatter.Change> filtrePrix = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d{0,3}([.]\\d{0,2})?")) {
                return change;
            }
            return null;
        };

        prixAchat.setTextFormatter(new TextFormatter<>(filtrePrix));
        prixVente.setTextFormatter(new TextFormatter<>(filtrePrix));
        prixMembre.setTextFormatter(new TextFormatter<>(filtrePrix));

        prixAchat.textProperty().addListener((observableValue, s, t1) -> majStatPrix());
        prixVente.textProperty().addListener((observableValue, s, t1) -> majStatPrix());
        prixMembre.textProperty().addListener((observableValue, s, t1) -> majStatPrix());


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
                imageProduit.setImage(new Image(cheminImage));
            }
        });

    }

    private void majStatPrix() {

        if(prixVente.getText().equals("")|| prixMembre.getText().equals("") || prixAchat.getText().equals(""))
            return;

        float prixMinMarge, prixMaxMarge;
        if(Float.parseFloat(prixVente.getText())<Float.parseFloat(prixMembre.getText())){
            //Le prix membre est inferieur au prix normal, prix membre -> moins de marge
            prixMinMarge = Float.parseFloat(prixMembre.getText())-Float.parseFloat(prixAchat.getText());
            prixMaxMarge = Float.parseFloat(prixVente.getText())-Float.parseFloat(prixAchat.getText());
        }else{
            prixMinMarge = Float.parseFloat(prixVente.getText())-Float.parseFloat(prixAchat.getText());
            prixMaxMarge = Float.parseFloat(prixMembre.getText())-Float.parseFloat(prixAchat.getText());
        }

        champMarge.setText("de "+prixMinMarge+" à "+prixMaxMarge+"e");
    }

    /**
     * Permet de signifier qu'on est en train de modifier un produit.
     * Va peupler les champs des valeurs du produit et le comportement
     * de la validation aura pour effet de modifier le produit
     * @param pProduit
     */
    public void setContexteModification(Produit pProduit) {
        getView().getController().setProduit(pProduit);
        contexteModification = true;
        nomProduit.setText(pProduit.getNom());
        listeType.getSelectionModel().select(pProduit.getType());
        prixAchat.setText(pProduit.getPrixAchat()+"");
        prixVente.setText(pProduit.getPrixVente()+"");
        prixMembre.setText(pProduit.getPrixVenteMembre()+"");
        imageProduit.setImage(new Image(new File(pProduit.getCheminImage()).toURI().toString()));
        majStatPrix();
    }

    /**
     * Redirige vers la page de gestion produit
     */
    public void annuler(){
        GestionProduitView gestionProduitView = new GestionProduitView();
        getView().changerPage((Stage) getViewCrudProduit().getScene().getWindow() ,gestionProduitView);
    }

    /**
     * creer ou modifie le produit en fonction du contexte
     */
    public void valider(){
        try {

            String nom = nomProduit.getText();
            float prixAchatProduit = Float.parseFloat(prixAchat.getText());
            float prixVenteProduit = Float.parseFloat(prixVente.getText());
            float prixVenteMembre = Float.parseFloat(prixMembre.getText());
            Type typeProduit = listeType.getValue();
            String chemin = cheminImage;

            if(contexteModification){
                getView().getController().modificationProduit(nom, prixAchatProduit, prixVenteProduit,prixVenteMembre, typeProduit, chemin);
            }else{
                getView().getController().creationProduit(nom, prixAchatProduit, prixVenteProduit,prixVenteMembre, typeProduit, chemin);
            }
            annuler();

        }
        catch (Exception e){
            AlertView alertView = new AlertView();
            alertView.getController().setMessage("Echec de la creation/modification du produit");
        }
    }

    public CrudProduitViewController(){}

    public CrudProduitView getView(){
        return (CrudProduitView) super.getView();
    }

    public AnchorPane getViewCrudProduit() {
        return viewCrudProduit;
    }

}
