package com.example.sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sudoku {
	
	 public boolean isValidSudoku(int[][] board) {
		 
		 Map<Integer,Set<Integer>> uniqueValuesSquareRow = new HashMap<Integer,Set<Integer>>();
		 Set<Integer> uniqueValuesPerRow = new HashSet<Integer>();
		 Map<Integer,Set<Integer>> uniqueValuesSquareColumn = new HashMap<Integer,Set<Integer>>();
		 Set<Integer> uniqueValuesPerColumn = new HashSet<Integer>();
		 Map<Integer, List<Integer>> rowSquare = new HashMap<Integer,List<Integer>>();
		 Map<Integer, List<Integer>> columnSquare = new HashMap<Integer,List<Integer>>();
		 int col = 0;
		 for(int i = 0 ; i< 9; i++) {
			 List<Integer> row = new ArrayList<Integer>();
			 List<Integer> column= new ArrayList<Integer>(); 
			 uniqueValuesPerRow = new HashSet<Integer>();
			 uniqueValuesPerColumn = new HashSet<Integer>();
			 for(int j = 0 ; j< 9; j++) {
				 
				 if(isValidNum(board[i][j])) {
					 row.add(board[i][j]);
					 uniqueValuesPerRow.add(Integer.valueOf(board[i][j]));
//					 System.out.println("Row: " +i);
//					 System.out.println(board[i][j]);
//					 System.out.println("sizeRow= " +row.size());
//					 System.out.println("uniqueValue= " +uniqueValuesPerRow.size());
				 }
				 
				 if(isValidNum(board[j][i])) {
					 column.add(Integer.valueOf(board[j][i]));
					 uniqueValuesPerColumn.add(Integer.valueOf(board[j][i]));
					 
//					 System.out.println("Col: " +i);
//					 System.out.println(board[j][i]);
					  
				 }
				 
			 }
			 rowSquare.put(i,row);
			 columnSquare.put(col,column);
			 uniqueValuesSquareRow.put(i, uniqueValuesPerRow);
			 uniqueValuesSquareColumn.put(col, uniqueValuesPerColumn);
			 col++;
		 }
		 
		 
		 for(Integer key: uniqueValuesSquareRow.keySet()) {
			 if(uniqueValuesSquareRow.get(key).size() != rowSquare.get(key).size()) {
				 return false;
			 }
			 if(uniqueValuesSquareColumn.get(key).size() != columnSquare.get(key).size()) {
				 return false;
			 }
			 
		 }
		 
		  
		 return true;
	 }
	 
	 public boolean isValidNum(int number) {
		  if(number >0 && number<=9){
	            return true;
	        }else{
	            return false;
	        } 
	 }
	 
	
	
	

	public static void main(String[] args) {
		
		Sudoku sudoku = new Sudoku();
		// TODO Auto-generated method stub
		
		int [] [] grid = {  {7, 0, 0, 0, 0, 0, 2, 0, 0},   
		          {4, 0, 2, 0, 0, 0, 0, 0, 3},   
		          {0, 0, 0, 2, 0, 1, 0, 0, 0},   
		          {3, 0, 0, 1, 8, 0, 0, 9, 7},   
		          {0, 0, 9, 0, 7, 0, 6, 0, 0},   
		          {6, 5, 0, 0, 3, 2, 0, 0, 1},   
		          {0, 0, 0, 4, 0, 9, 5, 0, 0},   
		          {5, 0, 0, 0, 0, 0, 1, 0, 6},   
		          {0, 0, 6, 0, 0, 0, 8, 0, 5}   
		       };
		
		boolean result = sudoku.isValidSudoku(grid);
		
		
		System.out.println("Result: " + result);

	}

}
