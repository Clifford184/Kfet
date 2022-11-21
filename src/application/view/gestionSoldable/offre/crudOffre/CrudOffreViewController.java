package application.view.gestionSoldable.offre.crudOffre;

import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.view.ViewController;
import application.view.gestionSoldable.offre.GestionOffreView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CrudOffreViewController extends ViewController {

    public Button ajouterCategorie;
    public ComboBox<String> listeCategorie;
    public TextField nomMenu;
    public ImageView image;
    public TextField prixVente;
    public TextField labelRevient;
    public TextField prixMembre;
    public Button choisirImage;
    public VBox tableCategorie;
    public VBox tableType;
    public VBox tableProduit;
    public TextField labelMarge;
    private AnchorPane viewCrudOffre;


    ArrayList<Categorie> categorieListe = new ArrayList<>();
    ArrayList<Produit> blacklist = new ArrayList<>();

    private CrudOffreViewController vue;    //Necessaire pour etre accessible dans l'inner class de l'EventHandler

    public CrudOffreViewController() {
        vue = this;
    }

    @FXML
    private void initialize() {

        labelMarge.setEditable(false);
        labelRevient.setEditable(false);

        prixVente.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                majCoutRevient();
            }
        });
        prixMembre.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                majCoutRevient();
            }
        });

        ObservableList<String> list = FXCollections.observableArrayList(Categorie.listeDesCategories());
        listeCategorie.setItems(list);
        if(list.size()>0)
            listeCategorie.getSelectionModel().select(0);

        ajouterCategorie.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/crudOffreCategoriePane.fxml"));
                    Pane pane = loader.load();

                    ControllerCategorieListeElement controller = loader.getController();

                    //Possible de le faire uniquement car les donnees ne sont accessible que depuis cette application
                    Categorie categorie = Categorie.categorieListe.get(listeCategorie.getSelectionModel().getSelectedIndex());

                    controller.initialize(pane,vue,categorie);

                    tableCategorie.getChildren().add(pane);

                    categorieListe.add(categorie);

                    majCoutRevient();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void retirerCategorie(Pane pPane, Categorie pCategorie){
        tableCategorie.getChildren().remove(pPane);
        categorieListe.remove(pCategorie);
    }

    public void focusCategorie(Categorie pCategorie){
        tableType.getChildren().clear();
        tableProduit.getChildren().clear();

        for(Type type : pCategorie.getTypeListe()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/crudOffreTypePane.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ControllerTypeListeElement controller = loader.getController();
            controller.initialize(pane,vue,type);
            tableType.getChildren().add(pane);
        }
    }

    public void focusType(Type pType){
        tableProduit.getChildren().clear();

        for(Produit produit : pType.getProduitListe()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/crudOffreProduitPane.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ControllerProduitListeElement controller = loader.getController();
            controller.initialize(!blacklist.contains(produit),vue,produit);
            tableProduit.getChildren().add(pane);
        }

    }

    public void majCoutRevient(){

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

        labelRevient.setText(prixMinRevient+" - "+prixMaxRevient);
        labelMarge.setText(prixMinMarge+" - "+prixMaxMarge);

    }

    public void ajouterBlacklist(Produit pProduit){
        if(!blacklist.contains(pProduit)){
            blacklist.add(pProduit);
            majCoutRevient();
        }
    }

    public void retirerBlacklist(Produit pProduit){
        blacklist.remove(pProduit);
        majCoutRevient();
    }

    public void annuler() {
        GestionOffreView gestionOffreView = new GestionOffreView();
        getView().changerScene(gestionOffreView);
    }

    public void valider() {
        annuler();
    }

    public CrudOffreView getView() {
        return (CrudOffreView) super.getView();
    }

    public AnchorPane getViewCrudOffre() {
        return viewCrudOffre;
    }


}
