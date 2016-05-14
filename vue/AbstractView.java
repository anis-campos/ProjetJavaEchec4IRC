package vue;

import controler.ChessGameControlers;
import model.observe.IObserver;
import model.observe.notification.Notification;
import vue.command.compensate.CompensableCommandFactory;
import vue.command.compensate.ConpensationInvoker;
import vue.viewUpdater.ViewUpdaterManager;

/**
 * Created by Anis on 29/04/2016.
 */
public abstract class AbstractView implements IObserver, IView {


    protected final ChessGameControlers chessGameControler;
    protected final ConpensationInvoker invoker;
    private final ViewUpdaterManager viewUpdaterManager;
    protected final CompensableCommandFactory factory;

    public AbstractView(ChessGameControlers chessGameControler) {
        this.chessGameControler = chessGameControler;
        this.viewUpdaterManager = ViewUpdaterManager.getInstance();
        this.invoker = new ConpensationInvoker();
        this.factory = new CompensableCommandFactory(chessGameControler);
    }

    @Override
    public final void update(Notification notif) {

        viewUpdaterManager.invokeViewUpdater(notif, this);
    }


}
