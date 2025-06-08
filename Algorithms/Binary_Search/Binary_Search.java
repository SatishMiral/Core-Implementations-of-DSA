package Binary_Search;

import java.util.Arrays;

public class Binary_Search {
    public static int search(int[] nums, int num){
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = end + start / 2;

            if(nums[mid] == num){
                return mid;
            }
            else if(nums[mid] > num){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        int numToSearch = 2;

        int idx = search(nums, numToSearch);

        System.out.println(idx);
    }
}
