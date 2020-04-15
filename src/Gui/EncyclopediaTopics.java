package Gui;

import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Encyclopedia;
import Model.Library;
import Utils.Topic;

public class EncyclopediaTopics extends JFrame {
	private JList list;

	public EncyclopediaTopics() {
		String nameOfEncyclopedia=JOptionPane.showInputDialog( "Enter Name of Encyclopedia"); 
		Encyclopedia tempEncyclopedia=Library.getInstance().getEncyclopidea(nameOfEncyclopedia);
		if(tempEncyclopedia==null) {
		JOptionPane.showMessageDialog(getContentPane(), nameOfEncyclopedia+" is not encyclopedia");

		}
		else {
		Set<Topic> tempBooks=  Library.getInstance().getEncyclopideaTopics(tempEncyclopedia); 
		list= new JList();
		list.setListData(tempBooks.toArray());	
		System.out.println(list);
		JOptionPane.showMessageDialog(getContentPane(), list);
		}		
	
	}

}
