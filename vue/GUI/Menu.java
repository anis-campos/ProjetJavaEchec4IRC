package vue.GUI;

import model.configuration.Configurator;
import model.configuration.GameMode;

import javax.swing.*;
import java.awt.event.ActionListener;

class Menu {
    JMenuBar menuBar;


    public Menu() {
        initMenu();
    }

    private void initMenu() {

        menuBar = new JMenuBar();
        JMenu menuMode = new JMenu("Mode");
        JRadioButtonMenuItem rbMenuItem;


        ButtonGroup group = new ButtonGroup();

        for (GameMode mode : GameMode.values()) {
            rbMenuItem = new JRadioButtonMenuItem(mode.toString());
            if (mode == Configurator.getInstance().getMode())
                rbMenuItem.setSelected(true);
            group.add(rbMenuItem);
            menuMode.add(rbMenuItem);
        }


        menuBar.add(menuMode);


        JMenu menuEdition = new JMenu("Edition");
        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");
        menuEdition.add(undoItem);
        menuEdition.add(redoItem);

        undoItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.Event.CTRL_MASK));
        redoItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.Event.CTRL_MASK));

        menuBar.add(menuEdition);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }


    public void setActionModeChange(ActionListener changeListener) {
        for (int i = 0; i < menuBar.getMenu(0).getItemCount(); i++) {
            menuBar.getMenu(0).getItem(i).addActionListener(changeListener);
        }
    }

    public void setActionCommand(ActionListener actionCommand) {
        for (int i = 0; i < menuBar.getMenu(1).getItemCount(); i++) {
            menuBar.getMenu(1).getItem(i).addActionListener(actionCommand);
        }
    }
}
