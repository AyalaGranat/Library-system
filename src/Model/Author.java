package Model;

import java.util.ArrayList;
import Utils.Topic;

public class Author extends LibraryUser {
	
	private Topic topic;
	

	public Author(String firstName, String lastName, Topic topic) { // this implementation because it without polymorphism.
		super(firstName, lastName);
		this.topic = topic;
		
	}
	
	// partial contractor
	public 	Author(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		super(firstName,lastName);
	}
	
	
	//get
	public Topic gettopic() {
		return this.topic;
	}
	
	 @Override
	    public String toString() {
	    	return "author name: " + getFirstName() + " " + getLastName() ; 
	    }
	    
	
	
	
	

}
