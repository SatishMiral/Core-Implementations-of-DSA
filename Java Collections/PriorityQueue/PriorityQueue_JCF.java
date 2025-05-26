package PriorityQueue;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueue_JCF {
    public static void main(String[] args) {
        // MIN-HEAP (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(20);
        minHeap.add(3);  // same as offer()

        System.out.println("Min-Heap: " + minHeap); // elements not in order

        System.out.println("Peek (min): " + minHeap.peek());  // 3 (min element)
        System.out.println("Poll (min): " + minHeap.poll());  // removes 3
        System.out.println("Min-Heap after poll: " + minHeap);

        System.out.println("Contains 10? " + minHeap.contains(10)); // true
        System.out.println("Remove 5: " + minHeap.remove(5)); // true
        System.out.println("Size: " + minHeap.size());
        System.out.println("Is Empty? " + minHeap.isEmpty());

        System.out.println();

        // MAX-HEAP (using Comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);
        maxHeap.offer(3);

        System.out.println("Max-Heap: " + maxHeap);  // not sorted, but root is max
        System.out.println("Peek (max): " + maxHeap.peek());  // 20
        System.out.println("Poll (max): " + maxHeap.poll());  // removes 20
        System.out.println("Max-Heap after poll: " + maxHeap);
    }
}
