package vue.viewUpdater;

import model.observe.notification.StartNotification;
import vue.IView;

/**
 * Created by Anis on 09/05/2016.
 */
public class StartViewUpdater extends AbstractViewUpdater<StartNotification> {

    public StartViewUpdater(StartNotification notification, IView vue) {
        super(notification, vue);
    }

    @Override
    public void run() {
        vue.display(notification.etatJeu);
        vue.start();
    }
}
