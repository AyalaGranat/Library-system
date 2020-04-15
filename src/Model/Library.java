package Model;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.security.auth.login.LoginContext;
import javax.swing.JOptionPane;

import Controller.MainClass;
import Exceptions.AuthorAlreadyExistException;
import Exceptions.AuthorNotExistException;
import Exceptions.CollectionAlreadyExistException;
import Exceptions.CollectionNotExistException;
import Exceptions.ReaderAlreadyExistException;
import Exceptions.ReaderNotExistException;
import Exceptions.itemAlreadyExistException;
import Exceptions.itemNotExistException;
import Model.*;
import Utils.Topic;

public class Library implements Serializable {
	
	private static Library instance;
	
	public static Recommender recommender;
	
    /*** the Item name.*/
	private String name;
    
	/*** list of books.*/
	private Set<LibraryItem> items;	
	
	/*** list of readers.*/
	private Set<Reader> readers;
	
	/*** list of authors.*/
	private Set<Author> authors;
	
	/*** list of magazines.*/
	private Set<LibraryCollection> collections;
	
	
	
    /**
     * private constructor (singleton class).
     *
     * @param name the Item name.

     */
	private Library(String name) {
		this.name = name;
		this.items = new HashSet<LibraryItem>();
		this.authors = new HashSet<Author>();
		this.readers = new HashSet<Reader>();
		this.collections = new HashSet<LibraryCollection>();
		Library.recommender = Recommender.getInstance();
	
	}



	/**
	 * 
	 * @return library instance
	 */
	public static Library getInstance() {
		if (MainClass.librarySys == null) {
				MainClass.librarySys = new Library("Haifa Library");
		}	
		return MainClass.librarySys;
	}


