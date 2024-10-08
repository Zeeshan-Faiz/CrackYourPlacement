package BackTracking.HardQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two 
queens attack each other. Given an integer n, return all distinct solutions to the n-queens puzzle. 
You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and 
'.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
*/

public class Q51NQueens {

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        //create an empty board
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        helper(0, board, res);
        return res;
    }

    static void helper(int col, char[][] board, List<List<String>> res) {
        
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                helper(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    static List<String> construct(char[][] board) {
        
        List<String> list = new LinkedList<String>();
        //convert character board to String and add in res list
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }

    static boolean validate(char[][] board, int row, int col) {
        
        int duprow = row;
        int dupcol = col;

        //check for upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        //check for left 
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        //check for left lower diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true;
    }
}