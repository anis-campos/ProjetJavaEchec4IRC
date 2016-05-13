package vue.command;

import controler.ChessGameControlers;

/**
 * Created by Anis on 12/05/2016.
 */
public class MoveCommand extends AbstractCommand {


    public MoveCommand(ChessGameControlers controlers, CommandParameters parameters) {
        super(controlers, parameters);
    }

    @Override
    public void compensate() {
        controlers.undoMove(parameters.cInit, parameters.cFinal);
    }

    @Override
    public void execute() {
        controlers.move(parameters.cInit, parameters.cFinal);
    }
}
