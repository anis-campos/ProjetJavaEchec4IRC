package vue.command;

import controler.ChessGameControlers;

/**
 * Created by Anis on 12/05/2016.
 */
public abstract class AbstractCommand implements ICompensableCommand {

    protected ChessGameControlers controlers;

    protected CommandParameters parameters;

    public AbstractCommand(ChessGameControlers controlers, CommandParameters parameters) {
        this.controlers = controlers;
        this.parameters = parameters;
    }
}
