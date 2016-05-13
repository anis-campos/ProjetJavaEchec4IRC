package vue.command;

import java.util.List;

/**
 * Created by Anis on 12/05/2016.
 */
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
