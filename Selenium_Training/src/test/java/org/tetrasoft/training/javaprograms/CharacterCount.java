package org.tetrasoft.training.javaprograms;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "AnushaMorampudi";
		characterCount(name);

	}
	public static void characterCount(String inputString)
	{
		HashMap<Character,Integer> charCountMap = new HashMap<Character,Integer>();//generics(key,value)

		char[] strArray = inputString.toCharArray();

		for(char c: strArray)
		{	
			if(charCountMap.containsKey(c))
			{
				charCountMap.put(c, charCountMap.get(c)+1);
			}
			else
				charCountMap.put(c,1);
		}
		
		for(Map.Entry m : charCountMap.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}

}
