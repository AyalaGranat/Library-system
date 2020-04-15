package Gui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Book;
import Model.Encyclopedia;
import Model.Library;

public class BooksByEncyclopedia extends JFrame {
	private JList list;

	public BooksByEncyclopedia()  {
		String nameOfEncyclopedia=JOptionPane.showInputDialog( "Enter Name of Encyclopedia"); 
		Encyclopedia tempEncyclopedia=Library.getInstance().getEncyclopidea(nameOfEncyclopedia);
		if(tempEncyclopedia==null) {
		JOptionPane.showMessageDialog(getContentPane(), nameOfEncyclopedia+" is not encyclopedia");

		}
		else {
		ArrayList<Book> tempBooks= Library.getInstance().getEncyclopideaBooks(tempEncyclopedia); 
		list= new JList();
		list.setListData(tempBooks.toArray());					 
		JOptionPane.showMessageDialog(getContentPane(), list);
		}
	}

}
