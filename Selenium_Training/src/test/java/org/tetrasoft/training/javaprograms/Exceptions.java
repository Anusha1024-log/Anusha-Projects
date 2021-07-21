package org.tetrasoft.training.javaprograms;

import java.util.Scanner;

public class Exceptions {
	double answer;
	
	Exceptions(double a,double b){
		try {
		answer = a/b;
		System.out.println(answer);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        double a, b;

        a = sc.nextDouble();

        b = sc.nextDouble();

        Exceptions exp = new Exceptions(a,b);

	}
}
