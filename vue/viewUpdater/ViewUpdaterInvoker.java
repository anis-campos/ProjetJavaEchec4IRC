package vue.viewUpdater;

import model.observe.notification.*;
import vue.IView;

/**
 * Created by Anis on 12/05/2016.
 */
public class ViewUpdaterInvoker {
    private static ViewUpdaterInvoker ourInstance = new ViewUpdaterInvoker();
    private final Mapping mapping;

    public static ViewUpdaterInvoker getInstance() {
        return ourInstance;
    }

    private ViewUpdaterInvoker() {

        mapping = new Mapping();

        //TODO : Utiliser une boucle pour parcourir toute les Notification
        mapping.setBinding(MoveNotification.class, new ViewUpdater<MoveNotification>());
        mapping.setBinding(StartNotification.class, new ViewUpdater<StartNotification>());
        mapping.setBinding(IllegalMoveNotification.class, new ViewUpdater<IllegalMoveNotification>());
        mapping.setBinding(HighlightNotification.class, new ViewUpdater<HighlightNotification>());


    }


    public void invokeViewUpdater(Notification notif, IView view) {

        IViewUpdater updater = mapping.getViewUpdater(notif.getClass());
        if (updater != null) {
            updater.execute(notif, view);
            System.out.println("Notification recu : " + notif.getClass().getSimpleName());
            System.out.println("\t Init : " + notif.cInit + " - Final : " + notif.cFinal);
        } else
            System.out.println("Notification non gérée : " + notif.getClass().getSimpleName());
    }


}
