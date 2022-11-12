package application.model.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Definie un groupe de client
 * Ici le contexte est la gestion d'etudiants.
 * La gestion des groupes utilise une liste chainee de groupe
 * afin d'avoir la possibilite de faire passer tous les etudiants
 * d'un groupe a l'autre (passage a l'annee suivante par exemple)
 */
public class Groupe implements Serializable {

    String nom;

    ArrayList<Client> clientListe;

    Groupe groupeSuivant;
    Groupe groupePrecedent;

    static ArrayList<Groupe> groupeListe = new ArrayList<>();

    /**
     * Cree un nouveau groupe
     * @param pNom son nom
     */
    public Groupe(String pNom){
        clientListe = new ArrayList<>();
        nom = pNom;

        groupeListe.add(this);
    }

    /**
     * Retourne la liste de tous les clients du groupe triee par ordre alphabetique
     * @return la liste triee
     */
    public ArrayList<Client> listeClientTrieAlphabetique(){
        ArrayList<Client> listeTriee = new ArrayList<>(clientListe);

        listeTriee.sort(Comparator.comparing(o -> o.nom));

        return listeTriee;
    }

    /**
     * Retourne la liste des etudiants dont le prenom correspond
     * entierement ou en partie a la chaine passee en parametre
     * @param pPrenom le prenom a rechercher
     * @return la liste triee
     */
    public ArrayList<Client> listeClientCorrespondPrenom(String pPrenom){
        ArrayList<Client> listeTriee = new ArrayList<>();

        for(Client c : clientListe){
            if(c.prenom.startsWith(pPrenom))
                listeTriee.add(c);
        }

        return listeTriee;
    }

    /**
     * Ajoute un nouveau client au groupe
     * @param pClient le client a ajouter
     */
    public void ajouterClient(Client pClient){
        if(clientListe.contains(pClient)==false)
            clientListe.add(pClient);
    }

    /**
     * Retire un client du groupe.
     * @param pClient le client a retire
     * @return si le client a bien ete retire
     */
    public boolean removeClient(Client pClient){
        return clientListe.remove(pClient);
    }

    /**
     * Lie le groupe precedent
     * @param pGroupe le groupe precedent
     */
    public void lieGroupePrecedent(Groupe pGroupe){
        groupePrecedent = pGroupe;
    }

    /**
     * Lie le groupe suivant
     * @param pGroupe le groupe suivant
     */
    public void lieGroupeSuivant(Groupe pGroupe){
        groupeSuivant = pGroupe;
    }

    public ArrayList<Client> getClientListe(){
        return clientListe;
    }

    public void setNom(String pName){
        nom = pName;
    }

}
