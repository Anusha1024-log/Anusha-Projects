package org.tetrasoft.training.baseclasses;

//Import Section
import java.io.*;
import java.util.ArrayList;

/*Description about this class
 * Usage:
 * Methods:
 * Members:
 * Author
 * Modifications Done:
 * 
 */
public class Datatypes {
  
	int value;
	public Datatypes(int a) {
		//It will not return anything
		//it will call at the time of object creation
		//it is both parameterized and non parameterized
		//it is used to invoke instance variable
		this.value=a;
		System.out.println("cunstructor variable is:"+value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a Test program");

		int a=10;
		String var="Anusha";
		System.out.println("int variable is :"+ a);
		System.out.println("My name is:"+var);
		
		Datatypes dt=new Datatypes(5);
		dt.sampleMethod("Anusha");
				
	}
    public String sampleMethod(String name) {
        System.out.println("General method");
        System.out.println("My name is:"+name);
        
        ArrayList<String> arraylist = new ArrayList<String>();
        arraylist.add("Anusha");
        System.out.println(arraylist);
        return name;
        
        
    }
  
}

