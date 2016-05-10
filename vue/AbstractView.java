package vue;

import controler.ChessGameControlers;
import model.observe.IObserver;
import model.observe.notification.Notification;
import vue.viewUpdater.IViewUpdater;
import vue.viewUpdater.ViewUpdaterFactory;

import java.util.HashMap;

/**
 * Created by Anis on 29/04/2016.
 */
public abstract class AbstractView implements IObserver, IView {

    private HashMap<Class<? extends Notification>, IViewUpdater> map;

    protected ChessGameControlers chessGameControler;

    public AbstractView(ChessGameControlers chessGameControler) {
        this.chessGameControler = chessGameControler;
        map = ViewUpdaterFactory.mapping();

    }

    @Override
    public final void update(Notification notif) {

        IViewUpdater updater = map.get(notif.getClass());
        if (updater != null){
            updater.execute(notif, this);
            System.out.println("Notification recu : " + notif.getClass().getSimpleName());
            System.out.println("\t Init : " + notif.cInit + " - Final : "+notif.cFinal);
        }
        else
            System.out.println("Notification non gérée : " + notif.getClass().getSimpleName());
    }


}
