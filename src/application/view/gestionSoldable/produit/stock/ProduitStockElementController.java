package application.view.gestionSoldable.produit.stock;

import application.model.Stock;
import application.model.vendable.Produit;
import application.view.ViewController;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class ProduitStockElementController extends ViewController {

    public Label labelNomProduit;
    public Label labelPrixAchat;
    public Label labelPrixVente;
    public Label labelPrixVMembre;
    public TextField ajoutTextfield;
    public Label stockLabel;
    boolean modif;

    Produit produit;

    public void initialize(Produit pProduit, boolean pModif) {
        modif = pModif;
        produit = pProduit;

        ajoutTextfield.setVisible(modif);

        UnaryOperator<TextFormatter.Change> filtrePrix = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?\\d{0,3}?")) {
                return change;
            }
            return null;
        };
        ajoutTextfield.setTextFormatter(new TextFormatter<>(filtrePrix));

        labelNomProduit.setText(pProduit.getNom());
        labelPrixAchat.setText(pProduit.getPrixAchat()+"e");
        labelPrixVente.setText(pProduit.getPrixVente()+"e");
        labelPrixVMembre.setText(pProduit.getPrixVenteMembre()+"e");
        ajoutTextfield.setEditable(modif);
        stockLabel.setText("("+ Stock.getInstance().combienEnStock(pProduit)+")");
    }

    public void validerAjoutStock(){
        if(!ajoutTextfield.getText().equals("")){
            Stock.getInstance().remplirStock(produit, Integer.parseInt(ajoutTextfield.getText()));
            ajoutTextfield.setText("");
            stockLabel.setText("("+ Stock.getInstance().combienEnStock(produit)+")");
        }
    }
}
