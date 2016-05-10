package vue.viewUpdater;

import model.observe.notification.Notification;
import vue.IView;

/**
 * Created by Anis on 09/05/2016.
 */
public abstract class AbstractViewUpdater <K extends Notification> implements Runnable{

    protected K notification;

    protected IView vue;

    public AbstractViewUpdater(K notification, IView vue) {
        this.notification = notification;
        this.vue = vue;
    }

}
