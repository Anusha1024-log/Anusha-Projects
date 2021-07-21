package org.tetrasoft.training.javaprograms;

import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class RemoveDuplicatesArray {

	public static void main(String[] args) {
		removeDuplicates();
		stringSortandDuplicates();
	
	}
		// TODO Auto-generated method stub
		
		public static void removeDuplicates() {
		int arr[] = {10,10,20,50,50,5,5};
		
		//LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		
		SortedSet<Integer> set2 = new TreeSet<Integer>();
		
		for(int i=0;i<arr.length;i++) 
		
		set2.add(arr[i]);
		
		System.out.println(set2);
		

		}
		
		public static void stringSortandDuplicates() {
			 String ar[]= {"Anusha","Naresh","Anusha","Naresh","Hanvith"};
			 
			 SortedSet<String> set = new TreeSet<String>();
			 
			 for(int i=0;i<ar.length;i++)
				 
				 set.add(ar[i]);
			 
			 System.out.println(set);
		}

}
