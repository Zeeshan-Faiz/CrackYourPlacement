package HeapPriorityQueue.MediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/

public class Q347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        //count the frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //add the most frequent elements in the respective bucket
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int pos = 0;

        //traverse the bucket and get the k most frequent elements
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;
    }
}