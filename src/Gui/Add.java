package Gui;

import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Model.Author;
import Model.Book;
import Model.Paper;
import Model.Encyclopedia;
import Model.Library;
import Model.LibraryCollection;
import Model.LibraryItem;
import Model.Reader;
import Utils.AcademicBook;
import Utils.BookSize;
import Utils.PaperValue;
import Utils.Topic;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import Exceptions.AuthorAlreadyExistException;
import Exceptions.AuthorNotExistException;
import Exceptions.CollectionAlreadyExistException;
import Exceptions.CollectionNotExistException;
import Exceptions.ReaderAlreadyExistException;
import Exceptions.itemAlreadyExistException;
import Exceptions.itemNotExistException;

import java.awt.GridBagLayout;

public class Add extends JFrame {
	private JTextField textField_nameItem;
	private JTextField textField_id;
	private JTextField textField_pass;
	private JTextField textField_firsna;
	private JTextField textField_lasna;
	private JTextField textField_authorFirstName;
	private JTextField textField_authorLastName;
	private JTextField textField_university;
	private JTextField textField_nameCollection;
	private JLabel lblTopic;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lblId;
	private JLabel lblNewLabel_2;
	private JLabel lblAuthorFirstName;
	private JLabel lblAuthorLastName;
	private JLabel background;
	private List listTopic;
	private List listBookSizeOrPaperValue;
	private List listAcademicBook;
	private JRadioButton rdbtnBookRadio;
	private JRadioButton rdbtnPaperRadio;
	private JRadioButton rdbtnEncyclopediaRadio;
	private JRadioButton rdbtnMagazineRadio;
	private ImageIcon image;
	boolean check=false;


