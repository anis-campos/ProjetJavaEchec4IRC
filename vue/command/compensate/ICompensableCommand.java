package vue.command.compensate;

import vue.command.generic.ICommand;

/**
 * Created by Anis on 12/05/2016.
 */
public interface ICompensableCommand extends ICommand {
    void compensate();
}
