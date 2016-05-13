package vue.viewUpdater;

import model.observe.notification.*;
import vue.IView;

/**
 * Created by Anis on 12/05/2016.
 */
public class ViewUpdaterManager {
    private static ViewUpdaterManager ourInstance = new ViewUpdaterManager();
    private final Mapping mapping;

    private ViewUpdaterManager() {

        mapping = new Mapping();

        //TODO : Utiliser une boucle pour parcourir toute les Notification
        mapping.setBinding(MoveNotification.class, new ViewUpdaterCommand<MoveNotification>());
        mapping.setBinding(StartNotification.class, new ViewUpdaterCommand<StartNotification>());
        mapping.setBinding(IllegalMoveNotification.class, new ViewUpdaterCommand<IllegalMoveNotification>());
        mapping.setBinding(HighlightNotification.class, new ViewUpdaterCommand<HighlightNotification>());


    }

    public static ViewUpdaterManager getInstance() {
        return ourInstance;
    }

    public void invokeViewUpdater(Notification notif, IView view) {

        IViewUpdaterCommand updater = mapping.getViewUpdater(notif.getClass());
        if (updater != null) {
            updater.execute(notif, view);
            System.out.println("Notification recu : " + notif.getClass().getSimpleName());
            System.out.println("\t Init : " + notif.cInit + " - Final : " + notif.cFinal);
        } else
            System.out.println("Notification non gérée : " + notif.getClass().getSimpleName());
    }


}