	public Add(String temp ){
		super("ADD");
		getContentPane().setLayout(null);
		listTopic=new List();
		listBookSizeOrPaperValue=new List();
		listAcademicBook=new List();
		lblTopic=new JLabel("topic");
		lbl1=new JLabel();//JLabel to academicBook or paperValue
		lbl2=new JLabel();//JLabel to bookSize or university 
		lblNewLabel_2=new JLabel();
		lblId=new JLabel();
		lblAuthorFirstName=new JLabel();
		lblAuthorLastName=new JLabel();
		textField_nameItem= new JTextField();
		textField_authorFirstName=new JTextField();
		textField_authorLastName=new JTextField();
		textField_university=new JTextField();
		textField_nameCollection= new JTextField();
		textField_id=new JTextField();
		JList list_1 = new JList();
		list_1.setBounds(179, 163, -97, -40);
		getContentPane().add(list_1);
		
		//reader
		if(temp.equals("reader")) {
			
			image=new ImageIcon("reader picture.jfif");
			background=new JLabel("",image,JLabel.CENTER);
			background.setBounds(-68, -35,649,523);
			setContentPane(background);
			

			JLabel lblNewLabel = new JLabel("id");
			lblNewLabel.setBounds(40, 31, 61, 21);
			getContentPane().add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("password");
			lblNewLabel_1.setBounds(39, 75, 76,19);
			getContentPane().add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("first name");
			lblNewLabel_2.setBounds(39, 118, 62, 21);
			getContentPane().add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("last name");
			lblNewLabel_3.setBounds(39, 165, 62, 21);
			getContentPane().add(lblNewLabel_3);

			textField_id = new JTextField();
			textField_id.setBounds(121, 31, 86, 20);
			getContentPane().add(textField_id);
			textField_id.setColumns(10);

			textField_pass = new JTextField();
			textField_pass.setBounds(121, 72, 86, 20);
			getContentPane().add(textField_pass);
			textField_pass.setColumns(10);

			textField_firsna= new JTextField();
			textField_firsna.setBounds(121, 115, 86, 20);
			getContentPane().add(textField_firsna);
			textField_firsna.setColumns(10);

			textField_lasna = new JTextField();
			textField_lasna.setBounds(121, 162, 86, 20);
			getContentPane().add(textField_lasna);
			textField_lasna.setColumns(10);



			JButton btnEnter = new JButton("Enter");
			btnEnter.setBounds(167, 208, 89, 23);
			getContentPane().add(btnEnter);
			btnEnter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(textField_firsna.getText().equals("")||textField_id.getText().equals("")||textField_lasna.getText().equals("")||textField_pass.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
					}else {
					Reader reader= new Reader(textField_firsna.getText(), textField_lasna.getText(), textField_id.getText(), textField_pass.getText());
					try {
						Library.getInstance().addReader(reader);
						JOptionPane.showMessageDialog(getContentPane(),"Reader "+ textField_firsna.getText()+" "+textField_lasna.getText()+ " added successfully");
					} catch (ReaderAlreadyExistException ex) {
						JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
					}
					}
				}
			});



		}

		//author
		else if(temp.equals("author")) {
			image=new ImageIcon("author picture.gif");
			background=new JLabel("",image,JLabel.CENTER);
			background.setBounds(-68, -35,649,523);
			setContentPane(background);
			

			JLabel lblNewLabel_2 = new JLabel("first name");
			lblNewLabel_2.setBounds(39, 50, 62, 21);
			getContentPane().add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("last name");
			lblNewLabel_3.setBounds(39, 100, 62, 21);
			getContentPane().add(lblNewLabel_3);

			textField_firsna= new JTextField();
			textField_firsna.setBounds(121, 50, 86, 20);
			getContentPane().add(textField_firsna);
			textField_firsna.setColumns(10);

			textField_lasna = new JTextField();
			textField_lasna.setBounds(121, 100, 86, 20);
			getContentPane().add(textField_lasna);
			textField_lasna.setColumns(10);
			
			lblTopic.setBounds(39, 150, 76,19);
			getContentPane().add(lblTopic);
			listTopic.setBounds(121, 150, 100, 48);
			getContentPane().add(listTopic);
			populateTopicList(getTopics());

			JButton btnEnter = new JButton("Enter");
			getContentPane().add(btnEnter);
			btnEnter.setBounds(167, 208, 89, 23);
			btnEnter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(textField_firsna.getText().equals("")||textField_lasna.getText().equals("")||stringToTopic(listTopic.getSelectedItem())==null) {
						JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
					}
						else {
					Author author= new Author(textField_firsna.getText(), textField_lasna.getText(),stringToTopic(listTopic.getSelectedItem()) );
					try {
						Library.getInstance().addAuther(author);
						JOptionPane.showMessageDialog(getContentPane(), "Author "+ textField_firsna.getText()+" "+textField_lasna.getText()+ " added successfully");
					} catch (AuthorAlreadyExistException ex) {
						
						JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());
					}
						}	
				}
			});



		}

		else if(temp.equals("item")) {
			image=new ImageIcon("book picture.gif");
			background=new JLabel("",image,JLabel.CENTER);
			background.setBounds(-68, -35,649,523);
			setContentPane(background);
			ButtonGroup radioGroupe;
			rdbtnBookRadio = new JRadioButton("add a Book",false);
			rdbtnPaperRadio = new JRadioButton("add a Paper",false);
			rdbtnBookRadio.setBounds(50, 15, 100, 20);
			rdbtnPaperRadio.setBounds(200, 15, 100, 20);
			getContentPane().add(rdbtnBookRadio,false);
			getContentPane().add(rdbtnPaperRadio, false);
			radioGroupe=new ButtonGroup();
			radioGroupe.add(rdbtnBookRadio);
			radioGroupe.add(rdbtnPaperRadio);
			JButton btnEnter=new JButton("Enter");
			btnEnter.setBounds(270, 280, 89, 23);
			JButton btnEnterselect=new JButton("Enter selected");
			btnEnterselect.setBounds(250, 100, 150, 23);
			getContentPane().add(btnEnterselect);
			JButton btnEnterReturn=new JButton("return to add item");
			btnEnterReturn.setBounds(100, 280, 150, 23);
			Label temtLabel=new Label();
			btnEnterReturn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Add add=new Add("item");
					//add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					add.setSize(450, 350);
					add.setVisible(true);
					setVisible(false);
					
				}
			});
			btnEnterselect.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {		
				
			if(rdbtnBookRadio.isSelected()) {
					if(check==false) {
						check =true; 
						btnEnterselect.setVisible(false);
						rdbtnBookRadio.setVisible(false);
						rdbtnPaperRadio.setVisible(false);
						image=new ImageIcon("paper picture.png");
						background=new JLabel("",image,JLabel.CENTER);
						background.setBounds(-68, -35,649,523);
						setContentPane(background);
						
					temtLabel.setText("Add Book");
					temtLabel.setBounds(150, 20, 100, 20);
					getContentPane().add(temtLabel);
					textField_nameItem.setBounds(200, 50, 100, 20);
					getContentPane().add(textField_nameItem);
					textField_nameItem.setColumns(10);
					lblNewLabel_2 .setText("book name");
					lblNewLabel_2.setBounds(50, 50, 200, 20);
					getContentPane().add(lblNewLabel_2);
					
					lblTopic.setBounds(50,80,50,20);
					getContentPane().add(lblTopic);
					listTopic.setBounds(200, 80, 150, 40);
					getContentPane().add(listTopic);
					populateTopicList(getTopics());
					
					lblAuthorFirstName.setText("author first name");
					lblAuthorFirstName.setBounds(50,130,200,20);
					getContentPane().add(lblAuthorFirstName);
					textField_authorFirstName.setBounds(200, 130, 100, 20);
					getContentPane().add(textField_authorFirstName);
					textField_authorFirstName.setColumns(10);
					
					lblAuthorLastName.setText("author last name");
					lblAuthorLastName.setBounds(50, 170, 200, 20);
					getContentPane().add(lblAuthorLastName);
					textField_authorLastName.setBounds(200, 170, 100, 20);
					getContentPane().add(textField_authorLastName);
				
					lbl1.setText("bookSize");
					lbl1.setBounds(50, 200, 100, 30);
					getContentPane().add(lbl1);
					listBookSizeOrPaperValue.setBounds(200, 200, 150, 30);
					getContentPane().add(listBookSizeOrPaperValue);
					populateBookSizeList(getBookSize());
					
					lbl2.setText("choose Academic Book");
					lbl2.setBounds(50, 240, 150, 20);
					getContentPane().add(lbl2);
					listAcademicBook.setBounds(200, 240, 150, 20);
					listAcademicBook.setVisible(true);
					textField_university.setVisible(false);
					getContentPane().add(listAcademicBook);
					populateAcademicBookList(getAcademicBook());
					getContentPane().add(btnEnter);
					getContentPane().add(btnEnterReturn);
			
					btnEnter.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if((textField_nameItem.getText().equals("")||stringToTopic(listTopic.getSelectedItem())==null||stringToBookSize(listBookSizeOrPaperValue.getSelectedItem())==null)||stringToAcademicBook(listAcademicBook.getSelectedItem())==null||textField_authorFirstName.getText().equals("")||textField_authorLastName.getText().equals("")) {
									JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
								}
								else {
								LibraryItem book= new Book(textField_nameItem.getText(),stringToTopic(listTopic.getSelectedItem()), 
										Library.getInstance().getAuthorByName(textField_authorFirstName.getText(), textField_authorLastName.getText()), 
										stringToBookSize(listBookSizeOrPaperValue.getSelectedItem()), 
										stringToAcademicBook(listAcademicBook.getSelectedItem()));
								Library.getInstance().addItem(book);
								JOptionPane.showMessageDialog(getContentPane(),"Book "+ textField_nameItem.getText()+" added successfully");
							}
							}
							catch(AuthorNotExistException ex) {
								JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());
	
							}
							catch (itemAlreadyExistException ex) {
								JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());
								
							}
						
						}
					});
					
				}
				}
		
			else if(rdbtnPaperRadio.isSelected()) {
					if(check==false) {
						check=true;
						btnEnterselect.setVisible(false);
						rdbtnBookRadio.setVisible(false);
						rdbtnPaperRadio.setVisible(false);
						
						temtLabel.setText("Add Paper");
						temtLabel.setBounds(150, 20, 100, 20);
						getContentPane().add(temtLabel);
						temtLabel.setVisible(true);
						image=new ImageIcon("paper picture.png");
						background=new JLabel("",image,JLabel.CENTER);
						background.setBounds(-68, -35,649,523);
						setContentPane(background);
						
					textField_nameItem.setBounds(200, 50, 100, 20);
					getContentPane().add(textField_nameItem);
					textField_nameItem.setColumns(10);
					lblNewLabel_2 .setText("paper name");
					lblNewLabel_2.setBounds(50, 50, 200, 20);
					getContentPane().add(lblNewLabel_2);
					
					lblTopic.setBounds(50,80,50,20);
					getContentPane().add(lblTopic);
					listTopic.setBounds(200, 80, 150, 40);
					getContentPane().add(listTopic);
					populateTopicList(getTopics());
					
					lblAuthorFirstName.setText("author first name");
					lblAuthorFirstName.setBounds(50,130,200,20);
					getContentPane().add(lblAuthorFirstName);
					textField_authorFirstName.setBounds(200, 130, 100, 20);
					getContentPane().add(textField_authorFirstName);
					textField_authorFirstName.setColumns(10);
					
					lblAuthorLastName.setText("author last name");
					lblAuthorLastName.setBounds(50, 170, 100, 30);
					getContentPane().add(lblAuthorLastName);
					textField_authorLastName.setBounds(200, 170, 100, 20);
					getContentPane().add(textField_authorLastName);
					
					lbl1.setText("paperValue");
					lbl1.setBounds(50, 200, 100, 30);
					getContentPane().add(lbl1);
					listBookSizeOrPaperValue.setBounds(200, 200, 150, 30);
					getContentPane().add(listBookSizeOrPaperValue);
					populatePaperValueList(getPaperValue());
					
					lbl2.setText("university name");
					lbl2.setBounds(50,240,100,20);
					getContentPane().add(lbl2);
					textField_university.setBounds(200, 240, 150, 20);
					textField_university.setVisible(true);
					listAcademicBook.setVisible(false);
					getContentPane().add(textField_university);
					
					getContentPane().add(btnEnter);
					getContentPane().add(btnEnterReturn);
					btnEnter.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							try {
								
									if((textField_nameItem.getText().equals("")||stringToTopic(listTopic.getSelectedItem())==null||textField_university.getText().equals(""))||
											stringToPaperValue(listBookSizeOrPaperValue.getSelectedItem())==null||textField_authorFirstName.getText().equals("")||textField_authorLastName.getText().equals("")) {
										JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
									}
									else {
								LibraryItem paper= new Paper(textField_nameItem.getText(), stringToTopic(listTopic.getSelectedItem()),
										Library.getInstance().getAuthorByName(textField_authorFirstName.getText(), textField_authorLastName.getText()),
										stringToPaperValue(listBookSizeOrPaperValue.getSelectedItem()) , textField_university.getText());
								Library.getInstance().getAuthorByName(textField_authorFirstName.getText(), textField_authorLastName.getText());
								Library.getInstance().addItem(paper);
								JOptionPane.showMessageDialog(getContentPane(),"Paper "+ textField_nameItem.getText()+" added successfully");
							}}
							catch(AuthorNotExistException ex) {
								JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());
								
							}
							catch (itemAlreadyExistException ex) {
								JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());

							}
								
						}
					});

					repaint();
				}
			
				}
				
	
				}
			});
			
		}

		else if(temp.equals("collection")) {
			ButtonGroup radioGroupe;
			rdbtnEncyclopediaRadio = new JRadioButton("add Encyclopedia ",false);
			rdbtnMagazineRadio = new JRadioButton("add magazine ",false);
			rdbtnEncyclopediaRadio.setBounds(50, 10,200, 20);
			rdbtnMagazineRadio.setBounds(250, 10, 200, 20);
			getContentPane().add(rdbtnEncyclopediaRadio,false);
			getContentPane().add(rdbtnMagazineRadio, false);
			radioGroupe=new ButtonGroup();
			radioGroupe.add(rdbtnEncyclopediaRadio);
			radioGroupe.add(rdbtnMagazineRadio);
			JButton btnEnter=new JButton("Enter");
			btnEnter.setBounds(270,200, 89, 23);
			
			JButton btnEnterselect=new JButton("Enter selected");
			btnEnterselect.setBounds(250, 100, 150, 23);
			getContentPane().add(btnEnterselect);
			JButton btnEnterReturn=new JButton("return to add item");
			btnEnterReturn.setBounds(100, 200, 150, 23);
			Label temtLabel=new Label();
			temtLabel.setBounds(150, 20, 120, 20);
			getContentPane().add(temtLabel);
			temtLabel.setVisible(true);
			btnEnterReturn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Add add=new Add("collection");
			//		add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					add.setSize(450, 350);
					add.setVisible(true);
					setVisible(false);
					
				}
			});
			
			btnEnterselect.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {		
				
			if(rdbtnEncyclopediaRadio.isSelected()) {
					if(check==false) {
						check =true; 	
						btnEnterselect.setVisible(false);
						rdbtnEncyclopediaRadio.setVisible(false);
						rdbtnMagazineRadio.setVisible(false);
						image=new ImageIcon("encyclopedia picture.jpg");
						background=new JLabel("",image,JLabel.CENTER);
						background.setBounds(-68, -35,649,523);
						setContentPane(background);
						
						
						textField_nameCollection.setBounds(250, 50, 100, 20);
						getContentPane().add(textField_nameCollection);
						textField_nameCollection.setColumns(10);
						lblNewLabel_2 .setText("Encyclopedia name");
						lblNewLabel_2.setForeground(Color.white);
						lblNewLabel_2.setBounds(100, 50, 200, 20);
						getContentPane().add(lblNewLabel_2);
						
						
						
						lblId.setText("Encyclopedia id");
						lblId.setBounds(100,100,200,20);
						lblId.setForeground(Color.white);
						getContentPane().add(lblId);
						textField_id.setBounds(250, 100, 100, 20);
						getContentPane().add(textField_id);
						textField_id.setColumns(10);
						
						getContentPane().add(btnEnter);
						getContentPane().add(btnEnterReturn);
					
			
					btnEnter.addActionListener(new  ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if(textField_nameCollection.getText().equals("")||textField_id.getText().equals("")){
									JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
								}
								else {
									LibraryCollection enc= new Model.Encyclopedia(textField_nameCollection.getText(),Integer.parseInt(textField_id.getText()));
									Library.getInstance().addCollection(enc);
									JOptionPane.showMessageDialog(getContentPane(),"Encyclopedia "+ textField_nameCollection.getText()+" added successfully");
						}
							}
							catch(CollectionAlreadyExistException ex) {
								JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
								
							}
							catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(getContentPane(), "The input in Encyclopedia Id field is not a number");
								
							}
						
						}
					});
					
				}
				}
		
			else if(rdbtnMagazineRadio.isSelected()) {
					if(check==false) {
						check=true;
						btnEnterselect.setVisible(false);
						rdbtnEncyclopediaRadio.setVisible(false);
						rdbtnMagazineRadio.setVisible(false);
						getContentPane().add(temtLabel);
						image=new ImageIcon("magazine picture.jpg");
						background=new JLabel("",image,JLabel.CENTER);
						background.setBounds(-68, -35,649,523);
						setContentPane(background);
						
						textField_nameCollection.setBounds(200, 100, 100, 20);
						getContentPane().add(textField_nameCollection);
						textField_nameCollection.setColumns(10);
						lblNewLabel_2 .setText("Magaizne name");
						lblNewLabel_2.setForeground(Color.white);
						lblNewLabel_2.setBounds(110, 100, 200, 20);
						getContentPane().add(lblNewLabel_2);
							
						lblId.setText("Magazine id");
						lblId.setBounds(110,140,200,20);
						lblId.setForeground(Color.white);
						getContentPane().add(lblId);
						textField_id.setBounds(200, 140, 100, 20);
						getContentPane().add(textField_id);
						textField_id.setColumns(10);
					
					
					getContentPane().add(btnEnter);
					getContentPane().add(btnEnterReturn);
					
					btnEnter.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							try {
								
								if(textField_nameCollection.getText().equals("")||textField_id.getText().equals("")) {
									JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
									}
								else {
									LibraryCollection mag= new Model.Magazine(textField_nameCollection
											.getText(), Integer.parseInt(textField_id.getText()));
									Library.getInstance().addCollection(mag);
									JOptionPane.showMessageDialog(getContentPane(),"Magazine "+ textField_nameCollection.getText()+" added successfully");
							}}
							catch (CollectionAlreadyExistException ex) {
								
								JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
						
							}
							catch  (NumberFormatException e2) {
								JOptionPane.showMessageDialog(getContentPane(), "The input in magazine Id field is not a number");
								
							}
								
						}
					});

					repaint();
				}
			
				}
				
	
				}
			});
			
		}
		
		
		else if(temp.equals("itemToCollection")) {
			image=new ImageIcon("picture.jpg");
			background=new JLabel("",image,JLabel.CENTER);
			background.setBounds(-68, -35,649,523);
			setContentPane(background);
			JLabel lblNameCol=new JLabel("Collection Name");
			JLabel lblNameIt=new JLabel("Item name");
			
			lblNameCol.setBounds(100, 50, 100, 20);
			getContentPane().add(lblNameCol);
			textField_nameCollection.setBounds(200, 50, 100, 20);
			getContentPane().add(textField_nameCollection);
			textField_nameCollection.setColumns(10);
			
			lblNameIt.setBounds(100, 100, 100, 20);
			getContentPane().add(lblNameIt);
			textField_nameItem.setBounds(200, 100, 100, 20);
			getContentPane().add(textField_nameItem);
			textField_nameItem.setColumns(10);
			
			JButton btnEnter=new JButton("Enter");
			btnEnter.setBounds(150, 150, 90, 20);
			getContentPane().add(btnEnter);
			btnEnter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						LibraryCollection enc=Library.getInstance().getEncyclopidea(textField_nameCollection.getText());
						LibraryCollection mag=Library.getInstance().getMagazine(textField_nameCollection.getText());
						LibraryItem item = Library.getInstance().getItemByName(textField_nameItem.getText());
						if(enc!=null && item instanceof Book) {
							Library.getInstance().addCollectionItem(enc, item);
							JOptionPane.showMessageDialog(getContentPane(), "Book " +textField_nameItem.getText()+" added successfully to encyclopedia "+textField_nameCollection.getText());
						}
						else if(mag!=null && item instanceof Paper) {
							Library.getInstance().addCollectionItem(mag, item);
							JOptionPane.showMessageDialog(getContentPane(), "Paper " +textField_nameItem.getText()+" added successfully to magazine "+textField_nameCollection.getText());
						}
						else if(enc!=null && item instanceof Paper) {
							JOptionPane.showMessageDialog(getContentPane(), textField_nameItem.getText()+" is not Book");
						}
						else if(mag!=null && item instanceof Book) {
							JOptionPane.showMessageDialog(getContentPane(), textField_nameItem.getText()+" is not paper");
						}
						
						
					} 
					catch (itemNotExistException ex) {
						JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
					}
				
			
					
				}
			});
		
						
			
			
			
			
		}
		
		

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
	public static ArrayList<String> getBookSize() {
		ArrayList<String> toReturn = new ArrayList<String>();
		for(BookSize bookSize : BookSize.values())
			toReturn.add(bookSize.name());
		return toReturn;
	}
	
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
	}
	
	private ArrayList<String> getAcademicBook() {
		ArrayList<String> toReturn = new ArrayList<String>();
		for(AcademicBook academicBook : AcademicBook.values())
			toReturn.add(academicBook.name());
		return toReturn;
	}
	
	private void populateAcademicBookList(ArrayList<String> academicBooks) {
		academicBooks.forEach(academicBook -> {
			listAcademicBook.add(academicBook);
		});
	}
	
	private AcademicBook stringToAcademicBook(String name) {
		for(AcademicBook academicBook:AcademicBook.values()) {
			if(academicBook.name().equals(name)) {
				return academicBook;
			}
		}
		return null;
	}
	
	private ArrayList<String> getPaperValue() {
		ArrayList<String> toReturn = new ArrayList<String>();
		for(PaperValue paperValue : PaperValue.values())
			toReturn.add(paperValue.name());
		return toReturn;
	}
	
	private void populatePaperValueList(ArrayList<String> paperValues) {
		listBookSizeOrPaperValue.removeAll();
		paperValues.forEach(paperValue -> {
			listBookSizeOrPaperValue.add(paperValue);
		});
	}
	
	private PaperValue stringToPaperValue(String name) {
		for(PaperValue paperValue:PaperValue.values()) {
			if(paperValue.name().equals(name)) {
				return paperValue;
			}
		}
		return null;
	}
}
