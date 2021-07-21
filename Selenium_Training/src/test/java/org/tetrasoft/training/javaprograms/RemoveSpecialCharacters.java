package org.tetrasoft.training.javaprograms;

public class RemoveSpecialCharacters {
	
	public static void main(String[] args) {
		 
		String str = "This#String%conatins*Special^Characters&";
		
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		
		System.out.println(str);
	}

}
