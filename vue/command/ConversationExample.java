package vue.command;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anis on 11/05/2016.
 */
public class ConversationExample {


    public interface Conversation<C extends ICommand> {
        void exec(C cmd);

        void undo();

        void redo();
    }


    public interface CompensableCommand extends ICommand {
        void compensate();
    }

    /**
     * @param <C> Type of executed commands
     * @param <S> Type of stored state (commands or mementos)
     */
    public abstract class AbstractConversation<C extends ICommand, S> implements Conversation<C> {
        protected final Stack<S> undos, redos;

        public AbstractConversation() {
            this.undos = new Stack<S>();
            this.redos = new Stack<S>();
        }
    }

    public class Stack<T> {

        //Delegate to avoid exposing too many Deque methods
        private final Deque<T> stack = new LinkedList<>();

        /**
         * @return null if stack is empty
         */
        public T pop() {
            return stack.pollLast(); //Not using pop since it throws NoSuchElementException if the deque is empty
        }

        public void push(T cmd) {
            stack.addLast(cmd);
        }

        public void clear() {
            stack.clear();
        }


    }

    public class CompensationConversation extends AbstractConversation<CompensableCommand, CompensableCommand> {

        @Override
        public void exec(CompensableCommand todo) {
            todo.execute();
            undos.push(todo);
            redos.clear();
        }

        @Override
        public void undo() {
            CompensableCommand latestCmd = undos.pop();
            if (latestCmd == null) return;
            latestCmd.compensate();
            redos.push(latestCmd);
        }

        @Override
        public void redo() {
            CompensableCommand latestCmd = redos.pop();
            if (latestCmd == null) return;
            latestCmd.execute();
            undos.push(latestCmd);
        }
    }


    public class Macro implements ICommand {

        private final List<ICommand> parts;

        public Macro(List<ICommand> parts) {
            this.parts = parts;
        }

        @Override
        public void execute() {
            for (ICommand c : parts) {
                c.execute();
            }
        }
    }


}
