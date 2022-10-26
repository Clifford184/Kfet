package Controller;

public class ChoicePaiementMethodController {

    public enum PaiementMethod{ //Si on veut ajouter une image pour chaque, en faire des classes ?
        Account,
        External_Application,
        Money
    }

    public void makeChoice(){
        //Faire un switch si enum
        //if si on passe par des classes

        //Money -> On demande le prenom du client (skippable)
        //External -> Idem
        //Account -> Ecran de choix de client. On peut toujours revenir à l'écran de choix
        //Sauvegarde du contexte pour retourner à l'écran principal une fois validé
    }
}
