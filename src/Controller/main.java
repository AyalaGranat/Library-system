package Controller;
//Java program to print all subsets with given sum 
import java.util.*; 
class main 
{ 
	
	//Driver code 
	public static void main(String args[]) 
	{ 
		/*Set<Integer> s = new HashSet<Integer>();
		s.add(5);
		s.add(7);
		s.add(9);
		s.add(1);
		if(getFromSet(s,7) == null)
			System.out.println(0);
		else 
			System.out.println(1);*/
		 int n = 8; // Number of threads 
	        for (int i=0; i<8; i++) 
	        { 
	          //  MultithreadingDemo object = new MultithreadingDemo(); 
	          //  object.start(); 
	        } 
		
		
	} 
	
	
	class MultithreadingDemo extends Thread 
	{ 
	    public void run() 
	    { 
	        try
	        { 
	            // Displaying the thread that is running 
	            System.out.println ("Thread " + 
	                  Thread.currentThread().getId() + 
	                  " is running"); 
	  
	        } 
	        catch (Exception e) 
	        { 
	            // Throwing an exception 
	            System.out.println ("Exception is caught"); 
	        } 
	    } 
	} 
	
	 public static <T> T getFromSet(Set<T> set, T element) {
		   for (T e : set) {
		     if (e.equals(element)) {
		    	 return e;
		     }
		   }
		   return null;
		 }

		/*public static Object getFromSet(Set<Object> set, Object value) {
			for(Object ob : set) {
				if(ob.equals(value))
					return ob;
			}
			return null;
		}*/
}
//contributed by Arnab Kundu 
