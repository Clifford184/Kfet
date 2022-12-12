package application.view.priseCommande;

import application.controller.Observable;
import application.controller.priseCommande.PriseCommandeController;
import application.view.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class PriseCommandeView extends View {

    /**
     * constructeur par défaut
     */
    public PriseCommandeView()  {
        cheminVue = "/ressource/view/priseCommande/priseCommandeView.fxml";
        minWidth = 1084;
        minHeight = 724;
        nomFenetre = "Prise de commande";
        setController(null);
    }

    /**
     * methode d'initialisation du controller de la vue
     */
    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new PriseCommandeController());
        }
        getController().initialize();
    }

    /**
     * methode d'affichage de la vue
     */
    @Override
    public void show() {
        View.launch();
    }

    /**
     * methode d'initialisation des paramètres de la vue puis la démarre
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        ViewController viewController = SceneLoader.loadScene(stage,cheminVue,nomFenetre,minWidth,minHeight);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();

        stage.show();

    }

    /**
     * methode de mise à jour des différents éléments de la vue
     * @param observable The observable that the observer observes.
     * @param messages Messages sent by the observer to inform the observer of what to do.
     */
    @Override
    public void update(Observable observable, String[] messages) {
        try {
            for (String message : messages) {
                switch (message) {
                    case "sliderMenu" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().initialisationSliderMenu();
                    }
                    case "type" -> {
                        // Update du menu en fonctions des soldable existant
                        getViewController().InitialiserAffichageType();
                    }
                    case "panier" -> {
                        // Update du panier quand on ajoute un produit
                        getViewController().setArticlePanier(getController().getPanier());
                        getViewController().rechargerProduit();
                    }
                    case "menu" -> {
                        // Update de affichage du menu apres ajout un produit
                        getViewController().AffichageTypeOffre(getViewController().templateOffreSelectionner);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getter du contoller de la vue
     * @return PriseCommandeController le controller de la vue
     */
    @Override
    public PriseCommandeController getController() {
        return (PriseCommandeController) super.getController();
    }

    /**
     * getter du viewContoller de la vue
     * @return PriseCommandeViewController le viewContoller de la vue
     */
    @Override
    public PriseCommandeViewController getViewController() {
        return (PriseCommandeViewController) super.getViewController();
    }
}
