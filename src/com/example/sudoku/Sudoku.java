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
		 
		 


		 boolean validSmallSquareVar1 = isValidSmallSquare(0, 2,board);
		 boolean validSmallSquareVar2 = isValidSmallSquare2(0, 5, board);
		 boolean validSmallSquareVar3 = isValidSmallSquare3(0, 8, board);
		 boolean validSmallSquareVar4 = isValidSmallSquare4(0, 5, board);
		 boolean validSmallSquareVar5 = isValidSmallSquare5(0, 5, board);
		 boolean validSmallSquareVar6 = isValidSmallSquare6(0, 8, board);
		 boolean validSmallSquareVar7 = isValidSmallSquare7(0, 8, board);
		 boolean validSmallSquareVar8 = isValidSmallSquare8(0, 8, board);
		 boolean validSmallSquareVar9 = isValidSmallSquare9(0, 8, board);
				

		 if(!(validSmallSquareVar1 && validSmallSquareVar2 && validSmallSquareVar3 && validSmallSquareVar4 
				 && validSmallSquareVar5 && validSmallSquareVar6 && validSmallSquareVar7 && validSmallSquareVar8 && validSmallSquareVar9 )) { //&& validSmallSquareSquare2)) {
//		 && validSmallSquareSquare3 &&
//				 validSmallSquareSquare4 && validSmallSquareSquare5 && validSmallSquareSquare6 &&
//				 validSmallSquareSquare7  && validSmallSquareSquare8 &&
//				 validSmallSquareSquare9)) {
			 
			 return false;
			 
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
	 
	 public boolean isValidSmallSquare(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
						 }
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare2(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i <= 2) {
						 if(j>= 3 && j<= 5) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }
					 }else {
						 break;
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare3(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i <= 2) {
						 if(j>= 6 && j<= 8) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }
					 }else {
						 break;
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare4(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i > 2) {
						 if(j>= 0 && j<= 2) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }
					 }else {
						 break;
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare5(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i > 2) {
						 if(j>= 3 && j<= 5) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }
					 }else {
						 break;
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare6(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i > 2 && i<=5) {
						 if(j>= 6) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }
					 }else {
						 break;
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare7(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i >= 6) {
						 if(j>= 0 && j<=2) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }else {
							 break;
						 }
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare8(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i >= 6) {
						 if(j>= 3 && j<=5) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
	 }
	 
	 public boolean isValidSmallSquare9(int startPosition, int endPosition, int[][] board){
		 List<Integer> numPerSmallSquare = new ArrayList<Integer>();
		 Set<Integer> numPerSmallSquareUnique = new HashSet<Integer>();
		  
			 for(int i=startPosition ; i<=endPosition; i++){
				 for(int j=startPosition; j<=endPosition;j++) {
					 if(i >= 6) {
						 if(j>= 6 && j<=8) {
							if(isValidNum(board[i][j])) {
							 numPerSmallSquare.add(board[i][j]);
							 numPerSmallSquareUnique.add(board[i][j]);
							}
						 }
					 }		
					 
					 }
				 } 
		 if(numPerSmallSquare.size() != numPerSmallSquareUnique.size()) {
			 
			 return false;
		 }
		 
		 
		 return true;
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
		          {0, 0, 0, 4, 0, 9, 7, 0, 0},   
		          {5, 0, 0, 0, 0, 0, 1, 0, 6},   
		          {0, 0, 6, 0, 0, 0, 8, 0, 5}   
		       };
		
		boolean result = sudoku.isValidSudoku(grid);
		
		
		System.out.println("Valid sudoku?: " + result);

	}

}
