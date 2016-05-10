package vue.viewUpdater;

import model.observe.notification.IllegalMoveNotification;
import vue.IView;

/**
 * Created by Anis on 09/05/2016.
 */
public class IllegalMoveViewUpdater extends AbstractViewUpdater<IllegalMoveNotification> {


    public IllegalMoveViewUpdater(IllegalMoveNotification notification, IView vue) {
        super(notification, vue);
    }

    @Override
    public void run() {
        vue.display(notification.etatJeu);
    }
}
