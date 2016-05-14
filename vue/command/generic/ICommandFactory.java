package vue.command.generic;

/**
 * Created by Anis on 13/05/2016.
 */
public interface ICommandFactory {

    public <T extends ICommand> T createCommand(Class<T> type, CommandParameters param);
}
