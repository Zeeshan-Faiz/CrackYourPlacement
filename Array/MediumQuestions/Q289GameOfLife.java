package Array.MediumQuestions;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular 
automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live 
(represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors 
(horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia 
article):
    Any live cell with fewer than two live neighbors dies as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population.
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state is created by applying the above rules simultaneously to every cell in the current 
state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, 
return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
*/

public class Q289GameOfLife {

    private int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    public void gameOfLife(int[][] board) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int activeNeigh = getActiveNeigh(board, i, j);
                    if (activeNeigh < 2 || activeNeigh > 3)
                        board[i][j] = -2;
                } else if (board[i][j] == 0) {
                    int activeNeigh = getActiveNeigh(board, i, j);
                    if (activeNeigh == 3)
                        board[i][j] = 3;
                }
            }
        }
        updateBoard(board);
        return;
    }

    private int getActiveNeigh(int[][] board, int row, int col) {
        
        int activeNeigh = 0;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                    && (board[newRow][newCol] == 1 || board[newRow][newCol] == -2))
                activeNeigh++;
        }
        return activeNeigh;
    }

    private void updateBoard(int[][] board) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -2)
                    board[i][j] = 0;
                if (board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
}