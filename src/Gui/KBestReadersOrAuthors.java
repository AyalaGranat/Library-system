package Gui;

import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Model.Library;

public class KBestReadersOrAuthors extends JFrame {
	private JLabel kUsers;
	private TextField textField_kUsers;
	private JButton btnEnter;
	JList list;

	public KBestReadersOrAuthors(String temp)  {
		super("kBestAuthorsOrReaders");
		getContentPane().setLayout(null);
		kUsers=new JLabel("number of users");
		textField_kUsers=new TextField();
		btnEnter=new JButton("Enter");
		kUsers.setBounds(25, 50, 100, 20);
		textField_kUsers.setBounds(150, 50, 100, 20);
		textField_kUsers.setColumns(3);
		getContentPane().add(kUsers);
		getContentPane().add(textField_kUsers);
		btnEnter.setBounds(100, 100, 100, 20);
		getContentPane().add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				if(textField_kUsers.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "write number of users");
				}
				else if(temp.equals("reader")) {
					list= new JList();
					list.setListData(Library.getInstance().getBestReaders(Integer.parseInt(textField_kUsers.getText())).toArray());		
					JOptionPane.showMessageDialog(getContentPane(), list);
				}
				else if(temp.equals("author")) {
					list= new JList();
					list.setListData(Library.getInstance().getBestAuthors(Integer.parseInt(textField_kUsers.getText())).toArray());					 
					JOptionPane.showMessageDialog(getContentPane(), list);
				}
				
			}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
				}
			}
		});

	
		
	}

}
