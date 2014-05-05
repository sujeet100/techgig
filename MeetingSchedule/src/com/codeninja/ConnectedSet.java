package com.codeninja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectedSet {
	static int dimention;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(in.readLine());
		for (int i=0; i<noOfTestCases; i++) {
			dimention = Integer.parseInt(in.readLine());
			int [][]matrix = new int[dimention][dimention];
			for(int j=0; j<dimention; j++){
				String inputLine = in.readLine();
				String[] split = inputLine.split(" ");
				for (int k=0; k<dimention; k++) {
					matrix[j][k] = Integer.parseInt(split[k]);
				}
			}
			
			//process
			int sets =0 ;
			for(int row =0 ;row<dimention; row++){
				for(int col=0;col<dimention;col++){
					if(matrix[row][col] == 1){
						sets++;
						checkNeigbour(matrix, row, col);
					}
					
				}
			}
			System.out.println(sets);
		}
		
	
	}
	private static void checkNeigbour(int[][] matrix, int row, int col) {
		//up
		if(row != 0 && matrix[row-1][col] == 1){
			matrix[row-1][col] =0;
			checkNeigbour(matrix, row-1, col);
		}
		
		//down
		if(row!=dimention-1 && matrix[row+1][col] == 1){
			matrix[row+1][col] =0;
			checkNeigbour(matrix, row+1, col);
		}
		//left
		if(col!=0 && matrix[row][col-1] == 1){
			matrix[row][col-1] =0;
			checkNeigbour(matrix, row, col-1);
		}
		
		//right
		if(col!=dimention-1 && matrix[row][col+1] == 1){
			matrix[row][col+1] =0;
			checkNeigbour(matrix, row, col+1);
		}
		
		//left-up
		if(row!=0 && col!=0 && matrix[row-1][col-1] == 1){
			matrix[row-1][col-1] =0;
			checkNeigbour(matrix, row-1, col-1);
		}
		//right up
		if(row!=0 && col!=dimention-1 && matrix[row-1][col+1] == 1){
			matrix[row-1][col+1] =0;
			checkNeigbour(matrix, row-1, col+1);
		}
		
		//left down
		if(row!=dimention-1 && col!=0 && matrix[row+1][col-1] == 1){
			matrix[row+1][col-1] =0;
			checkNeigbour(matrix, row+1, col-1);
		}
		//right down
		if(row!=dimention-1 && col!=dimention-1 && matrix[row+1][col+1] == 1){
			matrix[row+1][col+1] =0;
			checkNeigbour(matrix, row+1, col+1);
		}
	}
}
