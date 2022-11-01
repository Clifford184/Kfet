package application.Model;

import application.Model.Client.Client;

import java.time.LocalDateTime;

/**
 * Describes an order that has been placed
 */
public class Order {

    LocalDateTime orderDate;
    Client client;
    Cart cart;

    State currentState;

    public enum State{
        STARTED,
        PAID,
        IN_PROGRESS,
        DELIVERED
    }

    public Order(Cart pCart){
        cart = pCart;
        orderDate = LocalDateTime.now();
        currentState = State.STARTED;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
