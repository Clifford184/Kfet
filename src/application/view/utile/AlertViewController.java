package application.view.utile;

import application.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