	public void serialize(Library library) {


		try {
			FileOutputStream fileOut = new FileOutputStream("library.ser");//name of the folder we create
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			try {
			out.writeObject(library);
			}
			catch (IOException e) {
			    e.printStackTrace();
			}
			
			out.close();
			fileOut.close();

			Recommender.getInstance();
			Recommender.serialize(Library.recommender);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public Library DeserializeDemo() {
		Library e = null;
		try {
			File fileIn = new File("library.ser");
			if(!fileIn.exists()) {
				return null;
			}

			FileInputStream file= new FileInputStream("library.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			e = (Library) in.readObject();
			in.close();
			file.close();

			File file2= new File("Recommender.ser");
			if(file2.exists()) {
				recommender=Recommender.DeserializeDemo();
			}
			else {
				recommender=Recommender.getInstance();
			}
			return e;
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return null;
		}

	}


	/**
	 * this generic function take the imaginary element and return the real one
	 * @param <T>
	 * @param set
	 * @param element
	 * @return real element
	 */
	private static <T> T getFromSet(Set<T> set, T element) {
		for (T e : set) {
			if (e.equals(element)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * This method adds a reader to the library IF the reader doesn't
	 * already exist and the details are valid.
	 * @param reader
	 * @return true if the reader was added successfully, false otherwise
	 * @throws ReaderAlreadyExistException 
	 */
	public boolean addReader(Reader reader) throws ReaderAlreadyExistException {
		if(reader == null)
			return false;

		//check if the reader available
		if(this.readers.contains(reader)) {
			throw new ReaderAlreadyExistException("Reader Already Exists: " + reader.getFirstName() + " " + reader.getLastName());
			//return false;
		}


		recommender.addReader(reader);//update recommender
		this.readers.add(reader);

		return true;
	}


	/**
	 * This method remove a reader from the library IF the reader doesn't
	 * already exist and the details are valid.
	 * @param reader
	 * @return true if the reader was removed successfully, false otherwise
	 * @throws ReaderNotExistException 
	 */

	public boolean removeReader(Reader reader) throws ReaderNotExistException {
		if(reader == null) 
			return false;

		//find the real author
		if(!readers.contains(reader)) // the reader does not exist
			throw new ReaderNotExistException("Reader does not Exist: " + reader.getFirstName() + " " + reader.getLastName());

		recommender.removeReader(reader);//update recommender
		this.readers.remove(Library.getFromSet(readers,reader));

		return true;


	}


	/**
	 * This method adds author to the library IF the author doesn't
	 * already exist and the details are valid.
	 * @param auther
	 * @return true if the author was added successfully, false otherwise
	 * @throws AuthorAlreadyExistException 
	 */
	public boolean addAuther(Author author) throws AuthorAlreadyExistException {
		if(author == null)
			return false;

		//check if the author available
		if(this.authors.contains(author))
			throw new AuthorAlreadyExistException("author Already Exists: " + author.getFirstName() + " " + author.getLastName());
		//return false;

		this.authors.add(author);
		return true;
	}


	/**
	 * This method remove author from the library IF the author doesn't
	 * already exist and the details are valid.
	 * @param author
	 * @return true if the author was removed successfully, false otherwise
	 * @throws AuthorNotExistException 
	 */
	public boolean removeAuthor(Author author) throws AuthorNotExistException {
		if(author == null) 
			return false;

		//find the real author
		if(!authors.contains(author))
			throw new AuthorNotExistException("author does not Exist: " + author.getFirstName() + " " + author.getLastName());

		this.authors.remove(Library.getFromSet(authors,author));
		return true;

	}


	/**
	 * This method adds book to the library IF the book doesn't
	 * already exist and the details are valid.
	 * @param reader
	 * @return true if the book was added successfully, false otherwise
	 * @throws BookAlreadyExistException 
	 */	
	public boolean addItem(LibraryItem item) throws itemAlreadyExistException {
		if(item == null)
			return false;

		//check if the object available
		if(this.items.contains(item))
			throw new itemAlreadyExistException("item Already Exists: : " + item.getName());
		//return false;

		// add book to author list
		item.getAuthor().addItem(item);

		// add book to library book list 
		this.items.add(item);
		return true;
	}


	/**
	 * This method removes book from the library IF the book doesn't
	 * already exist and the details are valid.
	 * @param reader
	 * @return true if the book was removed successfully, false otherwise
	 * @throws BookNotExistException 
	 */
	public boolean removeItem(LibraryItem item) throws itemNotExistException {
		if(item == null) 
			return false;

		//find the real book
		if(!this.items.contains(item)) // the book does not exist
			throw new itemNotExistException("item does not Exist: : " + item.getName());
		//return false;

		LibraryItem realItem = Library.getFromSet(items,item);
		realItem.getAuthor().removeItem(realItem);
		this.items.remove(realItem);
		return true;
	}


	


    /**
     * This method added a book to the reader list IF the book doesn't
     * already exist and the details are valid.
     * @param reader
     * @return true if the book was added successfully, false otherwise
     */				
	public boolean readItem(Reader reader, LibraryItem item){
		if(reader == null || item == null) 
			return false;
		//find the real reader
		if(!readers.contains(reader)) // the reader does not exist
			return false;
		Reader realReader = Library.getFromSet(readers,reader);
		
		//find the real item
		if(!items.contains(item)) // the item does not exist
			return false;
		else {
			
			LibraryItem realItem = Library.getFromSet(items,item);
			
			// add the book in the books reader list and the reader in the readers book list
			 
			boolean b2 = realItem.addReader(realReader);
			boolean b1 = realReader.addItem(realItem);
			
			recommender.readUpdate(realReader, realItem);
			return b1 && b2;
			
		}

	}
	

    /**
     * This method added a review to library review  IF the review doesn't
     * already exist and the details are valid.
     * @param reader
     * @param item
     * @param review
     * @return true if the review was added successfully, false otherwise
     */		
	public boolean makeReview(LibraryItem item, Review review)  {
		if( item == null || review == null ) {
			return false;
		}

		//find the real book
		if(!items.contains(item)) // the book does not exist
			return false;
		LibraryItem realBook = Library.getFromSet(items,item);
		return(realBook.addRewiew(review));
	}
	


    /**
     * This method return the best book in the library,
     * best book is the book with the biggest average score.
     * 
     * @return book or null if there is no book.
     * @throws itemNotExistException 
     */	
	public LibraryItem getBestBook(ScoreCalculator calculator ) throws itemNotExistException  { 
		double score = 0;
		double scoreItem = 0;
		String currBookName= null;
		
		for(LibraryItem item : this.items) {
			if(item instanceof Book) {
				scoreItem = item.GetScore(calculator);
				if(scoreItem > score) {
					score = scoreItem;
					currBookName = item.getName();
					}
			}	
		}
		return getItemByName(currBookName);
	}


	
	  /**
     * This method return the best paper in the library,
     * best paper is the book with the biggest average score.
     * 
     * @return paper or null if there is no book.
	 * @throws itemNotExistException 
     */	
	public LibraryItem getBestPaper(ScoreCalculator calculator ) throws itemNotExistException { 
		double score = 0;
		double scoreItem = 0;
		String currBookName= null;
		
		for(LibraryItem item : this.items) {
			if( item instanceof Paper) {
				
				scoreItem = calculator.calculate(item.getReviews());
				if(scoreItem > score) {
					score = scoreItem;
					currBookName = item.getName();
					}
			}	
		}
		return getItemByName(currBookName);
	}

	
	
	// help function that return book by name.
	public LibraryItem getItemByName(String itemName) throws itemNotExistException {
		for(LibraryItem item : items) {
			if(item.getName().equals(itemName)) 
				return item;	
			
		}
		throw new itemNotExistException("item does not exist "+itemName);
	}

	
	
    /**
     * This method added a magazine to the library  IF the magazine doesn't
     * already exist and the details are valid.
     * @param magazine
     * @return true if the magazine was added successfully, false otherwise
     * @throws CollectionAlreadyExistException 
     */	
	public boolean addCollection(LibraryCollection collection) throws CollectionAlreadyExistException {
		if(collection == null)
			return false;
			
		//check if the object available
		if(this.collections.contains(collection)) {
				throw new CollectionAlreadyExistException("collection Already Exists: : " + collection.getName());
		}
			
			this.collections.add(collection);
			return true;
		
	}
	
	
	
    /**
     * This method removed a magazine from the library  IF the magazine
     * already exist and the details are valid.
     * @param magazine
     * @return true if the magazine was removed successfully, false otherwise
     */	
	public boolean removeCollection(LibraryCollection collection) throws CollectionNotExistException {
		if(collection == null)
			return false;
		
		//check if the object available
		if(this.collections.contains(collection)) {
			this.collections.remove(collection);
			return true;
			}
		
		throw new CollectionNotExistException("collection does not exists: "+collection.getName());	
		}
	

	
	/**
	 * 
	 */
	public boolean addCollectionItem(LibraryCollection collection, LibraryItem item)
	{
		if(!collections.contains(collection))
			return false;
		Library.getFromSet(collections,collection).addItem(item);
		return true;
	}
	
	
	
	/**
	 *  get Encyclopedia by name
	 * @param encyclopediaName  string nameOfEncyclopedia
	 * @return Encyclopedia 
	 */

	public Encyclopedia getEncyclopidea(String encyclopediaName){
		Encyclopedia encyclopedia = new Encyclopedia(encyclopediaName);//imaginary instance //just to find the real one
		if(!collections.contains(encyclopedia))
			return null;
		return (Encyclopedia)Library.getFromSet(collections,encyclopedia);
		
		
		
	}
	
	/**
	 *  get Encyclopedia by name
	 * @param encyclopediaName  string nameOfEncyclopedia
	 * @return Encyclopedia 
	 */

	public Magazine getMagazine(String magazineName){
		Magazine magazine = new Magazine(magazineName);//imaginary instance //just to find the real one
		if(!collections.contains(magazine))
			return null;
		return (Magazine) Library.getFromSet(collections,magazine);
		
		
	}
	
	
	/**
	 * 
	 * @param encyc
	 * @return
	 */

	public  ArrayList<Book> getEncyclopideaBooks(Encyclopedia encyc){
		return encyc.getBooks();
	}
	
	
	/**
	 * 
	 * @param encyc
	 * @return
	 */

	public  ArrayList<Paper> getMagazinePapers(Magazine magazine){
		return magazine.getPapers();
	}
	
	
	
	
	/**
	 * 
	 * @param encyc
	 * @return
	 */

	public  Set<Topic> getEncyclopideaTopics(Encyclopedia encyc){
		return encyc.getTopics();
	}
	
	
	/**
	 * 
	 * @param magazine
	 * @return
	 */
	public  Set<Topic> getMagazineTopics(Magazine magazine){
		return magazine.getTopics();
	}
	
	/**
	 * 
	 * @param encyc
	 * @return
	 */
	public  Set<Author> getEncyclopideaAuthors(Encyclopedia encyc){
		return encyc.getAuthors();
	}
	
	/**
	 * 
	 * @param magazine
	 * @return
	 */
	public  Set<Author> getMagazineAuthors(Magazine magazine){
		return magazine.getAuthors();
	}
	
	
	/***
	 * 
	 * @author mmaja
	 *
	 */
	public static class sortByScore implements  Comparator<LibraryItem>{
		private ScoreCalculator calculator;
		sortByScore(ScoreCalculator calculator){
			this.calculator = calculator;
		}
		
		@Override
		 public int compare(LibraryItem o1,  LibraryItem o2) 
         { 
             if( o1.GetScore(calculator) > o2.GetScore(calculator) )
             	return 1;
             else {
             	if (o1.GetScore(calculator) < o2.GetScore(calculator))
             		return -1;
             	else
             		return 0;
             }   	
         }
	}
	
	/**
	 * 
	 * @param books
	 * @param k
	 * @param calculator
	 * @return
	 */
	public ArrayList<Book> getBestBooks ( int k, ScoreCalculator calculator){
		return HelpGetBestBooks(getBooks(),k,calculator);
	}
	
	private ArrayList<Book> HelpGetBestBooks (ArrayList<Book>books, int k, ScoreCalculator calculator){
		ArrayList<Book> returnList = new ArrayList<Book>();
        // Sort the list 
		 Collections.sort(books, new sortByScore(calculator));
		 Collections.reverse(books);
		 if(k > books.size()) // if the k is biggest the all books
			 k = books.size();
        for(int i=0; i < k; i++) {
        	returnList.add(books.get(i)); 
        }
        
        return returnList;    
	}
	/**
	 * 
	 * @param Papers
	 * @param k
	 * @param calculator
	 * @return
	 */
	private ArrayList<Paper> HelpGetBestPapers (ArrayList<Paper>Papers, int k, ScoreCalculator calculator){
		ArrayList<Paper> returnList = new ArrayList<Paper>();
        // Sort the list 
		 Collections.sort(Papers, new sortByScore(calculator));
		 Collections.reverse(Papers);
		 if(k > Papers.size()) // if the k is biggest the all books
			 k = Papers.size();
        for(int i=0; i < k; i++) {
        	returnList.add(Papers.get(i)); 
        }
        
        return returnList;    
	}
	
	/**
	 * 
	 * @param k
	 * @param calculator
	 * @return
	 */
	public ArrayList<Paper> getBestPapers ( int k, ScoreCalculator calculator){
		return HelpGetBestPapers(getPapers(),k,calculator);
	}
	

	
	/**
	 * 
	 * @param author
	 * @param k
	 * @param calculator
	 * @return
	 */
	public ArrayList<Book> getBestAuthorBooks (Author author, int k, ScoreCalculator calculator){
		if(!authors.contains(author))
			return null;

		Author realAuthor = Library.getFromSet(authors,author);
		return HelpGetBestBooks(realAuthor.getBooks(), k, calculator);
		
		
	}
	
	
	/**
	 * 
	 * @param author
	 * @param k
	 * @param calculator
	 * @return
	 */
	public ArrayList<Paper> getBestAuthorPapers (Author author, int k, ScoreCalculator calculator){
		if(!authors.contains(author))
			return null;

		Author realAuthor = Library.getFromSet(authors,author);
		return HelpGetBestPapers(realAuthor.getPapers(), k, calculator);
	}
	
	/**
	 * 
	 * @param topic
	 * @param k
	 * @param calculator
	 * @return
	 */
	public ArrayList<Book> getBestTopicBooks (Topic topic, int k, ScoreCalculator calculator){
		ArrayList<Book> returnList = new ArrayList<Book>();
		for(Book book : getBooks()) {
			if(book.getTopic() == topic)
				returnList.add(book);
		}
		return HelpGetBestBooks(returnList, k, calculator);
	}
	
	
	
	/**
	 * 
	 * @param topic
	 * @param k
	 * @param calculator
	 * @return
	 */
	public ArrayList<Paper> getBestTopicPapers (Topic topic, int k, ScoreCalculator calculator){
		ArrayList<Paper> returnList = new ArrayList<Paper>();
		for(Paper paper : getPapers()) {
			if(paper.getTopic() == topic)
				returnList.add(paper);
		}
		return HelpGetBestPapers(returnList, k, calculator);
	}
	
	
	
	/**
	 * get best k authors (if there less than k return it)
	 * @param k
	 * @return  readers
	 */
	public ArrayList<Author> getBestAuthors(int k) {
		ArrayList<Author> returnList = new ArrayList<Author>();
		if(k<=0)
			return null;
		HashMap<Author, Integer> hm = new HashMap<Author, Integer>();
		for(Author author : authors) {
			int count = 0;
			for(LibraryItem item : author.getItems()) {
				count += item.getReaders().size();
			}
			hm.put(author, count);
		}
		ArrayList<Author> tempAuthors = sortedByValue(hm);
		
		if(k > tempAuthors.size()) // if the k is biggest the all authors
			 k = tempAuthors.size();
		for(int i=0; i < k; i++) {
      	returnList.add(tempAuthors.get(i)); 
      }
      return returnList;
	}
	
	/**
	 * 
	 * @param hm
	 * @return
	 */
	
	 private static ArrayList<Author> sortedByValue(HashMap<Author, Integer> hm){
		 
	        // Create a list from elements of HashMap 
		 LinkedList<Map.Entry<Author, Integer> > list = 
	               new LinkedList<Map.Entry<Author, Integer> >(hm.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<Author, Integer> >() { 
	            public int compare(Map.Entry<Author, Integer> o1,  
	                               Map.Entry<Author, Integer> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	        
	     // put data from sorted list of  entry map to list of authors   
	        ArrayList<Author> temp = new ArrayList<Author>(); 
	        for (Map.Entry<Author, Integer> it : list) { 
	            temp.add(it.getKey()); 
	        }
	        Collections.reverse(temp);
	        return temp; 
	 }
	
	
	 /**
	  * 
	  * @author mmaja
	  *
	  */
		public  class sortReaderBynumberofItems implements  Comparator<Reader>{

			
			@Override
			 public int compare(Reader o1,  Reader o2) 
	         { 
				return o1.getItems().size() - o2.getItems().size();
	         }
		}
	/**
	 * get best k readers (if there less than k return it)
	 * @param k
	 * @return  readers
	 */
	public ArrayList<Reader> getBestReaders(int k) {
		
		if(k<=0)
			return null;
		ArrayList<Reader> tempReaders = new ArrayList<Reader>(this.readers); // copy reader list
		ArrayList<Reader> returnList = new ArrayList<Reader>();
		
		 Collections.sort(tempReaders, new sortReaderBynumberofItems());
		 Collections.reverse(tempReaders);
		 
		 if(k > tempReaders.size()) // if the k is biggest the all readers
			 k = tempReaders.size();
       for(int i=0; i < k; i++) {
       	returnList.add(tempReaders.get(i)); 
       }
       return returnList;
	}
	
	

	
	// function that return reader by id.
	public Reader getReaderByName(String firstName, String lastName) throws ReaderNotExistException {
		for(Reader reader : readers) {
			if(reader.getFirstName().equals(firstName)  && reader.getLastName().equals(lastName) )
				return reader;
		}
		throw new ReaderNotExistException("reader does not exist "+firstName+" "+lastName);
	}
	
	
	// function that return author by name.
	public Author getAuthorByName(String firstName, String lastName) throws AuthorNotExistException {
		for(Author author : authors) {
			if(author.getFirstName().equals(firstName) && author.getLastName().equals(lastName) ) {
				return author;
			}
		}
		throw new AuthorNotExistException("author "+firstName+" "+lastName+" does not exists");
	}
	
	
	
	/** Geters()  **/
	
	public String getLibraryName() {
		return this.name;
	}
	
	public Set<LibraryItem> getItems(){
		return this.items;
	}
	
	public ArrayList<Paper> getPapers(){
		ArrayList<Paper> papers = new ArrayList<Paper>();
		for( LibraryItem item : items) {
			if(item instanceof Paper)
				papers.add((Paper)item);
		}
		return papers;
	}
	
	public ArrayList<Book> getBooks(){
		ArrayList<Book> books = new ArrayList<Book>();
		for( LibraryItem item : items) {
			if(item instanceof Book)
				books.add((Book)item);
		}
		return books;
	}
	
	

	public Set<Author> getAuthors(){
		return this.authors;
	}
	
	public Set<Reader> getReaders(){
		return this.readers;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Magazine> getMagazines(){
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		for( LibraryCollection collection : collections) {
			if(collection instanceof Magazine)
				magazines.add((Magazine)collection);
		}
		return magazines;
	}
	
	
	/********/
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Encyclopedia> getEncyclopedias(){
		ArrayList<Encyclopedia> encyclopedias = new ArrayList<Encyclopedia>();
		for( LibraryCollection collection : collections) {
			if(collection instanceof Encyclopedia)
				encyclopedias.add((Encyclopedia)collection);
		}
		return encyclopedias;
	}
	
	
	/**
	 * 
	 * @param reader
	 * @param k
	 * @param calcualtor
	 * @return
	 */
	public ArrayList<Book> recommendBooksByTopic(Reader reader, int k, ScoreCalculator calcualtor ){
		//find the real reader
		if(!readers.contains(reader)||items==null) // the reader does not exist
			return null;
		Reader realReader = Library.getFromSet(readers,reader);
		if(realReader.getBooks()==null) return null;
		return recommender.recommendBooksByTopic(realReader, k, calcualtor, items);
		
	}
	/**
	 * 
	 * @param reader
	 * @param k
	 * @param calcualtor
	 * @return
	 */
	public ArrayList<Paper> recommendPapersByTopic(Reader reader, int k, ScoreCalculator calcualtor ){

		//find the real reader
		if(!readers.contains(reader)) // the reader does not exist
			return null;
		Reader realReader = Library.getFromSet(readers,reader);
		return recommender.recommendPapersByTopic(realReader, k, calcualtor, items);
	}
	/**
	 * 
	 * @param reader
	 * @param k
	 * @param calcualtor
	 * @return
	 */
	public ArrayList<Book> recommendBooksByAuthor(Reader reader, int k, ScoreCalculator calcualtor ){

		//find the real reader
		if(!readers.contains(reader)) // the reader does not exist
			return null;
		Reader realReader = Library.getFromSet(readers,reader);
		return recommender.recommendBooksByAuthor(realReader, k, calcualtor, items);
	}
	
	/**
	 * 
	 * @param reader
	 * @param k
	 * @param calcualtor
	 * @return
	 */
	public ArrayList<Paper> recommendPapersByAuthor(Reader reader, int k, ScoreCalculator calcualtor ){

		//find the real reader
		if(!readers.contains(reader)) // the reader does not exist
			return null;
		Reader realReader = Library.getFromSet(readers,reader);
		return recommender.recommendPapersByAuthor(realReader, k, calcualtor, items);
	}
}




