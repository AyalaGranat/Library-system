package Gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Model.Library;
import Model.Magazine;
import Model.Paper;

public class PapersByMagazine extends JFrame { 
	private JList list;
	public PapersByMagazine()  {
		String nameOfMagazine=JOptionPane.showInputDialog("Enter Name of Magazine" ); 
		Magazine tempMagazine = Library.getInstance().getMagazine(nameOfMagazine);
		if(tempMagazine==null) {
			JOptionPane.showMessageDialog(getContentPane(), nameOfMagazine+" is not magazine");
		}
		else {
			ArrayList<Paper> tempMagPapers=  Library.getInstance().getMagazinePapers(tempMagazine); 
			list= new JList();
			list.setListData(tempMagPapers.toArray());					 
			JOptionPane.showMessageDialog(getContentPane(), list);
		}



	}


}
