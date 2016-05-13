package vue.command;

/**
 * Created by Anis on 11/05/2016.
 */
public abstract class AbstractInvoker<C extends ICommand, S> implements IInvoker<C> {

    protected final Stack<S> undos, redos;

    public AbstractInvoker() {
        this.undos = new Stack<S>();
        this.redos = new Stack<S>();
    }

}
