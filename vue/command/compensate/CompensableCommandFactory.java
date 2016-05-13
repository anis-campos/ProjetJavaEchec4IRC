package vue.command.compensate;

import controler.ChessGameControlers;
import tools.Introspection2;
import vue.command.generic.CommandParameters;
import vue.command.generic.ICommand;
import vue.command.generic.ICommandFactory;

/**
 * Created by Anis on 13/05/2016.
 */
public class CompensableCommandFactory implements ICommandFactory {

    ChessGameControlers controlers;

    public CompensableCommandFactory(ChessGameControlers controlers) {
        this.controlers = controlers;
    }

    @Override
    public <T extends ICommand> T createCommand(Class<T> type, CommandParameters param) {
        if (type != null) {
            String nomClasse = type.getName();
            try {
                return (T) Introspection2.newInstance(nomClasse, controlers, param);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
