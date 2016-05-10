package vue.viewUpdater;

import model.observe.notification.IllegalMoveNotification;
import model.observe.notification.MoveNotification;
import model.observe.notification.Notification;
import model.observe.notification.StartNotification;

import java.util.HashMap;

/**
 * Created by Anis on 09/05/2016.
 */
public class ViewUpdaterFactory {

    public static HashMap<Class<? extends Notification>, IViewUpdater> mapping() {

        HashMap<Class<? extends Notification>, IViewUpdater> map = new HashMap<>();

        //TODO : Utiliser une boucle pour parcourir toute les Notification
        map.put(MoveNotification.class, new ViewUpdater<MoveNotification>());
        map.put(StartNotification.class, new ViewUpdater<StartNotification>());
        map.put(IllegalMoveNotification.class, new ViewUpdater<IllegalMoveNotification>());

        return map;
    }

}
