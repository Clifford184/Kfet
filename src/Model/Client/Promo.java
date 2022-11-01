package Model.Client;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * = "Annee/Filiere"
 * Defines a group of grouped students (for example grouped by year and specialization)
 */
public class Promo {

    String name;

    ArrayList<Client> clientList;

    //Used for promoUp and promoDown;
    Promo next;
    Promo previous;

    static ArrayList<Promo> promoList = new ArrayList<>();

    /**
     * Create a new promo
     * @param pName his name
     */
    public Promo(String pName){
        clientList = new ArrayList<>();
        name = pName;

        promoList.add(this);
    }

    /**
     * Return a list of all his students sorted by name
     * @return the sorted list
     */
    public ArrayList<Client> getClientArraySortedByName(){
        ArrayList<Client> sorted = new ArrayList<>(clientList);

        sorted.sort(Comparator.comparing(o -> o.name));

        return sorted;
    }

    /**
     * Return a list of all his students where the name match with parameter
     * @param pName the name to match
     * @return the sorted list
     */
    public ArrayList<Client> getClientArrayMatchedByName(String pName){
        ArrayList<Client> sorted = new ArrayList<>();

        for(Client c : clientList){
            if(c.firstname.startsWith(pName))
                sorted.add(c);
        }

        return sorted;
    }

    /**
     * Add a client/student to the promo
     * @param pClient
     */
    public void addClient(Client pClient){
        if(clientList.contains(pClient)==false)
            clientList.add(pClient);
    }

    /**
     * Remove a client/student to the promo
     * @param pClient
     * @return
     */
    public boolean removeClient(Client pClient){
        return clientList.remove(pClient);
    }

    /**
     * Link a promo besoin this one (for the promoDown function)
     * @param pPromo
     */
    public void linkPreviousPromo(Promo pPromo){
        previous = pPromo;
    }

    /**
     * Link a promo after this one (for the promoUp function)
     * @param pPromo
     */
    public void linkNextPromo(Promo pPromo){
        next = pPromo;
    }

    public ArrayList<Client> getClientList(){
        return clientList;
    }

    public void setName(String pName){
        name = pName;
    }

}
