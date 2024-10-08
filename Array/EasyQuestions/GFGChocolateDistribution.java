package Array.EasyQuestions;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an array A[ ] of positive integers of size N, where each value represents the number of 
chocolates in a packet. Each packet can have a variable number of chocolates. There are M 
students, the task is to distribute chocolate packets among M students such that :
    1. Each student gets exactly one packet.
    2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

Example 1:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.

Example 2:
N = 7, M = 3
A = {7, 3, 2, 4, 9, 12, 56}
Output: 2
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing following M packets :{3, 2, 4}.
*/

public class GFGChocolateDistribution {

    public long findMinDiff(ArrayList<Integer> a, int n, int m) {

        Collections.sort(a);
        long min = Long.MAX_VALUE;
        int i = 0, j = m - 1;

        while (j < n) 
        {
            long diff = a.get(j) - a.get(i);
            min = Math.min(min, diff);
            i++;
            j++;
        }
        return min;
    }
}