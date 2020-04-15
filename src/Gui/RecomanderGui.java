package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Exceptions.ReaderNotExistException;
import Model.ArithmeticMean;
import Model.GeometricMean;
import Model.HarmonicMean;
import Model.Library;
import Model.LibraryItem;
import Model.Reader;


public class RecomanderGui extends JFrame {
	private JRadioButton arRadioButton;
	private JRadioButton geoRadioButton;
	private JRadioButton haRadioButton;
	private ButtonGroup radGroup;
	private JLabel kItems;
	private JTextField textField_kItems;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField textField_ReaderFirNa;
	private JTextField textField_ReaderLaNa;
	private JButton btnEnter;


	public RecomanderGui(String temp) {
		super(" RecomanderGui");
		getContentPane().setLayout(null);
		radGroup=new ButtonGroup();
		arRadioButton=new JRadioButton("arithmeticMean",false);
		geoRadioButton=new JRadioButton("geometricMean",false);
		haRadioButton=new JRadioButton("harmonicMean",false);
		kItems=new JLabel("number of items");
		lblFirstName=new JLabel("reader first name");
		lblLastName=new JLabel("reader last name");
		btnEnter=new JButton("Enter");
		textField_ReaderFirNa=new JTextField();
		textField_ReaderLaNa=new JTextField();
		textField_kItems=new JTextField();
		arRadioButton.setBounds(71, 66, 150, 20);
		geoRadioButton.setBounds(71, 102, 150,20);
		haRadioButton.setBounds(71, 135, 150, 20);
		kItems.setBounds(76, 39, 100, 20);
		lblFirstName.setBounds(71, 162, 150, 20);
		lblLastName.setBounds(71, 193, 150, 20);
		textField_kItems.setBounds(200, 39, 100, 20);
		textField_ReaderFirNa.setBounds(200, 162, 150, 20);
		textField_ReaderLaNa.setBounds(200, 193, 150, 20);
		btnEnter.setBounds(110, 224, 150, 20);
		textField_kItems.setColumns(3);
		getContentPane().add(btnEnter);
		getContentPane().add(kItems);
		getContentPane().add(textField_kItems);
		getContentPane().add(arRadioButton);
		getContentPane().add(lblFirstName);
		getContentPane().add(lblLastName);
		getContentPane().add(textField_ReaderFirNa);
		getContentPane().add(textField_ReaderLaNa);
		getContentPane().add(geoRadioButton);
		getContentPane().add(haRadioButton);
		radGroup.add(arRadioButton);
		radGroup.add(geoRadioButton);
		radGroup.add(haRadioButton);
		
		btnEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String message=null;
				if(textField_kItems.getText().equals("") || textField_ReaderFirNa.equals("") || textField_ReaderLaNa.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
				}
				else {
					try {
						Reader reader = Library.getInstance().getReaderByName(textField_ReaderFirNa.getText(), textField_ReaderLaNa.getText());
						Set<LibraryItem> items=Library.getInstance().getItems();
						int k=Integer.parseInt(textField_kItems.getText());
						if(arRadioButton.isSelected()) {
							ArithmeticMean arithmeticMean=new ArithmeticMean();
							if(temp.equals("topicBook")) {
								message=Library.getInstance().recommendBooksByTopic(reader, k, arithmeticMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);

							}
							else if(temp.equals("topicPaper")) {
								message=Library.getInstance().recommendPapersByTopic(reader, k, arithmeticMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
							else if(temp.equals("authorBook")) {
								message=Library.getInstance().recommendBooksByAuthor(reader, k, arithmeticMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
							else if(temp.equals("authorPaper")) {
								message=Library.getInstance().recommendPapersByAuthor(reader, k, arithmeticMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}

						}
						else if(geoRadioButton.isSelected()) {
							GeometricMean geometricMean=new GeometricMean();
							if(temp.equals("topicBook")) {
								message=Library.getInstance().recommendBooksByTopic(reader, k, geometricMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);

							}
							else if(temp.equals("topicPaper")) {
								message=Library.getInstance().recommendPapersByTopic(reader, k, geometricMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
							else if(temp.equals("authorBook")) {
								message=Library.getInstance().recommendBooksByAuthor(reader, k, geometricMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
							else if(temp.equals("authorPaper")) {
								message=Library.getInstance().recommendPapersByAuthor(reader, k, geometricMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
						}
						else if(haRadioButton.isSelected()) {
							HarmonicMean harmonicMean=new HarmonicMean();
							if(temp.equals("topicBook")) {
								message=Library.getInstance().recommendBooksByTopic(reader, k, harmonicMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);

							}
							else if(temp.equals("topicPaper")) {
								message=Library.getInstance().recommendPapersByTopic(reader, k, harmonicMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
							else if(temp.equals("authorBook")) {
								message=Library.getInstance().recommendBooksByAuthor(reader, k, harmonicMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
							else if(temp.equals("authorPaper")) {
								message=Library.getInstance().recommendPapersByAuthor(reader, k, harmonicMean).toString();
								JOptionPane.showMessageDialog(getContentPane(), message);
							}
						}
					}
					catch (ReaderNotExistException ex) {
						JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
					}
					catch (NumberFormatException E2) {
						JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
					}
				}

			}
		});
	}

		public RecomanderGui(String temp,String firstname, String lastname) {
			super(" RecomanderGui");
			getContentPane().setLayout(null);
			radGroup=new ButtonGroup();
			arRadioButton=new JRadioButton("arithmeticMean",false);
			geoRadioButton=new JRadioButton("geometricMean",false);
			haRadioButton=new JRadioButton("harmonicMean",false);
			kItems=new JLabel("number of items");
			lblFirstName=new JLabel("reader first name");
			lblLastName=new JLabel("reader last name");
			btnEnter=new JButton("Enter");
			textField_ReaderFirNa=new JTextField(firstname);
			textField_ReaderFirNa.setEditable(false);
			textField_ReaderLaNa=new JTextField(lastname);
			textField_ReaderLaNa.setEditable(false);
			textField_kItems=new JTextField();
			arRadioButton.setBounds(71, 66, 150, 20);
			geoRadioButton.setBounds(71, 102, 150,20);
			haRadioButton.setBounds(71, 135, 150, 20);
			kItems.setBounds(76, 39, 100, 20);
			lblFirstName.setBounds(71, 162, 150, 20);
			lblLastName.setBounds(71, 193, 150, 20);
			textField_kItems.setBounds(200, 39, 100, 20);
			textField_ReaderFirNa.setBounds(200, 162, 150, 20);
			textField_ReaderLaNa.setBounds(200, 193, 150, 20);
			btnEnter.setBounds(110, 224, 150, 20);
			textField_kItems.setColumns(3);
			getContentPane().add(btnEnter);
			getContentPane().add(kItems);
			getContentPane().add(textField_kItems);
			getContentPane().add(arRadioButton);
			getContentPane().add(lblFirstName);
			getContentPane().add(lblLastName);
			getContentPane().add(textField_ReaderFirNa);
			getContentPane().add(textField_ReaderLaNa);
			getContentPane().add(geoRadioButton);
			getContentPane().add(haRadioButton);
			radGroup.add(arRadioButton);
			radGroup.add(geoRadioButton);
			radGroup.add(haRadioButton);
			
			btnEnter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String message=null;
					if(textField_kItems.getText().equals("") || textField_ReaderFirNa.equals("") || textField_ReaderLaNa.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "One or more of the fields is empty");
					}
					else {
						try {
							Reader reader = Library.getInstance().getReaderByName(textField_ReaderFirNa.getText(), textField_ReaderLaNa.getText());
							Set<LibraryItem> items=Library.getInstance().getItems();
							int k=Integer.parseInt(textField_kItems.getText());
							if(arRadioButton.isSelected()) {
								ArithmeticMean arithmeticMean=new ArithmeticMean();
								if(temp.equals("topicBook")) {
									message=Library.getInstance().recommendBooksByTopic(reader, k, arithmeticMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);

								}
								else if(temp.equals("topicPaper")) {
									message=Library.getInstance().recommendPapersByTopic(reader, k, arithmeticMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
								else if(temp.equals("authorBook")) {
									message=Library.getInstance().recommendBooksByAuthor(reader, k, arithmeticMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
								else if(temp.equals("authorPaper")) {
									message=Library.getInstance().recommendPapersByAuthor(reader, k, arithmeticMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}

							}
							else if(geoRadioButton.isSelected()) {
								GeometricMean geometricMean=new GeometricMean();
								if(temp.equals("topicBook")) {
									message=Library.getInstance().recommendBooksByTopic(reader, k, geometricMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);

								}
								else if(temp.equals("topicPaper")) {
									message=Library.getInstance().recommendPapersByTopic(reader, k, geometricMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
								else if(temp.equals("authorBook")) {
									message=Library.getInstance().recommendBooksByAuthor(reader, k, geometricMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
								else if(temp.equals("authorPaper")) {
									message=Library.getInstance().recommendPapersByAuthor(reader, k, geometricMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
							}
							else if(haRadioButton.isSelected()) {
								HarmonicMean harmonicMean=new HarmonicMean();
								if(temp.equals("topicBook")) {
									message=Library.getInstance().recommendBooksByTopic(reader, k, harmonicMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);

								}
								else if(temp.equals("topicPaper")) {
									message=Library.getInstance().recommendPapersByTopic(reader, k, harmonicMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
								else if(temp.equals("authorBook")) {
									message=Library.getInstance().recommendBooksByAuthor(reader, k, harmonicMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
								else if(temp.equals("authorPaper")) {
									message=Library.getInstance().recommendPapersByAuthor(reader, k, harmonicMean).toString();
									JOptionPane.showMessageDialog(getContentPane(), message);
								}
							}
						}
						catch (ReaderNotExistException ex) {
							JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
						}
						catch (NumberFormatException E2) {
							JOptionPane.showMessageDialog(getContentPane(),"the number of item must be Number");
						}
						//אולי אמורה להיות שגיאה כאשר לא שומר את הרקומנדר 
						
					}

				}
			});

	
		
	}

}
