package Gui;


import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Library;
import Model.Magazine;
import Utils.Topic;

public class MagazineTopics extends JFrame{
	private JList list;

	public MagazineTopics()  {
		String nameOfMagazine=JOptionPane.showInputDialog( "Enter Name of Magazine" ); 
		Magazine tempMagazine = Library.getInstance().getMagazine(nameOfMagazine);
		if(tempMagazine==null) {
			JOptionPane.showMessageDialog(getContentPane(), nameOfMagazine+" is not magazine");
		}
		else {
			Set<Topic> tempMagPapers= Library.getInstance().getMagazineTopics(tempMagazine); 
			list= new JList();
			list.setListData(tempMagPapers.toArray());					 
			JOptionPane.showMessageDialog(getContentPane(), list);
		}
		
		
	}
	

}
