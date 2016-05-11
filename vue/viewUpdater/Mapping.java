package vue.viewUpdater;

import model.observe.notification.Notification;

import java.util.HashMap;

/**
 * Created by Anis on 11/05/2016.
 */
public class Mapping {


    private HashMap<Class<? extends Notification>, IViewUpdater> map;

    public Mapping() {
        map = new HashMap<>();
    }

    public void setBinding(Class<? extends Notification> notificationType, IViewUpdater viewUpdater){
        map.put(notificationType,viewUpdater);
    }

    public IViewUpdater getViewUpdater(Class<? extends Notification> notificationType){
        if(map.containsKey(notificationType)){
            return map.get(notificationType);
        }
        return null;
    }
}
