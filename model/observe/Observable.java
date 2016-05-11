package model.observe;


import model.observe.notification.Notification;

import java.util.Vector;

/**
 * Created by Anis on 29/04/2016.
 */
public abstract class Observable {

    private Vector<IObserver> observers;

    public Observable() {
        observers = new Vector<>();
    }

    /**
     * Notifier les Observeurs
     *
     * @param notif La notification
     */
    final public void notifyObservers(Notification notif) {

        //TODO : Copier le message
        for (IObserver observer : observers) {
            observer.update(notif);
        }

    }

    /**
     * Ajouter un observeur
     *
     * @param observer l'observeur à ajouter
     */
    final public void addObserver(IObserver observer) {
        if (observer == null)
            throw new NullPointerException();
        if (!observers.contains(observer)) {
            observers.addElement(observer);
            afterAdd(observer);
        }
    }

    /**
     * Seule méthode que peut redefinir une classe fille
     *
     * Equivalent d'un Evènement "Observeur ajouté"
     * @param observer
     */
    protected void afterAdd(IObserver observer) {

    }

    /**
     * Supprimer un observeur
     *
     * @param observer L'observeur à supprimer
     */
    final public void deleteObserver(IObserver observer) {
        observers.remove(observer);
    }

    /**
     * Supprime tous les observeur
     */
    final public void clearAll() {
        observers.removeAllElements();
    }


}
