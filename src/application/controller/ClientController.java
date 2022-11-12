package application.controller;

import application.model.client.Client;
import application.model.client.Groupe;

import java.util.ArrayList;

public class ClientController {

    public void addClient(String pName, String pSurname, Groupe pGroupe){
        Client c = new Client(pName, pSurname, pGroupe);
    }

    public void addMoney(Client pClient, float pMoney){
        pClient.ajouterArgent(pMoney);
    }

    public ArrayList<Client> sortByName(String pName, Groupe groupe){
        return groupe.listeClientCorrespondPrenom(pName);
    }
}
