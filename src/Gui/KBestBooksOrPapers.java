package Gui;



import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Exceptions.itemNotExistException;
import Model.ArithmeticMean;
import Model.GeometricMean;
import Model.HarmonicMean;
import Model.Library;

public class KBestBooksOrPapers extends JFrame {
	private JRadioButton arRadioButton;
	private JRadioButton geoRadioButton;
	private JRadioButton haRadioButton;
	private ButtonGroup radGroup;
	private JLabel kItems;
	private TextField textField_kItems;
	JList list;

	public KBestBooksOrPapers(String temp)  {
		super("kBestbooksOrPapers");
		
		getContentPane().setLayout(null);
		radGroup=new ButtonGroup();
		arRadioButton=new JRadioButton("arithmeticMean",false);
		geoRadioButton=new JRadioButton("geometricMean",false);
		haRadioButton=new JRadioButton("harmonicMean",false);
		kItems=new JLabel("number of items");
		textField_kItems=new TextField();
		arRadioButton.setBounds(50, 100, 150, 20);
		geoRadioButton.setBounds(50, 150, 150,20);
		haRadioButton.setBounds(50, 200, 150, 20);
		kItems.setBounds(25, 50, 100, 20);
		textField_kItems.setBounds(150, 50, 100, 20);
		textField_kItems.setColumns(3);
		getContentPane().add(kItems);
		getContentPane().add(textField_kItems);
		getContentPane().add(arRadioButton);
		getContentPane().add(geoRadioButton);
		getContentPane().add(haRadioButton);
		radGroup.add(arRadioButton);
		radGroup.add(geoRadioButton);
		radGroup.add(haRadioButton);
		
		arRadioButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				  try {
					ArithmeticMean arithmeticMean=new ArithmeticMean();
					if(textField_kItems.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "write number of items");
					}
					else if(temp.equals("book")) {
						list= new JList();
						list.setListData(Library.getInstance().getBestBooks(Integer.parseInt(textField_kItems.getText()), arithmeticMean).toArray());					 
						JOptionPane.showMessageDialog(getContentPane(), list);
					}
					else if(temp.equals("paper")) {
						list= new JList();
						list.setListData(Library.getInstance().getBestPapers(Integer.parseInt(textField_kItems.getText()), arithmeticMean).toArray());					 
						JOptionPane.showMessageDialog(getContentPane(), list);
					}
				  }
				  catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
					}
			}
		});

		geoRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					GeometricMean geometricMean=new GeometricMean();
					if(textField_kItems.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "write number of items");
					}
					else if(temp.equals("book")) {
						list= new JList();
						list.setListData(Library.getInstance().getBestBooks(Integer.parseInt(textField_kItems.getText()), geometricMean).toArray());					 
						JOptionPane.showMessageDialog(getContentPane(), list);
						
					}
					else if(temp.equals("paper")) {
						list= new JList();
						list.setListData(Library.getInstance().getBestPapers(Integer.parseInt(textField_kItems.getText()), geometricMean).toArray());					 
						JOptionPane.showMessageDialog(getContentPane(), list);
					}

			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
			}
			}
		});
		haRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
					HarmonicMean harmonicMean=new HarmonicMean();
					if(textField_kItems.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "write number of items");
					}
					else if(temp.equals("book")) {
						list= new JList();
						list.setListData( Library.getInstance().getBestBooks(Integer.parseInt(textField_kItems.getText()), harmonicMean).toArray());					 
						JOptionPane.showMessageDialog(getContentPane(), list);
					}
					else if(temp.equals("paper")) {
						list= new JList();
						list.setListData(Library.getInstance().getBestPapers(Integer.parseInt(textField_kItems.getText()), harmonicMean).toArray());					 
						JOptionPane.showMessageDialog(getContentPane(), list);
					}
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
				}
			}
		});



	}

	

}
