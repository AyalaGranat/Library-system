package Model;

import java.util.ArrayList;
import java.util.Set;

public class HarmonicMean implements ScoreCalculator{

	@Override
	public float calculate(Set<Review> reviews) {
		// Declare sum variables and  
        // initialize with zero 
		int n = reviews.size();
        float sum = 0; 
       
		for(Review review : reviews) 
			sum = sum * (float)1/review.getRate();
        return (float)n/sum; 
	}

}
