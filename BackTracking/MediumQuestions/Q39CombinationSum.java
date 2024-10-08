package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of 
all unique combinations of candidates where the chosen numbers sum to target. You may return 
the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations 
are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target 
is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
*/

public class Q39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> list) {

        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (arr[ind] <= target) {
            list.add(arr[ind]);
            helper(ind, arr, target - arr[ind], ans, list);// pick same element
            list.remove(list.size() - 1); // backtrack if the picked element didn't help to reach target
        }
        // pick next element
        helper(ind + 1, arr, target, ans, list);
    }
}