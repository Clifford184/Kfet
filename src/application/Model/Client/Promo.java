package application.Model.Client;

import java.util.ArrayList;
import java.util.Comparator;

public class Promo {

    String name;

    ArrayList<Client> clientList;

    //Used for promoUp and promoDown;
    Promo next;
    Promo previous;

    static ArrayList<Promo> promoList = new ArrayList<>();

    public Promo(String name){
        promoList.add(this);
    }

    public ArrayList<Client> getClientArraySortedByName(){
        ArrayList<Client> sorted = new ArrayList<>(clientList);

        sorted.sort(Comparator.comparing(o -> o.name));

        return sorted;
    }

    public ArrayList<Client> getClientArrayMatchedByName(String pName){
        ArrayList<Client> sorted = new ArrayList<>();

        for(Client c : clientList){
            if(c.firstname.startsWith(pName))
                sorted.add(c);
        }

        return sorted;
    }

    public void addClient(Client pClient){
        if(clientList.contains(pClient)==false)
            clientList.add(pClient);
    }

    public boolean removeClient(Client pClient){
        return clientList.remove(pClient);
    }

    public ArrayList<Client> getClientList(){
        return clientList;
    }

    public void linkPreviousPromo(Promo pPromo){
        previous = pPromo;
    }

    public void linkNextPromo(Promo pPromo){
        next = pPromo;
    }

    public void setName(String pName){
        name = pName;
    }

}
