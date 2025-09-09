// package Algorithms.Sorting;

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

    // -------------- Recursive Selection Sort ------------------
    public static void recSelectionSort(int[] nums, int i, int n) {
        // Base Case
        if (i == n - 1) return;

        // Find the index of the minimum element in the remaining array
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] < nums[minIdx]) {
                minIdx = j;
            }
        }

        // Swap the found minimum with the first element
        swap(nums, i, minIdx);

        // Recursively call for the rest of the array
        recSelectionSort(nums, i + 1, n);
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

    // -------------- Recursive Bubble Sort ------------------
    public static void recBubbleSort(int[] nums, int n){
        // Base Case
        if(n == 1) return;
        boolean didSwap = false;

        for(int i=0; i<=n-2; i++){
            if(nums[i] > nums[i+1]){
                swap(nums, i, i+1);
                didSwap = true;
            }
        }

        if(!didSwap){
            return;
        }

        recBubbleSort(nums, n-1);
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

    // -------------- Recursive Insertion Sort ------------------
    public static void recInsertionSort(int[] nums, int i, int n){
        // Base Case: i == n.
        if (i == n) return;

        int j = i;
        while (j > 0 && nums[j - 1] > nums[j]) {
            swap(nums, j-1, j);
            j--;
        }

        recInsertionSort(nums, i+1, n);
    }

    // -------------- Merge Sort ------------------
    // Divide and Merge
    public static void mergeSort(int[] nums, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (high + low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[k++] = nums[left++];
            }
            else{
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= high) {
            temp[k++] = nums[right++];
        }

        // Copy sorted values back to nums
        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    // -------------- Quick Sort ------------------
    // Pick a Pivot and Place it in its correct place in the array
    public static void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pIndex = partition(nums, low, high);
            quickSort(nums, low, pIndex-1);
            quickSort(nums, pIndex+1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low]; 
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && nums[i] <= pivot) {
                i++;
            }
            while (j >= low && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }

        // place pivot in correct position
        swap(nums, low, j);

        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {5,8,6,7,2};
        int n = nums.length;
        // selectionSort(nums);
        // bubbleSort(nums);
        // insertionSort(nums);
        // mergeSort(nums, 0, n-1);
        // printArray(nums);
        // quickSort(nums, 0, n-1);
        // printArray(nums);
        // recBubbleSort(nums, n);
        // recSelectionSort(nums, 0, n);
        recInsertionSort(nums, 1, n);
        printArray(nums);
    }
}
