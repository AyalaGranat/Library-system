package Gui;



import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Author;
import Model.Encyclopedia;
import Model.Library;

public class EncyclopediaAuthors extends JFrame{
	private JList list;

	public EncyclopediaAuthors() {
		String nameOfEncyclopedia=JOptionPane.showInputDialog( "Enter Name of Encyclopedia"); 
		Encyclopedia tempEncyclopedia=Library.getInstance().getEncyclopidea(nameOfEncyclopedia);
		if(tempEncyclopedia==null) {
		JOptionPane.showMessageDialog(getContentPane(), nameOfEncyclopedia+" is not encyclopedia");

		}
		else {
		Set<Author> tempBooks=  Library.getInstance().getEncyclopideaAuthors(tempEncyclopedia);
		list= new JList();
		list.setListData(tempBooks.toArray());					 
		JOptionPane.showMessageDialog(getContentPane(), list);
		}		
		
	}
	

}
