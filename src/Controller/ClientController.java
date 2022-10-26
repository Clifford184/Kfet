package Controller;

import Model.Client.Client;
import Model.Client.Promo;

import java.util.ArrayList;

public class ClientController {

    public void addClient(String pName, String pSurname, Promo pPromo){
        Client c = new Client(pName, pSurname, pPromo,0);
    }

    public void addMoney(Client pClient, float pMoney){
        pClient.addMoney(pMoney);
    }

    public ArrayList<Client> sortByName(String pName, Promo promo){
        return promo.getClientArrayMatchedByName(pName);
    }
}
