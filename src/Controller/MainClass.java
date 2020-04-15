package Controller;
import java.util.Scanner;

import javax.swing.JFrame;

import Exceptions.AuthorAlreadyExistException;
import Exceptions.AuthorNotExistException;
import Exceptions.ReaderAlreadyExistException;
import Exceptions.ReaderNotExistException;
import Exceptions.itemAlreadyExistException;
import Exceptions.itemNotExistException;
import Gui.Login;
import Model.ArithmeticMean;
import Model.Author;
import Model.Book;
import Model.Encyclopedia;
import Model.GeometricMean;
import Model.HarmonicMean;
import Model.Library;
import Model.LibraryItem;
import Model.Magazine;
import Model.Paper;
import Model.Reader;
import Model.Recommender;
import Model.Review;
import Model.ScoreCalculator;
import Utils.AcademicBook;
import Utils.BookSize;
import Utils.MyFileLogWriter;
import Utils.PaperValue;
import Utils.Topic;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainClass {

	public static Library librarySys;
	public static Recommender recomanderSys;

	public static void main(String[] args) {
		Login login= new Login();


		login.setVisible(true);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(500, 500);
		String fiString="library.ser";
		
		File file1= new File(fiString);
		
		if(file1.exists()) {
			librarySys= Library.getInstance().DeserializeDemo();
		}
		else
			librarySys=Library.getInstance();
		
	}
}
