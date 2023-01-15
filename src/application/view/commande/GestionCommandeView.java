package application.view.commande;

import application.controller.Observable;
import application.controller.commande.GestionCommandeController;
import application.outils.SceneLoader;
import application.view.View;
import application.view.ViewController;
import javafx.stage.Stage;

public class GestionCommandeView extends View {

    private static GestionCommandeView singleton;

    /**
     * constructeur par défaut
     */
    private GestionCommandeView() {
        cheminVue = "/ressource/view/commande/gestionCommande.fxml";
        nomFenetre = "Gestion commande";
        setController(null);
    }

    public static GestionCommandeView creerGestionCommandeView(){
        if(singleton==null){
            singleton = new GestionCommandeView();
        }
        return singleton;
    }

    /**
     * methode d'initialisation du controller de la vue
     */
    @Override
    public void initialize() {
        // Initialization of the controller.
        if (getController() == null) {
            setController(new GestionCommandeController());
        }
        getController().initialize();
    }

    @Override
    public void show() {
        View.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewController viewController = SceneLoader.loadScene(stage,cheminVue,nomFenetre);

        setViewController(viewController);
        getViewController().setView(this);

        initialize();
        getViewController().afficherCommande();

        stage.show();

        stage.setOnCloseRequest(we -> singleton = null);
    }

    public void stop(){
        singleton = null;
    }

    public static void notifierNouvelleCommande(){
        if(singleton!=null){
            singleton.getViewController().afficherCommande();
        }
    }

    @Override
    public void update(Observable observable, String[] messages) {
        for (String message : messages) {
            switch (message) {
                case "commande_modifiee" -> {
                    // Update du menu en fonctions des soldable existant
                    getViewController().afficherCommande();
                }
            }
        }
    }

    public static boolean dejaOuverte(){
        return singleton!=null;
    }

    @Override
    public GestionCommandeController getController() {
        return (GestionCommandeController) super.getController();
    }

    @Override
    public GestionCommandeViewController getViewController() {
        return (GestionCommandeViewController) super.getViewController();
    }
}
