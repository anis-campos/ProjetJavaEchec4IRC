package vue.command.compensate;

import controler.ChessGameControlers;
import model.configuration.GameMode;
import vue.command.generic.CommandParameters;

/**
 * Created by Anis on 14/05/2016.
 */
public class ChangeModeCommand extends AbstractCommand {
    private GameMode modeOld;

    public ChangeModeCommand(ChessGameControlers controlers, CommandParameters parameters) {
        super(controlers, parameters);

    }

    @Override
    public void compensate() {
        controlers.changeMode(modeOld);
    }

    @Override
    public void execute() {
        modeOld = controlers.changeMode(parameters.mode);
    }
}
