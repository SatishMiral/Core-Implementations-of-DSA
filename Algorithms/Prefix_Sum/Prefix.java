package Algorithms.Prefix_Sum;
public class Prefix {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        
        int prefix = 0;

        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            nums[i] = prefix;
        }

        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
