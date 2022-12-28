package com.example.sudoku;

public class Solution {
	
	
    public boolean solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return false;
        return solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            //board[i][j] = c; //Put c for this cell
                            
                            //if(solve(board))
                                return true; //If it's the solution return true
                           // else
                               // board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

public static void main(String[] args) {
	
	Solution solution = new Solution();
	// TODO Auto-generated method stub
	
	char [] [] grid = {  {'7', '0', '0', '0', '0', '0', '2', '0', '2'},   
	          {'4', '0', '2', '0', '0', '0', '0', '0', '3'},   
	          {'0', '0', '0', '2', '0', '1','0', '0', '0'},   
	          {'3', '0', '0', '1', '8', '0', '0', '9', '7'},   
	          {'0', '0', '9', '0', '7', '0', '6', '0', '0'},   
	          {'6', '5', '0', '0', '3', '2', '0', '0', '1'},   
	          {'0', '0','0', '4', '0', '9', '7', '0', '0'},   
	          {'5', '0', '0', '0', '0', '0', '1', '0', '6'},   
	          {'0', '0', '6', '0', '0', '0', '8', '0', '5'}   
	       };
	
	 boolean result = solution.solveSudoku(grid);
	
	 System.out.println("Result: " + result);

		
}

}


