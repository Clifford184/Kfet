package application.view;

import application.controller.Observable;

/**
 * The observer (the view) observes an observable (the controller)
 * and updates itself when the observable notifies it.
 */
public interface Observer {
    /**
     * Updates the observer when the observable notifies it.
     * @param observable The observable that the observer observes.
     * @param messages Messages sent by the observer to inform the observer of what to do.
     */
    void update(Observable observable, String[] messages);
}
