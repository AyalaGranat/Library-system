package Model;

import java.util.ArrayList;

import Utils.Topic;

public class Encyclopedia extends LibraryCollection {
	


	/**
	 * 
	 * @param name
	 * @param id
	 * @param books
	 */
	public Encyclopedia(String name, int id) {
		super(name,id);
		
	}
	
	
	// partial contractor
	public Encyclopedia(String name) {
		super(name);
	
	}
	
	
	/**
	 * 
	 * @return books
	 */
	public ArrayList<Book> getBooks(){
		
		ArrayList<Book> books = new ArrayList<Book>();
		for(LibraryItem item : items ) {
			if(item instanceof Book) {
				books.add((Book)item);
			}
		}
		return books;
	}
	
	

	
	/**
	 * 
	 * @return best book (with the biggest score)
	 */
/*	public Book getBestBook() { 
		double score = 0;
		int currPaperId = 0;
		for(Book book : this.books) {
			
			if(book.getReviews().size() != 0) {
			double scoreItem=book.GetScore();
			System.out.println(scoreItem);
			if(scoreItem > score) {
				score = scoreItem;
				currPaperId = book.getId();
				}
			}
		}	
		return getBookById(currPaperId);
	}*/
	
	// help function that return book by id.
/*	private Book getBookById(int bookId) {
		for(Book book : books) {
			if(book.getId() == bookId)
				return book;
		}
		return null;
	}*/
	
	 @Override
	    public String toString() {
		 ArrayList<Book> books = new ArrayList<Book>();
			for(LibraryItem item : items ) {
				if(item instanceof Book) {
					books.add((Book)item);
				}
			}
	    	return super.toString() +" books: " + books; 
	    }
	

}
