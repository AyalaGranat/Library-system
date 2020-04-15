package Gui;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import Model.Library;
import Model.Reader;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import Controller.MainClass;

import javax.swing.JPasswordField;

public final class Login extends JFrame implements Serializable{
	
	private JTextField textField;
	private JLabel lblWelcomeToLibrary;
	private JLabel background;
	private JButton btnEnter;
	private JButton btnEnter1;
	private JPasswordField passwordField;
	private JButton btnNew;
	static Library librarySys;
	private ImageIcon image;
	private static final long serialVersionUID = 1L;
	public static Library libr;
	
	public Login(){
		getContentPane().setLayout(null);
		image=new ImageIcon("library picture.jpg");
		background=new JLabel("",image,JLabel.CENTER);
		background.setBounds(-68, -35,649,523);
		setContentPane(background);
		lblWelcomeToLibrary = new JLabel("Welcome to Library ");
		lblWelcomeToLibrary.setForeground(Color.white);
		lblWelcomeToLibrary.setBounds(125, 35, 179, 25);
		lblWelcomeToLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToLibrary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblWelcomeToLibrary);
		
		JLabel lblPleaseEnterId = new JLabel("please enter ID");
		lblPleaseEnterId.setForeground(Color.white);
		lblPleaseEnterId.setBounds(93, 108, 110, 14);
		getContentPane().add(lblPleaseEnterId);
		
		
		textField = new JTextField();
		textField.setBounds(254, 105, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseEnterPassword = new JLabel("please enter password ");
		lblPleaseEnterPassword.setForeground(Color.white);
		lblPleaseEnterPassword.setBounds(93, 149, 151, 14);
		getContentPane().add(lblPleaseEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 146, 86, 20);
		passwordField.setColumns(10);
		getContentPane().add(passwordField);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(197, 177, 79, 23);
		getContentPane().add(btnEnter);
		
	
		
		
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String paAdmin= "ADMIN";
			String paLib="LIBRIAN";
				
				if (textField.getText().equals("ADMIN") && paAdmin.equals(new String(passwordField.getPassword()))){
					
					
					UserGui guiuGui= new UserGui(textField.getText());
					setDefaultCloseOperation(guiuGui.EXIT_ON_CLOSE);
					guiuGui.setSize(500, 500);
					guiuGui.setVisible(true);
					setVisible(false);
					
				//	repaint();
					
					
				}	
				else if (textField.getText().equals("LIBRIAN") && paLib.equals(new String(passwordField.getPassword()))) {
					
					
					UserGui guiuGui= new UserGui(textField.getText());
					guiuGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					guiuGui.setSize(500, 500);
					guiuGui.setVisible(true);
					setVisible(false);

				}
				else {
					boolean in=true;
					Reader tempReader;
					for (Reader re: Library.getInstance().getReaders()) {
						if(re.getId().equals(textField.getText())&&re.getPassword().equals(new String(passwordField.getPassword()))) {
							in=false;
							tempReader= re;
							UserGui guiuGui= new UserGui(re.getFirstName()+" "+ re.getLastName());
							guiuGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							guiuGui.setSize(500, 500);
							guiuGui.setVisible(true);
							setVisible(false);
						}
					}
					if(in) {
						JOptionPane.showMessageDialog(getContentPane(), "incorrect Id or Password, please try again");
					}
				}
			}});

	}

	

	
    
	
	
    public JTextField getTextField() {
		return textField;
	}



	public void setTextField(JTextField textField) {
		this.textField = textField;
	}



	public JLabel getLblWelcomeToLibrary() {
		return lblWelcomeToLibrary;
	}



	public void setLblWelcomeToLibrary(JLabel lblWelcomeToLibrary) {
		this.lblWelcomeToLibrary = lblWelcomeToLibrary;
	}



	public JButton getBtnEnter() {
		return btnEnter;
	}



	public void setBtnEnter(JButton btnEnter) {
		this.btnEnter = btnEnter;
	}



	public JButton getBtnEnter1() {
		return btnEnter1;
	}



	public void setBtnEnter1(JButton btnEnter1) {
		this.btnEnter1 = btnEnter1;
	}



	public JPasswordField getPasswordField() {
		return passwordField;
	}



	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}



	

	
	
	
	
}
