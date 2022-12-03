package application.controller.gestionSoldable.produit;

import application.controller.Controller;

public class StockController extends Controller {
    @Override
    public void initialize() {
        String[] messages = {"menu"};
        notifyObservers(messages);
    }
}
