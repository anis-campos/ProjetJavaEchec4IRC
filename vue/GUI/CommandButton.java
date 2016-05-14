package vue.GUI;

import vue.command.generic.ICommand;

import javax.swing.*;

/**
 * Created by Anis on 13/05/2016.
 */
public class CommandButton extends AbstractButton {

    private ICommand command;

    public CommandButton(ICommand command) {
        this.command = command;
    }

    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }
}

