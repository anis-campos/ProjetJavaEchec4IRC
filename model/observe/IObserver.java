package model.observe;

import model.observe.notification.Notification;

/**
 * Created by Anis on 29/04/2016.
 */
public interface IObserver {
    void update(Notification notif);
}
