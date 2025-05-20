import java.util.LinkedList;

public class LL_JCF {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("Initial list: " + list);

        // Add element at specific index
        list.add(1, "Mango");
        System.out.println("After adding Mango at index 1: " + list);

        // Get element at index
        String fruit = list.get(2);
        System.out.println("Element at index 2: " + fruit);

        // Set (replace) element at index
        list.set(2, "Orange");
        System.out.println("After setting index 2 to Orange: " + list);

        // Remove element by index
        list.remove(1);
        System.out.println("After removing element at index 1: " + list);

        // Remove element by value
        list.remove("Apple");
        System.out.println("After removing 'Apple': " + list);

        // Check size
        System.out.println("List size: " + list.size());

        // Check if list contains an element
        System.out.println("Contains 'Cherry'? " + list.contains("Cherry"));

        // Check if list is empty
        System.out.println("Is list empty? " + list.isEmpty());

        // Clear all elements
        list.clear();
        System.out.println("After clearing: " + list);
    }
}
