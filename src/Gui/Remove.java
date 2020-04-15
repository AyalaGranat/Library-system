package Gui;


import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Exceptions.AuthorNotExistException;
import Exceptions.CollectionNotExistException;
import Exceptions.ReaderAlreadyExistException;
import Exceptions.ReaderNotExistException;
import Exceptions.itemNotExistException;
import Model.Author;
import Model.Encyclopedia;
import Model.Library;
import Model.LibraryCollection;
import Model.LibraryItem;
import Model.Magazine;
import Model.Reader;

public class Remove extends JFrame {
	private JTextField textField_id;
	private JTextField textField_pass;
	private JTextField textField_firsna;
	private JTextField textField_lasna;
	private List list_2;
	private JRadioButton rdbtnMagazineRadio;
	private JRadioButton rdbtnEncyRadio;
	private JButton btnEnter;

	public Remove(String temp) {
		super("Remove");
		getContentPane().setLayout(null);
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(167, 208, 89, 23);
		getContentPane().add(btnEnter);


		if(temp.equals("reader")) {
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



			btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}});



			btnEnter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(textField_firsna.getText().equals("")||textField_id.getText().equals("")|| textField_lasna.getText().equals("")||textField_pass.getText().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
					}
					else {
						Reader reader= new Reader(textField_firsna.getText(), textField_lasna.getText(), textField_id.getText(), textField_pass.getText());
						try {// שיניתי
							Library.getInstance().removeReader(reader);
							JOptionPane.showMessageDialog(getContentPane(),"Reader "+ textField_firsna.getText()+" "+textField_lasna.getText()+ " remove successfully");
						} catch (ReaderNotExistException e1) {
							//הוספתי
							JOptionPane.showMessageDialog(getContentPane(),e1.getMessage());

						}

					}
				}
			});

		}


		else if(temp.equals("author")) {


			JLabel lblNewLabel_2 = new JLabel("first name");
			lblNewLabel_2.setBounds(39, 118, 62, 21);
			getContentPane().add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("last name");
			lblNewLabel_3.setBounds(39, 165, 62, 21);
			getContentPane().add(lblNewLabel_3);

			textField_firsna= new JTextField();
			textField_firsna.setBounds(121, 115, 86, 20);
			getContentPane().add(textField_firsna);
			textField_firsna.setColumns(10);

			textField_lasna = new JTextField();
			textField_lasna.setBounds(121, 162, 86, 20);
			getContentPane().add(textField_lasna);
			textField_lasna.setColumns(10);

			btnEnter.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if(textField_firsna.getText().equals("")|| textField_lasna.getText().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
					}
					else {

						Author author= new Author (textField_firsna.getText(), textField_lasna.getText());
						try {
							Library.getInstance().removeAuthor(author);
							JOptionPane.showMessageDialog(getContentPane(),"Author "+ textField_firsna.getText()+" "+textField_lasna.getText()+ " remove successfully");
						} catch (AuthorNotExistException e1) {

							JOptionPane.showMessageDialog(getContentPane(),e1.getMessage());
						}
					}
				}
			});

		}
		else if(temp.equals("author")) {


			JLabel lblNewLabel_2 = new JLabel("first name");
			lblNewLabel_2.setBounds(39, 118, 62, 21);
			getContentPane().add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("last name");
			lblNewLabel_3.setBounds(39, 165, 62, 21);
			getContentPane().add(lblNewLabel_3);

			textField_firsna= new JTextField();
			textField_firsna.setBounds(121, 115, 86, 20);
			getContentPane().add(textField_firsna);
			textField_firsna.setColumns(10);

			textField_lasna = new JTextField();
			textField_lasna.setBounds(121, 162, 86, 20);
			getContentPane().add(textField_lasna);
			textField_lasna.setColumns(10);

			btnEnter.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if(textField_firsna.getText().equals("")|| textField_lasna.getText().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
					}
					else {

						Author author= new Author (textField_firsna.getText(), textField_lasna.getText());
						try {
							Library.getInstance().removeAuthor(author);
							JOptionPane.showMessageDialog(getContentPane(),"Author "+ textField_firsna.getText()+" "+textField_lasna.getText()+ " remove successfully");
						} catch (AuthorNotExistException e1) {

							JOptionPane.showMessageDialog(getContentPane(),e1.getMessage());
						}
					}
				}
			});

		}


		else if(temp.equals("item")) {

			JLabel lblNewLabel_2 = new JLabel("Enter item Name to remove:");
			lblNewLabel_2.setBounds(39, 50,200, 21);
			getContentPane().add(lblNewLabel_2);


			textField_firsna= new JTextField();
			textField_firsna.setBounds(121, 100, 150, 20);
			getContentPane().add(textField_firsna);
			textField_firsna.setColumns(10);



			btnEnter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(textField_firsna.getText().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), "One  the field is empty");
					}
					else {
						try {
							LibraryItem tempitem=Library.getInstance().getItemByName(textField_firsna.getText());
							Library.getInstance().removeItem(tempitem);
							JOptionPane.showMessageDialog(getContentPane(),"item "+ textField_firsna.getText()+" is remove successfully");
						} catch ( itemNotExistException ex) {

							JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());

						}
					}
				}});


		}

		else if(temp.equals("collection")) {

			ButtonGroup radioGroupe;
			rdbtnMagazineRadio = new JRadioButton("Remove a Magazine",false);
			rdbtnEncyRadio = new JRadioButton("Remove a Encyclopedia",false);
			rdbtnMagazineRadio.setBounds(200, 50, 150, 20);
			rdbtnEncyRadio.setBounds(20, 50, 200, 20);
			getContentPane().add(rdbtnEncyRadio, false);
			getContentPane().add(rdbtnMagazineRadio,false);
			radioGroupe=new ButtonGroup();
			radioGroupe.add(rdbtnEncyRadio);
			radioGroupe.add(rdbtnMagazineRadio);

			btnEnter.setVisible(false);

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
					Remove add=new Remove("collection");
					add.setSize(450, 350);
					add.setVisible(true);
					setVisible(false);

				}
			});

			btnEnterselect.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if( rdbtnMagazineRadio.isSelected()) {

						btnEnterselect.setVisible(false);
						rdbtnEncyRadio.setVisible(false);
						rdbtnMagazineRadio.setVisible(false);


						JLabel lblNewLabel_2 = new JLabel("Enter Name Collection to remove:");
						lblNewLabel_2.setBounds(39, 100,200, 21);
						getContentPane().add(lblNewLabel_2);


						textField_firsna= new JTextField();
						textField_firsna.setBounds(121, 150, 150, 20);
						getContentPane().add(textField_firsna);
						textField_firsna.setColumns(10);

						getContentPane().add(btnEnter);
						btnEnter.setBounds(270, 200,100, 23);  
						btnEnter.setVisible(true);
						getContentPane().add(btnEnterReturn);
						btnEnter.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									if(textField_firsna.getText().equals("")){
										JOptionPane.showMessageDialog(getContentPane(), "One  the field is empty");
									}
									else {
										LibraryCollection collection= new Magazine(textField_firsna.getText());
										Library.getInstance().removeCollection(collection);
										JOptionPane.showMessageDialog(getContentPane(),"Collection Type Magazine "+ textField_firsna.getText()+" remove successfully");
									}}
								catch (CollectionNotExistException ex) {
									JOptionPane.showMessageDialog(getContentPane(),ex.getMessage());

								}
							}
						});

					}

					else if(rdbtnEncyRadio.isSelected()) {
						btnEnterselect.setVisible(false);
						rdbtnEncyRadio.setVisible(false);
						rdbtnMagazineRadio.setVisible(false);

						JLabel lblNewLabel_2 = new JLabel("Enter Name Collection to remove:");
						lblNewLabel_2.setBounds(39, 100,200, 21);
						getContentPane().add(lblNewLabel_2);


						textField_firsna= new JTextField();
						textField_firsna.setBounds(121, 150, 150, 20);
						getContentPane().add(textField_firsna);
						textField_firsna.setColumns(10);

						getContentPane().add(btnEnter);
						btnEnter.setBounds(270, 200,100, 23);  
						btnEnter.setVisible(true);
						getContentPane().add(btnEnterReturn);
						btnEnter.addActionListener(new ActionListener() {
							@Override


							public void actionPerformed(ActionEvent e) {
								try {
									if(textField_firsna.getText().equals("")){
										JOptionPane.showMessageDialog(getContentPane(), "One  the field is empty");
									}
									else {
										LibraryCollection collection= new Encyclopedia(textField_firsna.getText());
										Library.getInstance().removeCollection(collection);
										JOptionPane.showMessageDialog(getContentPane(),"Collection Type Encyclopedia "+ textField_firsna.getText()+" remove successfully");
									}
								}
								catch (CollectionNotExistException e1) {
									//הוספתי
									JOptionPane.showMessageDialog(getContentPane(),e1.getMessage());

								}
							}


						});


					}}

			});

		}
	}}
