package vue.command.generic;

/**
 * Created by Anis on 11/05/2016.
 */
public interface IInvoker<C extends ICommand> {

    void exec(C cmd);

    void undo();

    void redo();
}
