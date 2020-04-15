package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Reader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Exceptions.ReaderNotExistException;
import Exceptions.itemNotExistException;
import Model.Library;
import Model.LibraryItem;

public class ReadItem extends JFrame{
	private JLabel readerFirastName;
	private JLabel readerLastName;
	private JLabel itemName;
	private JLabel text;
	private JTextField textField_readerFirstName;
	private JTextField textField_readerLastName;
	private JTextField textField_itemName;
	private JButton btnEnter;
	JPanel jPanel;
	

	public ReadItem()  {
	
		super("read item");
		getContentPane().setLayout(new FlowLayout());
		text= new JLabel("Please Enter first name,last name,  and item name");
		
		getContentPane().add(text,BorderLayout.NORTH);
		jPanel=new JPanel();
		jPanel.setLayout(new GridLayout(3,1,5,5));
		getContentPane().add(jPanel,BorderLayout.CENTER);
		
		readerFirastName=new JLabel("reader first name");
		readerFirastName.setBounds(40, 30,150 ,20);
		jPanel.add(readerFirastName);
		textField_readerFirstName=new JTextField();
		textField_readerFirstName.setBounds(170,30,100, 20);
		jPanel.add(textField_readerFirstName);
		textField_readerFirstName.setColumns(10);
		
		readerLastName=new JLabel("reader last name");
		readerLastName.setBounds(40,70, 150, 20);
		jPanel.add(readerLastName);
		textField_readerLastName=new JTextField();
		textField_readerLastName.setBounds(170, 70,100, 20);
		jPanel.add(textField_readerLastName);
		textField_readerLastName.setColumns(10);
		
		itemName=new JLabel("item name");
		itemName.setBounds(40, 120,150, 20);
		jPanel.add(itemName);
		textField_itemName=new JTextField();
		textField_itemName.setBounds(170, 120, 100, 20);
		jPanel.add(textField_itemName);
		textField_itemName.setColumns(10);
		
		btnEnter=new JButton("Enter");
		getContentPane().add(btnEnter);
		btnEnter.setBounds(150, 190, 100, 20);
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						Reader reader= Library.getInstance().getReaderByName(textField_readerFirstName.getText(), textField_readerLastName.getText());
						LibraryItem item=Library.getInstance().getItemByName(textField_itemName.getText());
						Library.getInstance().readItem(reader, item);
						JOptionPane.showMessageDialog(getContentPane(),"Reader "+ textField_readerFirstName.getText()+
								" "+textField_readerLastName.getText()+ " read "+textField_itemName.getText());
					} catch (ReaderNotExistException ex) {
						JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
					} catch (itemNotExistException ex) {
						JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
					}
				
				
			}
		});
		
		
	}
	public ReadItem(String firstname, String lastname)  {
		super("read item");
		getContentPane().setLayout(new FlowLayout());
		text= new JLabel("You can add item to your list");
		getContentPane().add(text,BorderLayout.NORTH);
		jPanel=new JPanel();
		jPanel.setLayout(new GridLayout(3,1,5,5));
		getContentPane().add(jPanel,BorderLayout.CENTER);
		
		readerFirastName=new JLabel("reader first name");
		readerFirastName.setBounds(40, 30,150 ,20);
		jPanel.add(readerFirastName);
		textField_readerFirstName=new JTextField(firstname);
		textField_readerFirstName.setEditable(false);
		textField_readerFirstName.setBounds(170,30,100, 20);
		jPanel.add(textField_readerFirstName);
		textField_readerFirstName.setColumns(10);
		
		readerLastName=new JLabel("reader last name");
		readerLastName.setBounds(40,70, 150, 20);
		jPanel.add(readerLastName);
		textField_readerLastName=new JTextField(lastname);
		textField_readerLastName.setEditable(false);
		textField_readerLastName.setBounds(170, 70,100, 20);
		jPanel.add(textField_readerLastName);
		textField_readerLastName.setColumns(10);
		
		itemName=new JLabel("item name");
		itemName.setBounds(40, 120,150, 20);
		jPanel.add(itemName);
		textField_itemName=new JTextField();
		textField_itemName.setBounds(170, 120, 100, 20);
		jPanel.add(textField_itemName);
		textField_itemName.setColumns(10);
		
		btnEnter=new JButton("Enter");
		getContentPane().add(btnEnter);
		btnEnter.setBounds(150, 190, 100, 20);
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						Reader reader= Library.getInstance().getReaderByName(firstname, lastname);
						LibraryItem item=Library.getInstance().getItemByName(textField_itemName.getText());
						Library.getInstance().readItem(reader, item);
						JOptionPane.showMessageDialog(getContentPane(),"Hii "+ firstname+
								" "+lastname+ " the item "+textField_itemName.getText()+" add to your list");
					} catch (ReaderNotExistException ex) {
						JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
					} catch (itemNotExistException ex) {
						JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
					}
				
				
			}
		});
	}
}

