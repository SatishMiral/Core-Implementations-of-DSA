import java.util.Stack;

public class Stack_JCF {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // 1. push()
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack after push: " + stack); // [A, B, C]

        // 2. peek()
        System.out.println("Top element (peek): " + stack.peek()); // C

        // 3. pop()
        String popped = stack.pop();
        System.out.println("Popped: " + popped);         // C
        System.out.println("Stack after pop: " + stack); // [A, B]

        // 4. isEmpty()
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // 5. search()
        System.out.println("Search 'A': " + stack.search("A")); // 2 (from top)

        // 6. size()
        System.out.println("Size: " + stack.size()); // 2

        // 7. contains()
        System.out.println("Contains B? " + stack.contains("B")); // true

        // 8. get() — inherited from Vector
        System.out.println("Element at index 0: " + stack.get(0)); // A

        // 9. clear()
        stack.clear();
        System.out.println("After clear: " + stack); // []
    }
}
