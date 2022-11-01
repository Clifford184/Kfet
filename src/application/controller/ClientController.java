package application.controller;

import application.Model.Client.Client;
import application.Model.Client.Promo;

import java.util.ArrayList;

public class ClientController {

    public void addClient(String pName, String pSurname, Promo pPromo){
        Client c = new Client(pName, pSurname, pPromo);
    }

    public void addMoney(Client pClient, float pMoney){
        pClient.addMoney(pMoney);
    }

    public ArrayList<Client> sortByName(String pName, Promo promo){
        return promo.getClientArrayMatchedByName(pName);
    }
}
