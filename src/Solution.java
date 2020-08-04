import java.util.*;

class Solution {

    // Describe:
    // This can be solved using recursion.
    // Step 1: Find a number that is not used
    // Step 2: Keep doing that until we used up all possibilities
    //
    // Example:
    // Input: [1, 2, 3]
    // Output: [[1, 2, 3], [1, 3, 2], [2, 3, 1], [2, 1, 3], [3, 1, 2], [3, 2, 1]]
    // 
    // Backtracking:
    //                           []
    //         [1]               [2]             [3]
    //      [2]   [3]         [3]   [1]        [1]  [2]
    //    [3]        [2]    [1]      [3]    [2]      [1]
    //
    // Time Complexity : O(n!)
    // Space Complexity : O(n)
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        // recursive helper method
        helper(nums, new ArrayList<>(), result, new boolean[nums.length]);

        return result;
    }

    private static void helper(int[] nums,
                               List<Integer> permutation,
                               List<List<Integer>> result,
                               boolean[] used) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                permutation.add(nums[i]);
                used[i] = true;
                helper(nums, permutation, result, used);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
