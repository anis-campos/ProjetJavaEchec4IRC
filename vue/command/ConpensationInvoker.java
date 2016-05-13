package vue.command;

/**
 * Created by Anis on 12/05/2016.
 */
public class ConpensationInvoker extends AbstractInvoker<ICompensableCommand, ICompensableCommand> {

    @Override
    public void exec(ICompensableCommand todo) {
        todo.execute();
        undos.push(todo);
        redos.clear();
    }

    @Override
    public void undo() {
        ICompensableCommand latestCmd = undos.pop();
        if (latestCmd == null) return;
        latestCmd.compensate();
        redos.push(latestCmd);
    }

    @Override
    public void redo() {
        ICompensableCommand latestCmd = redos.pop();
        if (latestCmd == null) return;
        latestCmd.execute();
        undos.push(latestCmd);
    }
}
