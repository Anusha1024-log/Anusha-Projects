package org.tetrasoft.training.javaprograms;

public class CountTheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		String str = "India is my country";
		String[] words = {};
		if((str==null)||(str.isEmpty())) {
			words=null;
		}
			else {
			words=str.split("\\s+");
			 
			int count = words.length;
			
			System.out.println("No of words in String are:"+count);
		}
		
	}

}
