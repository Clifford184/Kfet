package Model.Client;

public class Client {

    String name;
    String firstname;
    Promo promo;
    float money;

    public Client(String pName, String pFirstname, Promo pPromo, float pMoney){
        name = pName;
        firstname = pFirstname;
        promo = pPromo;
        money = pMoney;
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
}
