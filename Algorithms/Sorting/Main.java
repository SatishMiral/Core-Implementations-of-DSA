package Algorithms.Sorting;

public class Main {
    public static void printArray(int[] nums){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    // -------------- Selection Sort ------------------
    // Selects the Minimum 
    public static void selectionSort(int[] nums){
        int n = nums.length;
        for(int i=0; i<=n-2; i++){
            int minIdx = i;
            for(int j=i+1; j<=n-1; j++){
                if(nums[j] < nums[minIdx]){
                    minIdx = j;
                }
            }
            int temp = nums[minIdx];
            nums[minIdx] = nums[i];
            nums[i] = temp;
        }

        printArray(nums);
    }

    // -------------- Bubble Sort ------------------
    // Pushes the max element to the last index
    public static void bubbleSort(int[] nums){
        int n = nums.length;
        boolean didSwap = false;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    didSwap = true;
                }
            }
            if(didSwap == false){
                break;
            }
        }

        printArray(nums);
    }

    // -------------- Insertion Sort ------------------
    // Takes an element and places it in its correct position
    public static void insertionSort(int[] nums){
        int n = nums.length;
        for(int i=1; i<n; i++){
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]){
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }

        printArray(nums);
    }

    public static void main(String[] args) {
        int[] nums = {5,8,6,7,2};
        selectionSort(nums);
        bubbleSort(nums);
        insertionSort(nums);
    }
}
