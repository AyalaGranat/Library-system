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

import Exceptions.itemNotExistException;
import Model.ArithmeticMean;
import Model.GeometricMean;
import Model.HarmonicMean;
import Model.Library;
import Utils.Topic;

public class bestKTopicBookOrPaper  extends JFrame{


		private JRadioButton arRadioButton;
		private JRadioButton geoRadioButton;
		private JRadioButton haRadioButton;
		private ButtonGroup radGroup;
		private JLabel kItems;
		private TextField textField_kItems;
		private List listTopic;
		private JLabel lblTopic;
		private JList list;

		public bestKTopicBookOrPaper(String temp)  {
			super("bestKTopicBookOrPaper");
			
			getContentPane().setLayout(null);
			radGroup=new ButtonGroup();
			lblTopic=new JLabel("topic");
			listTopic=new List();
			lblTopic.setBounds(50, 50, 100, 20);
			listTopic.setBounds(174, 54, 100, 40);
			getContentPane().add(lblTopic);
			getContentPane().add(listTopic);
			arRadioButton=new JRadioButton("arithmeticMean",false);
			geoRadioButton=new JRadioButton("geometricMean",false);
			haRadioButton=new JRadioButton("harmonicMean",false);
			kItems=new JLabel("number of items");
			textField_kItems=new TextField();
			populateTopicList(getTopics());
			arRadioButton.setBounds(50, 100, 150, 20);
			geoRadioButton.setBounds(50, 150, 150,20);
			haRadioButton.setBounds(50, 200, 150, 20);
			kItems.setBounds(50, 24, 100, 20);
			textField_kItems.setBounds(174, 24, 100, 20);
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
						Topic tempTopic=stringToTopic(listTopic.getSelectedItem());
						
						if(textField_kItems.getText().equals("")) {
							JOptionPane.showMessageDialog(getContentPane(), "write number of items");
						}
						else if(tempTopic==null){	
							JOptionPane.showMessageDialog(getContentPane(), "please choose a topic");
						}
							
						else if(temp.equals("book")) {
							list= new JList();
							list.setListData(Library.getInstance().getBestTopicBooks(tempTopic,Integer.parseInt(textField_kItems.getText()), arithmeticMean).toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}
						else if(temp.equals("paper")) {
							list= new JList();
							list.setListData(Library.getInstance().getBestTopicPapers(tempTopic,Integer.parseInt(textField_kItems.getText()), arithmeticMean).toArray());					 
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
						Topic tempTopic=stringToTopic(listTopic.getSelectedItem());
						if(textField_kItems.getText().equals("")) {
							JOptionPane.showMessageDialog(getContentPane(), "write number of items");
						}
						else if(tempTopic==null){	
							JOptionPane.showMessageDialog(getContentPane(), "please choose a topic");
						}
							
						else if(temp.equals("book")) {
							list= new JList();
							list.setListData(Library.getInstance().getBestTopicBooks(tempTopic,Integer.parseInt(textField_kItems.getText()), geometricMean).toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}
						else if(temp.equals("paper")) {
							list= new JList();
							list.setListData(Library.getInstance().getBestTopicPapers(tempTopic,Integer.parseInt(textField_kItems.getText()), geometricMean).toArray());					 
							JOptionPane.showMessageDialog(getContentPane(), list);
						}
						
					}
					catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
					}
										
				}
			});
			haRadioButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						HarmonicMean harmonicMean=new HarmonicMean();
						Topic tempTopic=stringToTopic(listTopic.getSelectedItem());
						
						if(textField_kItems.getText().equals("")) {
							JOptionPane.showMessageDialog(getContentPane(), "write number of items");
						}
						else if(tempTopic==null){	
							JOptionPane.showMessageDialog(getContentPane(), "please choose a topic");
						}
							
						else if(temp.equals("book")) {
							list= new JList();
							list.setListData( Library.getInstance().getBestTopicBooks(tempTopic,Integer.parseInt(textField_kItems.getText()), harmonicMean).toArray());
							if(list.getModel().getSize()==0) {
								JOptionPane.showMessageDialog(getContentPane(), " is not book with this topic");
							}
							else {
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
						}
						else if(temp.equals("paper")) {
							list= new JList();
							list.setListData( Library.getInstance().getBestTopicPapers(tempTopic,Integer.parseInt(textField_kItems.getText()), harmonicMean).toArray());
							if(list.getModel().getSize()==0) {
								JOptionPane.showMessageDialog(getContentPane(), " is not paper with this topic");
							}
							else {
								JOptionPane.showMessageDialog(getContentPane(), list);
							}
						}
						
					}
					catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
					}
										
				}
			});

			

		}

		

		
		public  ArrayList<String> getTopics() {
			ArrayList<String> toReturn = new ArrayList<String>();
			for(Topic topic : Topic.values())
				toReturn.add(topic.name());
			return toReturn;
		}
		
		public  void populateTopicList(ArrayList<String> topics) {
			topics.forEach(topic -> {
				listTopic.add(topic);
			});
		}
		
		public static Topic stringToTopic(String name) {
			for(Topic topic:Topic.values()) {
				if(topic.name().equals(name)) {
					return topic;
				}
			}
			return null;
		}

	}

