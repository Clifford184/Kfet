package application.view.utile;

import application.model.client.Client;
import application.model.client.Groupe;
import application.view.Menu;
import application.view.ViewController;
import application.view.compte.DebitArgentCompte.DebitArgentCompteView;
import application.view.compte.ajoutArgentCompte.AjoutArgentCompteView;
import application.view.compte.crudClient.CrudClientView;
import application.view.compte.gestionGroupe.GestionGroupeView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AlertViewController extends ViewController {

    @FXML
    private AnchorPane alertView;

    @FXML
    private Label alertLabel;

    @FXML
    private Button okButton;

    public void initialiserView(){
        okButton.setOnMouseClicked(mouseEvent -> fermerView());
    }

    public void fermerView(){
        Stage stage = (Stage) alertView.getScene().getWindow();
        stage.close();
    }

    /**
     * constructeur par défaut
     */
    public AlertViewController() {
    }

    public AlertView getView() {
        return (AlertView) super.getView();
    }

    public Label getAlertLabel() {
        return alertLabel;
    }

    public void setAlertLabel(String alertMessage) {
        this.alertLabel.setText(alertMessage);
    }
}
