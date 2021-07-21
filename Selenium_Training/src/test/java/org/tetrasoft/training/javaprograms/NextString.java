package org.tetrasoft.training.javaprograms;

public class NextString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="deFg",nextStr = "";
		int k=1,i,val,dup;
		
		for(i=0;i<str.length();i++) {
			//ASCII values
			val= str.charAt(i);
			//store duplicate
			dup = k;
			   if (val + k > 122) {
	                k -= (122 - val);
	                k = k % 26;
	                 
	                nextStr += (char)(96 + k);
	            } else {
	                nextStr += (char)(val + k);
	            }
	 
	            k = dup;
		}
		//print new string
		System.out.println("New String is; "+nextStr);

	}

}
