package vue.viewUpdater;

import model.observe.notification.Notification;
import tools.Introspection2;
import vue.IView;

/**
 * Created by Anis on 29/04/2016.
 */
public class ViewUpdaterCommand<T extends Notification> implements IViewUpdaterCommand {

    private AbstractViewUpdater viewUpdater;

    public ViewUpdaterCommand() {
    }



    @Override
    public void execute(Notification notif, IView view) {


        T notifCasted = null;
        try {
            notifCasted = (T) notif;
        } catch (Exception e) {
            return;
        }


        String nomNotif = notifCasted.getClass().getSimpleName();
        String nom = "vue.viewUpdater." + nomNotif.split("Notification")[0] + "ViewUpdater";

        try {
            viewUpdater = (AbstractViewUpdater) Introspection2.newInstance(nom, notif, view);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        if (viewUpdater != null)
            viewUpdater.run();
    }

}