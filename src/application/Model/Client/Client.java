package application.Model.Client;

/**
 * Describes a client who has an account in the application
 */
public class Client {

    String name;
    String firstname;
    Promo promo;
    float money;

    /**
     * Create a new client
     * @param pName his name
     * @param pFirstname his firstname
     * @param pPromo his promo
     */
    public Client(String pName, String pFirstname, Promo pPromo){
        name = pName;
        firstname = pFirstname;
        promo = pPromo;
        promo.addClient(this);
    }

    public void addMoney(float pMoney){
        money += pMoney;
    }

    public void substractMoney(float pAmount){
        money -= pAmount;
    }

    public void promoUp(){
        promo = promo.next;
    }

    public void promoDown(){
        promo = promo.previous;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
