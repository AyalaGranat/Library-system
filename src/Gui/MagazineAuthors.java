package Gui;

import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Author;
import Model.Library;
import Model.Magazine;

public class MagazineAuthors extends JFrame {
	private JList list;

	public MagazineAuthors() {
		String nameOfMagazine=JOptionPane.showInputDialog( "Enter Name of Magazine" ); 
		Magazine tempMagazine = Library.getInstance().getMagazine(nameOfMagazine);
		if(tempMagazine==null) {
			JOptionPane.showMessageDialog(getContentPane(), nameOfMagazine+" is not magazine");
		}
		else {
			Set<Author> tempMagPapers=   Library.getInstance().getMagazineAuthors(tempMagazine); 
			list= new JList();
			list.setListData(tempMagPapers.toArray());					 
			JOptionPane.showMessageDialog(getContentPane(), list);
		}
	}

}
