package Gui;


import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Exceptions.AuthorNotExistException;
import Exceptions.itemNotExistException;
import Model.ArithmeticMean;
import Model.Author;
import Model.GeometricMean;
import Model.HarmonicMean;
import Model.Library;
import Utils.Topic;




	public class AuthorKbestBookOrPaper  extends JFrame{

			private JRadioButton arRadioButton;
			private JRadioButton geoRadioButton;
			private JRadioButton haRadioButton;
			private ButtonGroup radGroup;
			private JLabel kItems;
			private TextField textField_kItems;
			private JLabel lblAuthorFirstName;
			private JLabel lblAuthorLastName;
			private JTextField textField_authorFirstName;
			private JTextField textField_authorLastName;
			private JList list;
			

			public AuthorKbestBookOrPaper(String temp)  {
				super("AuthorKbestBookOrPaper");
				
				getContentPane().setLayout(null);
				radGroup=new ButtonGroup();
				arRadioButton=new JRadioButton("arithmeticMean",false);
				geoRadioButton=new JRadioButton("geometricMean",false);
				haRadioButton=new JRadioButton("harmonicMean",false);
				lblAuthorFirstName=new JLabel();
				lblAuthorLastName=new JLabel();
				textField_authorFirstName= new JTextField();
				textField_authorLastName=new JTextField();
				kItems=new JLabel("number of items");
				textField_kItems=new TextField();
				arRadioButton.setBounds(50, 100, 150, 20);
				geoRadioButton.setBounds(50, 150, 150,20);
				haRadioButton.setBounds(50, 200, 150, 20);
				kItems.setBounds(47, 24, 100, 20);
				textField_kItems.setBounds(174, 24, 100, 20);
				textField_kItems.setColumns(3);
				lblAuthorFirstName.setText("author first name");
				lblAuthorFirstName.setBounds(47,50,200,20);
				getContentPane().add(lblAuthorFirstName);
				textField_authorFirstName.setBounds(174, 50, 100, 20);
				getContentPane().add(textField_authorFirstName);
				textField_authorFirstName.setColumns(10);
				lblAuthorLastName.setText("author last name");
				lblAuthorLastName.setBounds(47, 73, 200, 20);
				getContentPane().add(lblAuthorLastName);
				textField_authorLastName.setBounds(174, 73, 100, 20);
				getContentPane().add(textField_authorLastName);
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
							Author tempauthor=Library.getInstance().getAuthorByName(textField_authorFirstName.getText(), textField_authorLastName.getText()); 
							if(textField_kItems.getText().equals("")) {
								JOptionPane.showMessageDialog(getContentPane(), "write number of items");
							}	
							else if(temp.equals("book")) {
								list= new JList();
								list.setListData(Library.getInstance().getBestAuthorBooks(tempauthor,Integer.parseInt(textField_kItems.getText()), arithmeticMean).toArray());					 
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
							else if(temp.equals("paper")) {
								list= new JList();
								list.setListData(Library.getInstance().getBestAuthorPapers(tempauthor,Integer.parseInt(textField_kItems.getText()), arithmeticMean).toArray());					 
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
							
						}
						catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
						}
						catch (AuthorNotExistException e2) {
							JOptionPane.showMessageDialog(getContentPane(),"author " +textField_authorFirstName.getText()+" "+textField_authorLastName.getText()+" does not exists");
						}
											
					}
				});

				geoRadioButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							GeometricMean geometricMean=new GeometricMean();
							Author tempauthor=Library.getInstance().getAuthorByName(textField_authorFirstName.getText(), textField_authorLastName.getText()); 
							
							if(textField_kItems.getText().equals("")) {
								JOptionPane.showMessageDialog(getContentPane(), "write number of items");
							}
							
								
							else if(temp.equals("book")) {
								list= new JList();
								list.setListData(Library.getInstance().getBestAuthorBooks(tempauthor,Integer.parseInt(textField_kItems.getText()), geometricMean).toArray());					 
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
							else if(temp.equals("paper")) {
								list= new JList();
								list.setListData( Library.getInstance().getBestAuthorPapers(tempauthor,Integer.parseInt(textField_kItems.getText()), geometricMean).toArray());					 
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
							
						}
						catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
						}
						catch (AuthorNotExistException e2) {
							JOptionPane.showMessageDialog(getContentPane(),"author" +textField_authorFirstName.getText()+textField_authorLastName.getText()+"does not exists");
						}
											
					}
				});
				haRadioButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							HarmonicMean harmonicMean=new HarmonicMean();
							Author tempauthor=Library.getInstance().getAuthorByName(textField_authorFirstName.getText(), textField_authorLastName.getText()); 
							
							if(textField_kItems.getText().equals("")) {
								JOptionPane.showMessageDialog(getContentPane(), "write number of items");
							}
							
								
							else if(temp.equals("book")) {
								list= new JList();
								list.setListData( Library.getInstance().getBestAuthorBooks(tempauthor,Integer.parseInt(textField_kItems.getText()), harmonicMean).toArray());					 
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
							else if(temp.equals("paper")) {
								list= new JList();
								list.setListData(Library.getInstance().getBestAuthorPapers(tempauthor,Integer.parseInt(textField_kItems.getText()), harmonicMean).toArray());					 
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
							
						}
						catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
						}
						catch (AuthorNotExistException e2) {
							JOptionPane.showMessageDialog(getContentPane(),"author" +textField_authorFirstName.getText()+textField_authorLastName.getText()+"does not exists");
						}
											
					}
				});

				

			}

			

		

		}



