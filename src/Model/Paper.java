package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import Utils.BookSize;
import Utils.PaperValue;
import Utils.Topic;

public class Paper extends LibraryItem implements Serializable {
	
	private PaperValue papperValue;
	private String university;
	
	/**
     * Full constructor.
     *
     * @param name the Item name.
     * @param id the Item id.
     * @param ReleaseDate The release date of the Book. 
     * @param author The Item's author.
     * @param reviews The Item's reviews.
     * @param PaperValue
     * @param university
     */
    public Paper(String name, Topic topic, Author author,
    		PaperValue papperValue,String university) {
    	super(name,topic,author);
    	this.papperValue=papperValue;
    	this.university=university;
    }
    
 // partial contractor
    public Paper(String name) {
    	super(name);
    }
    

    
    // geters and seters 
    
    public void setBookSize(PaperValue papperValue) {
    	this.papperValue=papperValue;
    }
    
    public void setAcadmemicBook(String university) {
    	this.university=university;
    	
    }
    
    public PaperValue getBookSize() {
    	return this.papperValue;
    }
    
    public String getAcadmemicBook() {
    	return this.university;
    	
    }
    
    @Override
    public String toString() {
    	return "paper name: " + getName(); 
    }

}
