package vue.command;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anis on 11/05/2016.
 */
public class CommandList {

    private List<ICommand> pile;

    private Iterator<ICommand> pointeur;


    public CommandList() {
        pile = new LinkedList<>();
    }

    public void add(ICommand c) {

        pile.add(c);

    }


}
