package DynamicProgramming.MediumQuestions;

import java.util.Arrays;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner 
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take 
to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
*/

public class Q62UniquePaths {

    public int uniquePaths(int m, int n) {

        // Create a 2D DP array to store the results
        int dp[][] = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the bottom-right cell (m-1, n-1)
        return helper(m - 1, n - 1, dp);
    }

    public int helper(int i, int j, int[][] dp) {
        
        // If we reach the target cell (0, 0) return 1.
        if (i == 0 && j == 0)
            return 1;

        if (i < 0 || j < 0)
            return 0;

        // If the value for this cell is already computed, return it.
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of ways by moving up and moving left.
        int up = helper(i - 1, j, dp);
        int left = helper(i, j - 1, dp);

        // Store the result in the DP array and return it.
        return dp[i][j] = up + left;
    }
}