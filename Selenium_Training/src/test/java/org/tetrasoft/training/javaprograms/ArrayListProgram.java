package org.tetrasoft.training.javaprograms;

import java.util.ArrayList;

public class ArrayListProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfMinutes(28));
		
	}
	public static int numberOfMinutes(int n) {
		
		ArrayList<Integer> q = new ArrayList<>();
		
		 for(int i=0;i<n;i++) { 
			 q.add(1); 
		 }
	    int min=0;
	    
	    while(q.size()>0) {
	    	q.add(q.size(), 1);
	    	q.remove(0);
	    	
	    	if(q.size()>=2) {
	    		q.remove(q.size()/2);
	    		q.remove(q.size()/2);
	    	}
	    	else {
	    		q.remove(q.size()-1);
	    	}
	    	min++;
	    }
	    return min;
	}
}
