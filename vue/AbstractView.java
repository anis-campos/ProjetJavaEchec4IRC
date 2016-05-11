package vue;

import controler.ChessGameControlers;
import model.observe.IObserver;
import model.observe.notification.Notification;
import vue.viewUpdater.ViewUpdaterInvoker;

/**
 * Created by Anis on 29/04/2016.
 */
public abstract class AbstractView implements IObserver, IView {



    protected ChessGameControlers chessGameControler;

    public AbstractView(ChessGameControlers chessGameControler) {
        this.chessGameControler = chessGameControler;
    }

    @Override
    public final void update(Notification notif) {

        ViewUpdaterInvoker.getInstance().invokeViewUpdater(notif, this);
    }


}
