package org.tetrasoft.training.javaprograms;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		String str = "112211";
		String revStr  = "";
		
		for(int i=str.length()-1;i>=0;i--) {
			
			revStr = revStr+str.charAt(i);
		}
		System.out.println("Reverse string is:"+revStr);
		if(str.equalsIgnoreCase(revStr))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}
}