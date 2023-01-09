package application.view.gestionSoldable.offre.crudOffre;

import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.model.vendable.Type;
import application.outils.ControllerEtPane;
import application.outils.ImageManager;
import application.outils.SceneLoader;
import application.view.ViewController;
import application.view.gestionSoldable.offre.GestionOffreView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.UnaryOperator;

public class CrudOffreViewController extends ViewController {

    public Button ajouterCategorie;
    public ComboBox<String> listeCategorie;
    public TextField nomMenu;
    public ImageView image;
    public TextField prixVente;
    public TextField prixMembre;
    public Button choisirImage;
    public VBox tableCategorie;
    public VBox tableType;
    public VBox tableProduit;
    public TextField champRevient;
    public TextField champMarge;
    public TextField champMargeMembre;
    public Button validerBtn;
    public Button annulerBtn;
    @FXML
    private AnchorPane viewCrudOffre;

    ArrayList<Categorie> categorieListe = new ArrayList<>();
    ArrayList<Produit> blacklist = new ArrayList<>();
    String cheminImage;

    boolean contexteModification = false;

    private CrudOffreViewController vue;    //Necessaire pour etre accessible dans l'inner class de l'EventHandler

    public CrudOffreViewController() {
        vue = this;
    }

    /**
     * Initialise le comportements des elements graphiques:
     * Le format pour entrer les prix dans les textfield
     * Les actions relies aux boutons
     */
    @FXML
    private void initialize() {

        validerBtn.setOnMouseClicked(mouseEvent -> valider());
        annulerBtn.setOnMouseClicked(mouseEvent -> annuler());

        champMarge.setEditable(false);
        champRevient.setEditable(false);
        champMargeMembre.setEditable(false);

        UnaryOperator<TextFormatter.Change> filtrePrix = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d{0,3}([.]\\d{0,2})?")) {
                return change;
            }
            return null;
        };

        prixVente.textProperty().addListener((observableValue, s, t1) -> majStatPrix());

        prixVente.setTextFormatter(new TextFormatter<>(filtrePrix));

        prixMembre.textProperty().addListener((observableValue, s, t1) -> majStatPrix());

        prixMembre.setTextFormatter(new TextFormatter<>(filtrePrix));

        ObservableList<String> list = FXCollections.observableArrayList(Categorie.listeDesCategories());
        listeCategorie.setItems(list);
        if(list.size()>0)
            listeCategorie.getSelectionModel().select(0);

        ajouterCategorie.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Categorie categorie = Categorie.categorieListe.get(listeCategorie.getSelectionModel().getSelectedIndex());
                ajouterCategorie(categorie);

            }
        });

        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(imageFilter);
        choisirImage.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File fichierImage = fileChooser.showOpenDialog(new Stage());
                if (fichierImage == null)
                    return;
                cheminImage = fichierImage.getAbsolutePath();
                image.setImage(new Image(cheminImage));
            }
        });
    }

    /**
     * Ajoute une categorie de la liste des categories composant l'offre
     * 1 categorie = 1 produit au choix disponible dans l'offre
     * @param pCategorie la categorie a ajouter
     */
    public void ajouterCategorie(Categorie pCategorie){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/gestionSoldable/offre/crudOffreCategoriePane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CategorieOffreElementController controller = loader.getController();

        controller.initialize(pane,vue,pCategorie);

        tableCategorie.getChildren().add(pane);

        categorieListe.add(pCategorie);

        majStatPrix();

    }

    /**
     * Retire une categorie de la liste des categories composant l'offre
     * 1 categorie = 1 produit au choix disponible dans l'offre
     * @param pPane la pane graphique correspondant a cette categorie
     * @param pCategorie la categorie a retirer
     */
    public void retirerCategorie(Pane pPane, Categorie pCategorie){
        tableCategorie.getChildren().remove(pPane);
        categorieListe.remove(pCategorie);
    }

    /**
     * Affiche la liste des types correspondant a une categorie. L'utilisateur pourra
     * ensuite cliquer sur un des types pour en afficher les produits
     * @param pCategorie la categorie dont les types sont a afficher
     */
    public void focusCategorie(Categorie pCategorie){
        tableType.getChildren().clear();
        tableProduit.getChildren().clear();

        for(Type type : pCategorie.getTypeListe()){

            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/gestionSoldable/offre/crudOffreTypePane.fxml");

            TypeOffreElementController controller = (TypeOffreElementController) controllerEtPane.getController();
            controller.initialize(vue,type);
            controllerEtPane.getPane().setOnMouseClicked(mouseEvent -> vue.focusType(type));
            tableType.getChildren().add(controllerEtPane.getPane());
        }
    }

    /**
     * Affiche la liste des produits correspondant a un type.
     * Les produits sont automatiquement decoche si ils sont deja present
     * dans la blacklist
     * @param pType le type dont les produits sont a affiches
     */
    public void focusType(Type pType){
        tableProduit.getChildren().clear();

        for(Produit produit : pType.getProduitListe()){
            ControllerEtPane controllerEtPane =
                    SceneLoader.loadPane("/ressource/view/gestionSoldable/offre/crudOffreProduitPane.fxml");

            ProduitOffreElementController controller = (ProduitOffreElementController) controllerEtPane.getController();
            controller.initialize(!blacklist.contains(produit),vue,produit);
            tableProduit.getChildren().add(controllerEtPane.getPane());
        }

    }

    /**
     * Met a jour les champs concernant les marges et cout de revient de l'offre
     */
    public void majStatPrix(){

        if(prixVente.getText().equals("")|| prixMembre.getText().equals(""))
            return;

        HashMap<Integer,Float> coutAchatBorne =
                getView().getController().intervalleCoutAchat(categorieListe,blacklist);

        float prixMinRevient, prixMaxRevient,
                prixMinMarge, prixMinMargeMembre, prixMaxMarge, prixMaxMargeMembre;
        prixMinRevient = coutAchatBorne.get(0);
        prixMaxRevient = coutAchatBorne.get(1);

        prixMinMarge = Float.parseFloat(prixVente.getText()) - prixMaxRevient;
        prixMinMargeMembre = Float.parseFloat(prixMembre.getText()) - prixMaxRevient;
        prixMaxMarge = Float.parseFloat(prixVente.getText()) - prixMinRevient;
        prixMaxMargeMembre = Float.parseFloat(prixMembre.getText()) - prixMinRevient;

        champRevient.setText("de "+prixMinRevient+" à "+prixMaxRevient+"e");
        champMarge.setText("de "+prixMinMarge+" à "+prixMaxMarge+"e");
        champMargeMembre.setText("de "+prixMinMargeMembre+" à "+prixMaxMargeMembre+"e");

    }

    /**
     * Ajoute un produit a la blackliste temporaire de la creation de l'offre en cours
     * @param pProduit le produit a ajouter
     */
    public void ajouterBlacklist(Produit pProduit){
        if(!blacklist.contains(pProduit)){
            blacklist.add(pProduit);
            majStatPrix();
        }
    }

    /**
     * Retire un produit de la blackliste temporaire de la creation de l'offre en cours
     * @param pProduit le produit a retirer
     */
    public void retirerBlacklist(Produit pProduit){
        blacklist.remove(pProduit);
        majStatPrix();
    }

    public void setContexteModification(TemplateOffre pOffre) {
        contexteModification = true;
        getView().getController().setTemplateOffre(pOffre);

        blacklist.addAll(pOffre.getBlackList());
        for(Categorie c: pOffre.getCategorieListe())
            ajouterCategorie(c);

        nomMenu.setText(pOffre.getNom());
        image.setImage(ImageManager.genererImage(pOffre.getCheminImage()));
        prixVente.setText(pOffre.getPrixVente()+"");
        prixMembre.setText(pOffre.getPrixVenteMembre()+"");

        majStatPrix();

    }

    public void annuler() {
        GestionOffreView gestionOffreView = new GestionOffreView();
        getView().changerPage((Stage) getViewCrudOffre().getScene().getWindow(), gestionOffreView);
    }

    /**
     * Valide la creation de l'offre.
     * L'offre n'est pas cree si l'un des choix critiques est manquants:
     * nom, les prix, liste de categories
     */
    public void valider() {
        String nom = nomMenu.getText();
        float prixV = Float.parseFloat(prixVente.getText());
        float prixVM = Float.parseFloat(prixMembre.getText());
        try {
            if(nom.equals("")||prixV==0||prixVM==0||categorieListe.size()==0)
                return;

            if(contexteModification){
                getView().getController().modificationOffre(nom, prixV,prixVM,categorieListe,blacklist,cheminImage);

            }else{
                getView().getController().creerOffreTemplate(nom, prixV,prixVM,categorieListe,blacklist,cheminImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        annuler();
    }

    public CrudOffreView getView() {
        return (CrudOffreView) super.getView();
    }

    public AnchorPane getViewCrudOffre() {
        return viewCrudOffre;
    }

}
