package vue.viewUpdater;

import model.observe.notification.HighlightNotification;
import vue.IView;

/**
 * Created by Anis on 10/05/2016.
 */
public class HighlightViewUpdater extends AbstractViewUpdater<HighlightNotification> {

    public HighlightViewUpdater(HighlightNotification notification, IView vue) {
        super(notification, vue);
    }

    @Override
    public void run() {
        vue.highlight(notification.patern);
    }
}
