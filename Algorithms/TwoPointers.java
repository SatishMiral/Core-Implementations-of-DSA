public class TwoPointers {
    public static void main(String[] args) {
        int[] nums = {1,5,4,3,4,5};

        int start = 0;
        int end = nums.length - 1;
        boolean isPalindrome = true;

        while (start <= end) {
            if(nums[start] != nums[end]){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if(isPalindrome){
            System.out.println("The array is palindrome");
        }
        else{
            System.out.println("The array is not palindrome");
        }
    }
}
