package com.codeninja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Integer noOfTests = Integer.parseInt(in.readLine());
		for (int i = 0; i < noOfTests; i++) {
			int number = Integer.parseInt(in.readLine());

			int fibNumber = 1;
			int fibNumberPrev = 1;
			while (true) {
				int anotherNumber = 2;
				int temp = fibNumber;
				fibNumber = fibNumber + fibNumberPrev;
				fibNumberPrev = temp;
				if(fibNumber < 30)
				System.out.println("fib: "+fibNumber);
				while (!(number % anotherNumber== 0 && fibNumber % anotherNumber == 0) && anotherNumber < number)
					anotherNumber++;
				
				if(fibNumber % anotherNumber == 0 && number % anotherNumber == 0){
					System.out.print(fibNumber);
					System.out.print(" " + anotherNumber + "\n");
					break;
				}

			}
		}
	}
}
