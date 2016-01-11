package design;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import io.github.algorys.agshmne.inventory.InventoryItem;

public class InvRenderer extends JLabel implements ListCellRenderer { 
	  
		public Component getListCellRendererComponent( 
			JList<InventoryItem> list, 
			InventoryItem item,            // value to display 
			int index,               // cell index 
			boolean isSelected,      // is the cell selected 
			boolean cellHasFocus)    // the list and the cell have the focus 
		{ 
			setText(item.toString()); 
	  
			if (isSelected) { 
				setBackground(list.getSelectionBackground()); 
				setForeground(list.getSelectionForeground()); 
			} 
			else { 
				setBackground(list.getBackground()); 
				setForeground(list.getForeground()); 
			} 
	  
			// Ici, il faut tester si on veut changer la couleur et changer par la  
			// couleur de notre choix 
			if (item.getName() == "Pomme"){ 
				setBackground(Color.GREEN); 
			} 
	  
			setEnabled(list.isEnabled()); 
			setFont(list.getFont()); 
			setOpaque(true); 
			return this; 
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			return null;
		} 
	}