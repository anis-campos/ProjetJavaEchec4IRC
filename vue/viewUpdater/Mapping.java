package vue.viewUpdater;

import model.observe.notification.Notification;

import java.util.HashMap;

/**
 * Created by Anis on 11/05/2016.
 */
public class Mapping {


    private HashMap<Class<? extends Notification>, IViewUpdaterCommand> map;

    public Mapping() {
        map = new HashMap<>();
    }

    public void setBinding(Class<? extends Notification> notificationType, IViewUpdaterCommand viewUpdater) {
        map.put(notificationType,viewUpdater);
    }

    public IViewUpdaterCommand getViewUpdater(Class<? extends Notification> notificationType) {
        if(map.containsKey(notificationType)){
            return map.get(notificationType);
        }
        return null;
    }
}
