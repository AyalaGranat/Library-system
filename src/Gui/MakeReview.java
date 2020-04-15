package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonReadableChannelException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Exceptions.ReaderNotExistException;
import Exceptions.itemNotExistException;
import Model.Author;
import Model.Book;
import Model.Library;
import Model.LibraryItem;
import Model.Reader;
import Model.Review;
import Utils.AcademicBook;
import Utils.BookSize;
import Utils.Topic;

public class MakeReview extends JFrame {
	

	private JTextField textField_itemName;
	private JTextField textField_revSen;
	private JTextField textField_firsna;
	private JTextField textField_lasna;
	private JTextField textField_grade;
	private ImageIcon image;
	private JLabel background;
	JLabel lblNewLabel_5;
	//שינוי
	JButton choosepicButton;
	private Icon pIcon;
	JLabel picJLabel;
	String pathString;
	
	
	public MakeReview(){
		super("Add review");
		image=new ImageIcon("review picture.png");
		background=new JLabel("",image,JLabel.LEFT);
		background.setBounds(0, 0,649,523);
		setContentPane(background);
		//שינוי
		pIcon=new ImageIcon("no_pic2.PNG");
		picJLabel= new JLabel(pIcon);
		getContentPane().add(picJLabel);
		picJLabel.setBounds(270, 30, 110, 110);
	
	

		lblNewLabel_5 = new JLabel("please enter review");
		lblNewLabel_5.setBounds(122, 6, 169, 14);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reader First Name");
		lblNewLabel.setBounds(40, 31, 150, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reader Last Name");
		lblNewLabel_1.setBounds(39, 75, 150,21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name");
		lblNewLabel_2.setBounds(39, 118, 150,19);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Review Sentence");
		lblNewLabel_3.setBounds(40, 145, 150, 19);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4=new JLabel("garde");
		lblNewLabel_4.setBounds(39, 200, 150, 21);
		getContentPane().add(lblNewLabel_4);
		
		
		textField_firsna = new JTextField();
		textField_firsna.setBounds(170, 31, 86, 20);
		getContentPane().add(textField_firsna);
		textField_firsna.setColumns(10);
		
		textField_lasna = new JTextField();
		textField_lasna.setBounds(170, 72, 86, 20);
		getContentPane().add(textField_lasna);
		textField_lasna.setColumns(10);
		
		textField_itemName= new JTextField();
		textField_itemName.setBounds(170, 115, 86, 20);
		getContentPane().add(textField_itemName);
		textField_itemName.setColumns(10);
		
		textField_revSen = new JTextField();
		textField_revSen.setVisible(true);
		textField_revSen.setBounds(170, 148, 150, 41);
		getContentPane().add(textField_revSen);
		//textField_revSen.setColumns(30);
		
		textField_grade=new JTextField();
		textField_grade.setBounds(170,200,86,20);
		getContentPane().add(textField_grade);
		textField_grade.setColumns(10);
// שינוי
		choosepicButton=new JButton("add picture to review");
		getContentPane().add(choosepicButton);
		choosepicButton.setBounds(40,227, 200, 23);
		choosepicButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
			
				 JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG & GIF Images", "jpg", "gif");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(getParent());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	pathString= chooser.getSelectedFile().getPath();
				       System.out.println("You chose to open this file: " +
				            chooser.getSelectedFile().getName());
				       System.out.println(pathString);
				       Icon newicopIcon=new ImageIcon(pathString);
				       picJLabel.setIcon(newicopIcon);
				       picJLabel.setVisible(true);
				       getContentPane().add(picJLabel);
				       picJLabel.setBounds(270, 30, 110, 110);
				       
				    }
					
			}
		});
	
	JButton btnEnter = new JButton("Add Review");
	btnEnter.setBounds(250,227, 100, 23);
	getContentPane().add(btnEnter);
	
	getContentPane().add(lblNewLabel_5);
	btnEnter.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(textField_firsna.getText().equals("")||textField_lasna.getText().equals("")||textField_itemName.getText().equals("")||textField_grade.getText().equals("")){
				JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
			}
			else {
				
			try {
				Review review= new Review(textField_firsna.getText(),textField_lasna.getText(), textField_itemName.getText(), textField_revSen.getText(), Integer.parseInt(textField_grade.getText()),pathString);
				Library.getInstance().getReaderByName(textField_firsna.getText(), textField_lasna.getText());
				LibraryItem libItem=Library.getInstance().getItemByName(textField_itemName.getText()); 
				Library.getInstance().makeReview(libItem, review);
				JOptionPane.showMessageDialog(getContentPane(),"Reader "+ textField_firsna.getText()+" "+textField_lasna.getText()+
						" added review to" +" "+textField_itemName.getText());
			} 
			catch(ReaderNotExistException ex){
				JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
			}
			catch (itemNotExistException ex) {
				JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());
				
			}
			catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(getContentPane(), "The input in grade field is not a number");
			}
			
			}
		}
	});
	
	}
	
	public MakeReview(String firstname, String lastname){
		super("Add review");
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Reader First Name");
		lblNewLabel.setBounds(40, 31, 150, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reader Last Name");
		lblNewLabel_1.setBounds(39, 75, 150,21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name");
		lblNewLabel_2.setBounds(39, 118, 150,19);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Review Sentence");
		lblNewLabel_3.setBounds(39, 165, 150, 19);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4=new JLabel("garde");
		lblNewLabel_4.setBounds(39, 200, 150, 21);
		getContentPane().add(lblNewLabel_4);
		
		
		textField_firsna = new JTextField(firstname);
		textField_firsna.setBounds(170, 31, 86, 20);
		getContentPane().add(textField_firsna);
		textField_firsna.setColumns(10);
		textField_firsna.setEditable(false);
		
		textField_lasna = new JTextField(lastname);
		textField_lasna.setBounds(170, 72, 86, 20);
		getContentPane().add(textField_lasna);
		textField_lasna.setColumns(10);
		textField_lasna.setEditable(false);
		
		textField_itemName= new JTextField();
		textField_itemName.setBounds(170, 115, 86, 20);
		getContentPane().add(textField_itemName);
		textField_itemName.setColumns(10);
		
		
		textField_revSen = new JTextField();
		textField_revSen.setVisible(true);
		textField_revSen.setBounds(170, 148, 150, 41);
		getContentPane().add(textField_revSen);
		
		textField_grade=new JTextField();
		textField_grade.setBounds(170,200,86,20);
		getContentPane().add(textField_grade);
		textField_grade.setColumns(10);

		lblNewLabel_5 = new JLabel("please enter review");
		lblNewLabel_5.setBounds(122, 6, 169, 14);
		getContentPane().add(lblNewLabel_5);
		
		
	JButton btnEnter = new JButton("Enter");
	btnEnter.setBounds(200,240, 89, 23);
	getContentPane().add(btnEnter);
	btnEnter.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(textField_itemName.getText().equals("")||textField_grade.getText().equals("")){
				JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
			}
			else {
				
			try {
				Review review= new Review(firstname,lastname, lastname, textField_revSen.getText(), Integer.parseInt(textField_grade.getText()),pathString);
				Library.getInstance().getReaderByName(firstname, textField_lasna.getText());
				LibraryItem libItem=Library.getInstance().getItemByName(textField_itemName.getText()); 
				Library.getInstance().makeReview(libItem, review);
				JOptionPane.showMessageDialog(getContentPane(),"Reader "+ textField_firsna.getText()+" "+textField_lasna.getText()+
						" added review to" +" "+textField_itemName.getText());
			} 
			catch(ReaderNotExistException ex){
				JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
			}
			catch (itemNotExistException ex) {
				JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());
				
			}
			catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(getContentPane(), "The input in grade field is not a number");
			}
			
			}
		}
	});

		
		
		
		
		
	}
}
