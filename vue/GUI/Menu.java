package vue.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.moveStrategy.MoveStrategyType;
import vue.IView;

public class Menu{
	JMenuBar menuBar;
	
	public Menu(){
		initMenu();
	}
	
	private void initMenu(){
		menuBar = new JMenuBar();
		JMenu menuMode = new JMenu("Mode");
		JRadioButtonMenuItem rbMenuItem;
		
				
		ButtonGroup group = new ButtonGroup();
		
		MoveStrategyType[] moveStrategyValues = MoveStrategyType.values(); 
		
		for(int i = 0 ; i < moveStrategyValues.length ; i++){
			rbMenuItem = new JRadioButtonMenuItem(moveStrategyValues[i].toString());
			
			if(i == 0)
				rbMenuItem.setSelected(true);
			
			group.add(rbMenuItem);
			menuMode.add(rbMenuItem);
		}
		
		menuBar.add(menuMode);
	}
	
	public JMenuBar getMenuBar(){
		return menuBar;
	}

	public void setListener(ActionListener changeListener) {
		for(int i = 0 ; i < ((JMenu)menuBar.getMenu(0)).getItemCount() ; i++){
			((JMenu)menuBar.getMenu(0)).getItem(i).addActionListener(changeListener);
		}
	}
}
