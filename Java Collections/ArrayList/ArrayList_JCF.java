package ArrayList;
import java.util.ArrayList;

public class ArrayList_JCF {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // add(E e) – Add elements at the end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Initial list: " + fruits);

        // add(int index, E element) – Insert at specific position
        fruits.add(1, "Mango");
        System.out.println("After adding Mango at index 1: " + fruits);

        // get(int index) – Access element
        String secondFruit = fruits.get(2);
        System.out.println("Element at index 2: " + secondFruit);

        // set(int index, E element) – Replace element
        fruits.set(2, "Orange");
        System.out.println("After setting index 2 to Orange: " + fruits);

        // remove(int index) – Remove by index
        fruits.remove(1);
        System.out.println("After removing element at index 1: " + fruits);

        // remove(Object o) – Remove by value
        fruits.remove("Apple");
        System.out.println("After removing 'Apple': " + fruits);

        // contains(Object o) – Check if element exists
        System.out.println("Contains 'Cherry'? " + fruits.contains("Cherry"));

        // indexOf(Object o)
        System.out.println("Index of 'Cherry': " + fruits.indexOf("Cherry"));

        // lastIndexOf(Object o) – if duplicates exist
        fruits.add("Cherry");
        System.out.println("List after adding duplicate 'Cherry': " + fruits);
        System.out.println("Last index of 'Cherry': " + fruits.lastIndexOf("Cherry"));

        // size()
        System.out.println("Size of list: " + fruits.size());

        // isEmpty()
        System.out.println("Is the list empty? " + fruits.isEmpty());

        // clear()
        fruits.clear();
        System.out.println("After clearing list: " + fruits);
        System.out.println("Is the list empty now? " + fruits.isEmpty());
    }
}
