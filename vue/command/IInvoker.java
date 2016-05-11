package vue.command;

/**
 * Created by Anis on 11/05/2016.
 */
public interface IInvoker {
    void addCommand(ICommand command);

    void doCommand();

    void undoCommand();

    void redoCommand();
}
