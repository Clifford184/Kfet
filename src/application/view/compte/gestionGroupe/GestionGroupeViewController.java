package application.view.compte.gestionGroupe;



import application.model.client.Client;
import application.model.client.Groupe;
import application.model.vendable.Type;
import application.outils.ImageManager;
import application.view.Menu;
import application.view.ViewController;
import application.view.compte.crudGroupe.CrudGroupeView;
import application.view.utile.AlertView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GestionGroupeViewController extends ViewController {

    @FXML
    private BorderPane gestionGroupeView;

    @FXML
    private AnchorPane sliderMenu;

    @FXML
    private ImageView ajouterGroupeImageView;

    @FXML
    private ImageView modifierGroupeImageView;

    @FXML
    private ImageView supprimerGroupeImageView;

    @FXML
    private ListView<Groupe> groupeListView;

    Groupe groupeSelectionne;

    /**
     * Initialise les elements graphiques de la vue
     */
    public void initialiserView(){

        ajouterGroupeImageView.setImage(ImageManager.genererImage("/ressource/image/icone/ajouterGroupe.png"));
        ajouterGroupeImageView.setOnMouseClicked(mouseEvent -> redirectionCreationGroupe());

        modifierGroupeImageView.setImage(ImageManager.genererImage("/ressource/image/icone/modifierGroupe.png"));
        modifierGroupeImageView.setOnMouseClicked(mouseEvent -> redirectionModificationGroupe());

        supprimerGroupeImageView.setImage(ImageManager.genererImage("/ressource/image/icone/supprimerGroupe.png"));
        supprimerGroupeImageView.setOnMouseClicked(mouseEvent -> supprimerGroupe());

    }

    /**
     * Methode qui ajoute le menu a la vue
     */
    public void initialisationMenu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/view/menu.fxml"));
        VBox vboxMenu = null;
        try {
            vboxMenu = loader.load();
        } catch (IOException e) {
            AlertView alertView = new AlertView();
            getView().genererNouvellePage(alertView);
            alertView.getController().setMessage("Echec initialisation menu");
        }
        sliderMenu.getChildren().add(vboxMenu);

        Menu menuController = loader.getController();
        menuController.initialize(this, (Stage) gestionGroupeView.getScene().getWindow());
    }

    /**
     * Methode qui redirige vers la page de creation d'un nouveau groupe
     */
    public void redirectionCreationGroupe() {
        CrudGroupeView crudGroupeView = new CrudGroupeView();
        getView().changerPage((Stage) gestionGroupeView.getScene().getWindow(), crudGroupeView);
    }

    /**
     * Methode qui redirige vers la page de modification d'un groupe
     */
    public void redirectionModificationGroupe(){
        if(groupeListView.getSelectionModel().getSelectedItem() != null){
            CrudGroupeView crudGroupeView = new CrudGroupeView();
            getView().changerPage((Stage) gestionGroupeView.getScene().getWindow(), crudGroupeView);
            crudGroupeView.getController().setGroupe(groupeListView.getSelectionModel().getSelectedItem());
        } else {
            genererMessageErreur();
        }
    }

    /**
     * Methode qui redirige vers la page de suppression d'un groupe
     */
    public void supprimerGroupe(){
        if(groupeListView.getSelectionModel().getSelectedItem() != null){
            boolean resultat =  getView().getController().supprimerGroupe(groupeListView.getSelectionModel().getSelectedItem());
            if(!resultat) {
                AlertView alertView = new AlertView();
                getView().genererNouvellePage(alertView);
                String messageErreurSuppression = "Impossible de supprimer le groupe "
                                     + groupeListView.getSelectionModel().getSelectedItem().getNom()
                                    +" \n car il reste des clients dans le groupe: \n";
                for (Client client : groupeListView.getSelectionModel().getSelectedItem().getClientListe()){
                    messageErreurSuppression+= client.getPrenom()+" "+client.getNom()+"\n";
                }
                alertView.getController().setMessage(messageErreurSuppression);
            }
        } else {
            genererMessageErreur();
        }
    }

    /**
     * Methode qui permet de generer un message d'erreur si le groupe n'est pas selectionne
     */
    public void genererMessageErreur(){
        AlertView alertView = new AlertView();
        getView().genererNouvellePage(alertView);
        String messageErreur = "Veuillez selectionner un groupe";
        alertView.getController().setMessage(messageErreur);
    }

    public GestionGroupeViewController(){}

    @Override
    public GestionGroupeView getView() {
        return (GestionGroupeView) super.getView();
    }

    public ListView<Groupe> getGroupeListView() {
        return groupeListView;
    }

    public void setGroupeListView(ArrayList<Groupe> listeType) {
        this.groupeListView.getItems().setAll(listeType);
    }
}
