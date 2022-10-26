package application.controller;

import java.util.ArrayList;
import application.view.Observer;

/**
 * The observable (the controller) is observed by an observer (the view)
 * and notify it when it needs to update its content.
 */
public class Observable {
    /**
     * Observers of the observable.
     */
    private final ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * Add an observer to the observer list.
     * @param observer The observer to add.
     */
    public void register(Observer observer)
    {
        observers.add(observer);
    }

    /**
     * Remove an observer from the observer list.
     * @param observer The observer to remove.
     */
    public void unregister(Observer observer)
    {
        observers.remove(observer);
    }

    /**
     * Notify the observers that they should to update their content.
     * @param messages Messages to inform observers of what to do.
     */
    public void notifyObservers(String[] messages)
    {
        for(Observer observer : observers) {
            observer.update(this, messages);
        }
    }
}
