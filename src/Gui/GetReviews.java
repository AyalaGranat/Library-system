package Gui;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Exceptions.itemNotExistException;
import Model.Author;
import Model.Library;
import Model.LibraryItem;
import Model.Magazine;
import Model.Review;
import Utils.BookSize;



public class GetReviews  extends JFrame{
	JList list;
	public GetReviews() {
		super("reviews");
		
		
		System.out.println();
		String nameOfItem=JOptionPane.showInputDialog( "Enter Name of Magazine" );
		try {
		LibraryItem item= Library.getInstance().getItemByName(nameOfItem);
		System.out.println(item);
		System.out.println(item.getReviews());
		
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(500, 500);
			setVisible(true);
			getContentPane().setLayout(null);

			list = new JList(getGetReviewsbyname(item).toArray());
			System.out.println(list);
			list.setBounds(112, 128, 100,100);
			list.setVisible(true);
			list.setVisibleRowCount(5);
		    list.add(new JScrollPane() );         
			add(list);
		}
		catch (itemNotExistException e) {
			JOptionPane.showMessageDialog(getContentPane(), "no item");
		}
	}

	public  ArrayList getGetReviewsbyname(LibraryItem item) {
		ArrayList<String> toReturn = new ArrayList<String>();
		for(Review re : item.getReviews())
			toReturn.add(re.getReaderFirstName()+""+re.getReaderLaststName());
		System.out.println(item.getReviews());
		System.out.println(toReturn);
		return toReturn;
	}
	/*
	private void populateBookSizeList(ArrayList<String> bookSizes) {
		listBookSizeOrPaperValue.removeAll();
		bookSizes.forEach(bookSize -> {
			listBookSizeOrPaperValue.add(bookSize);
		});
	}
	
	private BookSize stringToBookSize(String name) {
		for(BookSize bookSize:BookSize.values()) {
			if(bookSize.name().equals(name)) {
				return bookSize;
			}
		}
		return null;
	}*/
}
