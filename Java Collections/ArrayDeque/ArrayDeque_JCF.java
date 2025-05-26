package ArrayDeque;
import java.util.ArrayDeque;
// Core Deque Methods
// Category	Methods
// Insert front	addFirst(e), offerFirst(e)
// Insert rear	addLast(e), offerLast(e)
// Remove front	removeFirst(), pollFirst()
// Remove rear	removeLast(), pollLast()
// Peek front	getFirst(), peekFirst()
// Peek rear	getLast(), peekLast()
// Size/Check	size(), isEmpty()
// Other	clear(), contains(o), iterator()

public class ArrayDeque_JCF {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        // Push elements (LIFO)
        stack.push("A"); // -> addLast(e)
        stack.push("B");
        stack.push("C");

        System.out.println("Stack: " + stack); // [C, B, A] 

        // Peek top
        System.out.println("Top element: " + stack.peek()); // C -> getLast()

        // Pop element
        System.out.println("Popped: " + stack.pop()); // C -> removeLast()
        System.out.println("After pop: " + stack);    // [B, A]

        // Size & check
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());

        ArrayDeque<String> queue = new ArrayDeque<>();

        // Add to rear (FIFO)
        queue.offer("A"); // -> addLast(e)
        queue.offer("B");
        queue.offer("C");

        System.out.println("Queue: " + queue); // [A, B, C]

        // Peek front
        System.out.println("Front element: " + queue.peek()); // A -> getFirst()

        // Poll (remove) front
        System.out.println("Polled: " + queue.poll()); // A -> removeFirst()
        System.out.println("After poll: " + queue);    // [B, C]

        // Size & check
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty? " + queue.isEmpty());
    }
}