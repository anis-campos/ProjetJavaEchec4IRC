package vue.viewUpdater;

import model.observe.notification.MoveNotification;
import vue.IView;

/**
 * Created by Anis on 29/04/2016.
 */
public class MoveViewUpdater extends AbstractViewUpdater<MoveNotification> {


    public MoveViewUpdater(MoveNotification notification, IView view) {
        super(notification, view);
    }


    @Override
    public void run() {
        this.vue.display(this.notification.etatJeu);
    }
}