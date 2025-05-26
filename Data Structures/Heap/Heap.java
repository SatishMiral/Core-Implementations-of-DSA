public class Heap {
    public static class MaxHeap {
        // Get the variables
        private int[] nums;
        private int capacity;
        private int idx;

        // Initialize the MaxHeap
        public MaxHeap(int capacity){
            this.capacity = capacity;
            this.nums = new int[capacity];
            this.idx = 0;
        }

        // Get Parent, Left Child & Right Child
        private int Parent(int i){ return (i -1) / 2;} 
        private int Left(int i){ return 2 * i + 1;}
        private int Right(int i){ return 2 * i + 2;}

        public boolean isEmpty() {
            return idx == 0;
        }

        public boolean isFull() {
            return idx == capacity;
        }

        public int peek(){
            if(isEmpty()) {
                throw new RuntimeException("Heap is Empty");
            }

            return nums[0];
        }

        public void insert(int val){
            if(isFull()) {
                throw new RuntimeException("Heap is full");
            }

            // Insert the value at the end of the heap
            nums[idx] = val;
            heapifyUp(idx);
            idx++;
        }

        public void heapifyUp(int i){
            while (i > 0 && nums[Parent(i)] < nums[i]) { // if parent element is smaller than child then swap
                swap(Parent(i), i);
                i = Parent(i);
            }
        }

        public int remove(){
            if (isEmpty()) throw new IllegalStateException("Heap is empty");
            // Get the root
            int root = nums[0];

            // Replace it with last element
            nums[0] = nums[idx - 1];
            idx--;

            // Heapify Down
            heapifyDown(0);
            return root;
        }

        public void heapifyDown(int i) {
            while (true) {
                int left = Left(i);
                int right = Right(i);
                int largest = i;

                if (left < idx && nums[left] > nums[largest]) {
                    largest = left;
                }

                if (right < idx && nums[right] > nums[largest]) {
                    largest = right;
                }

                if (largest != i) {
                    swap(i, largest);
                    i = largest; // move down
                } else {
                    break; // heap property is satisfied
                }
            }
        }

        public void buildHeap(int[] arr) {
            if (arr.length > capacity) {
                throw new IllegalArgumentException("Array size exceeds heap capacity");
            }

            // Copy all elements to the heap
            for (int i = 0; i < arr.length; i++) {
                nums[i] = arr[i];
            }

            idx = arr.length;

            // Apply heapify from the last non-leaf node to the root
            for (int i = Parent(idx - 1); i >= 0; i--) {
                heapifyDown(i);
            }
        }

        public void swap(int parent, int i){
            int temp = nums[parent];
            nums[parent] = nums[i];
            nums[i] = temp;
        }
    }

    public static class MinHeap {
        private int[] nums;
        private int capacity;
        private int idx;
        
        public MinHeap(int capacity){
            this.capacity = capacity;
            this.nums = new int[capacity];
            this.idx = 0;
        }

        private int getParent(int i){ return (i  - 1) / 2;}
        private int getLeft(int i){ return 2 * i + 1;}
        private int getRight(int i){ return 2 * i + 2;}

        public Boolean isFull(){
            return idx == capacity;
        }

        public Boolean isEmpty(){
            return idx == 0;
        }

        public int peek(){
            if (isEmpty()) {
                throw new RuntimeException ("Heap Is Empty");
            }
            return nums[0];
        }

        public void insert(int data){
            if (isFull()) {
                throw new RuntimeException ("Heap Is Full");
            }
            nums[idx] = data;
            heapifyUp(idx);
            idx++;
        }

        public void heapifyUp(int i){
            while (i > 0 && nums[getParent(i)] > nums[i]) {
                swap(i, getParent(i));
                i = getParent(i);
            }
        }

        public int remove(){
            if(isEmpty()){
                throw new RuntimeException("Heap Is Empty");
            }
            int root = nums[0];
            nums[0] = nums[idx - 1];
            idx--;
            heapifyDown(0);
            return root;
        }

        public void heapifyDown(int i){
            while (true) {
                int smallest = i;
                int left = getLeft(i);
                int right = getRight(i);

                if(left < idx && nums[left] < nums[smallest]){
                    smallest = left;
                }

                if(right < idx && nums[right] < nums[smallest]){
                    smallest = right;
                }

                if(i != smallest){
                    swap(i, smallest);
                    i = smallest;
                }
                else{
                    break;
                }
            }
        }

        public void buildHeap(int[] arr){
            if(arr.length > capacity){
                throw new RuntimeException("The Array Size is larger than Heap");
            }

            for(int i=0; i<arr.length; i++){
                nums[i] = arr[i];
            }

            for(int i=getParent(nums.length-1); i>=0; i--){
                heapifyDown(i);
            }
        }

        public void swap(int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(5);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        heap.insert(10);
        heap.insert(8);
        System.out.println(heap.peek());

        MinHeap h = new MinHeap(5);
        h.insert(2);
        h.insert(10);
        h.insert(3);
        h.insert(5);
        h.insert(9);
        System.out.println(h.peek());

        h.buildHeap(new int[]{1,2,3,0,4});
        System.out.println(h.peek());
        System.out.println(h.remove());
        System.out.println(h.remove());
    }
}