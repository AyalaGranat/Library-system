package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Exceptions.itemNotExistException;
import Model.ArithmeticMean;
import Model.GeometricMean;
import Model.HarmonicMean;
import Model.Library;

public class BestBookOrPaper extends JFrame {
	private JRadioButton arRadioButton;
	private JRadioButton geoRadioButton;
	private JRadioButton haRadioButton;
	private ButtonGroup radGroup;

	public BestBookOrPaper(String temp)  {
		super("bestBookOrPaper");
		getContentPane().setLayout(null);
		radGroup=new ButtonGroup();
		arRadioButton=new JRadioButton("arithmeticMean",false);
		geoRadioButton=new JRadioButton("geometricMean",false);
		haRadioButton=new JRadioButton("harmonicMean",false);
		arRadioButton.setBounds(50, 50, 150, 20);
		geoRadioButton.setBounds(50, 100, 150,20);
		haRadioButton.setBounds(50, 150, 150, 20);
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
					String message=null;
					if(temp.equals("book")) {
						message = Library.getInstance().getBestBook(arithmeticMean).toString();
					}
					else if(temp.equals("paper")) {
						message=Library.getInstance().getBestPaper(arithmeticMean).toString();
					}
					JOptionPane.showMessageDialog(getContentPane(), message);					
				} catch (itemNotExistException ex) {
					JOptionPane.showMessageDialog(getContentPane(), "no best item");
				}	

			}
		});

		geoRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					GeometricMean geometricMean=new GeometricMean();
					String message = Library.getInstance().getBestBook(geometricMean).toString();
					JOptionPane.showMessageDialog(getContentPane(), message);
				} catch (itemNotExistException ex) {
					JOptionPane.showMessageDialog(getContentPane(),  "no best item");
				}	


			}
		});
		haRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					HarmonicMean harmonicMean=new HarmonicMean();
					String message = Library.getInstance().getBestBook(harmonicMean).toString();
					JOptionPane.showMessageDialog(getContentPane(), message);
				} catch (itemNotExistException ex) {
					JOptionPane.showMessageDialog(getContentPane(),  "no best item");
				}	

			}
		});



	}

}
