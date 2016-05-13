package vue.command.compensate;

import controler.ChessGameControlers;
import vue.command.generic.CommandParameters;

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
