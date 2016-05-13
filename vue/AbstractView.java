package vue;

import controler.ChessGameControlers;
import model.observe.IObserver;
import model.observe.notification.Notification;
import vue.viewUpdater.ViewUpdaterManager;

/**
 * Created by Anis on 29/04/2016.
 */
public abstract class AbstractView implements IObserver, IView {


    protected ChessGameControlers chessGameControler;
    private ViewUpdaterManager invoker;

    public AbstractView(ChessGameControlers chessGameControler) {
        this.chessGameControler = chessGameControler;
        invoker = ViewUpdaterManager.getInstance();
    }

    @Override
    public final void update(Notification notif) {

        invoker.invokeViewUpdater(notif, this);
    }


}
