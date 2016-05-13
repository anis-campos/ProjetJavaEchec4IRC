package vue.GUI;

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

        GameMode[] moveStrategyValues = GameMode.values();

        for (int i = 0; i < moveStrategyValues.length; i++) {
            rbMenuItem = new JRadioButtonMenuItem(moveStrategyValues[i].toString());

            if (i == 0)
                rbMenuItem.setSelected(true);

            group.add(rbMenuItem);
            menuMode.add(rbMenuItem);
        }

        menuBar.add(menuMode);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setListener(ActionListener changeListener) {
        for (int i = 0; i < menuBar.getMenu(0).getItemCount(); i++) {
            menuBar.getMenu(0).getItem(i).addActionListener(changeListener);
        }
    }
}
