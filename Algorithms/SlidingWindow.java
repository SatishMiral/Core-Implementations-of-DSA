import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int k = 3;

        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0, windowSum = 0;

        while(right < nums.length){
            windowSum += nums[right];
            if (right - left + 1 == k) {
                result.add(windowSum);
                windowSum -= nums[left];
                left++;
            }
            right++;
        }

        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}

// import java.util.*;

// class Solution {
//     public int[] windowSums(int[] nums, int k) {
//         int n = nums.length;
//         if (n < k) return new int[0]; // Edge case: not enough elements for one window

//         int[] result = new int[n - k + 1];
//         int windowSum = 0;

//         // Compute sum of first window
//         for (int i = 0; i < k; i++) {
//             windowSum += nums[i];
//         }
//         result[0] = windowSum;

//         // Slide the window
//         for (int i = k; i < n; i++) {
//             windowSum += nums[i] - nums[i - k]; // Add new element, remove old
//             result[i - k + 1] = windowSum;
//         }

//         return result;
//     }
// }