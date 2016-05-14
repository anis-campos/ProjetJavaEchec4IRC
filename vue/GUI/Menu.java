package vue.GUI;

import model.configuration.GameMode;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
/**
 * 
 * @author Antoine
 *
 */

public class Menu{
	private JMenuBar menuBar;
	
	private static int MENU_MODE=0;
	private static int MENU_EDITION=1;
	
	public Menu(){
		initMenu();
	}
	
	private void initMenu(){
		
		//Partie "Mode"
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("Mode");
		JRadioButtonMenuItem rbMenuItem;
		
				
		ButtonGroup group = new ButtonGroup();
		
		GameMode[] moveStrategyValues = GameMode.values(); 
		
		for(int i = 0 ; i < moveStrategyValues.length ; i++){
			rbMenuItem = new JRadioButtonMenuItem(moveStrategyValues[i].toString());
			
			if(i == 0)
				rbMenuItem.setSelected(true);
			
			group.add(rbMenuItem);
			menu.add(rbMenuItem);
		}
		
		menuBar.add(menu);
		
		//Partie "Edition"
		menu = new JMenu("Edition");
		JMenuItem jMenuItem = new JMenuItem("Undo");
		jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		menu.add(jMenuItem);
		
		jMenuItem = new JMenuItem("Redo");
		jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		menu.add(jMenuItem);
		
		menuBar.add(menu);
	}
	
	public JMenuBar getMenuBar(){
		return menuBar;
	}

	public void setListener(ActionListener changeListener, ActionListener editionListener) {
		for(int i = 0 ; i < ((JMenu)menuBar.getMenu(MENU_MODE)).getItemCount() ; i++){
			((JMenu)menuBar.getMenu(MENU_MODE)).getItem(i).addActionListener(changeListener);
		}
		
		for(int i = 0 ; i < ((JMenu)menuBar.getMenu(MENU_EDITION)).getItemCount() ; i++){
			((JMenu)menuBar.getMenu(MENU_EDITION)).getItem(i).addActionListener(editionListener);
		}
	}
}
