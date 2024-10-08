package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return 
the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
*/

public class Q46Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, List<List<Integer>> ans, ArrayList<Integer> list) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip if we get same element
            if (list.contains(nums[i]))
                continue;

            list.add(nums[i]);
            helper(nums, ans, list);
            // Backtrack and Remove the picked element
            list.remove(list.size() - 1);
        }
    }
}