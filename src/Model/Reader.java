package Model;

import java.io.Serializable;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Reader extends LibraryUser  {

	private String id;
	private String password;
	
	public Reader(String firstName, String lastName, String id, String password) { // this implementation because it without polymorphism.
		super(firstName, lastName);
		this.id= id;
		this.password=password;
	}
	

	
	 @Override
	    public String toString() {
	    	return "reader name: " + getFirstName() + " " + getLastName() ; 
	    }



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	 
	 
}
