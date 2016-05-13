package vue.command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Anis on 12/05/2016.
 */
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
