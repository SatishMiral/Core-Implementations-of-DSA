package HashSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Demonstrates usage of HashSet, TreeSet, and LinkedHashSet in Java.
 * Includes common operations with their time complexities (average case).
 */
public class HashSet_JCF {
    public static void main(String[] args) {

        // ------------------ HashSet ------------------
        // Unordered collection, allows unique elements, backed by HashMap.
        HashSet<Integer> hashSet = new HashSet<>();

        // Insert element -> O(1) average
        hashSet.add(10);
        hashSet.add(5);
        hashSet.add(20);

        // Search (contains) -> O(1) average
        System.out.println("HashSet contains 10: " + hashSet.contains(10));

        // Remove -> O(1) average
        hashSet.remove(5);

        // Traversal -> O(n)
        System.out.println("HashSet elements (unordered): " + hashSet);


        // ------------------ TreeSet ------------------
        // Sorted collection, unique elements, implemented using Red-Black Tree.
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Insert -> O(log n)
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(20);

        // Search -> O(log n)
        System.out.println("TreeSet contains 20: " + treeSet.contains(20));

        // Remove -> O(log n)
        treeSet.remove(5);

        // Traversal (Sorted order) -> O(n)
        System.out.println("TreeSet elements (sorted): " + treeSet);

        // Extra TreeSet operations
        System.out.println("Smallest element in TreeSet: " + treeSet.first()); // O(log n)
        System.out.println("Largest element in TreeSet: " + treeSet.last());   // O(log n)


        // ------------------ LinkedHashSet ------------------
        // Maintains insertion order, unique elements, backed by HashMap + LinkedList.
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        // Insert -> O(1) average
        linkedHashSet.add(10);
        linkedHashSet.add(5);
        linkedHashSet.add(20);

        // Search -> O(1) average
        System.out.println("LinkedHashSet contains 5: " + linkedHashSet.contains(5));

        // Remove -> O(1) average
        linkedHashSet.remove(20);

        // Traversal (in insertion order) -> O(n)
        System.out.println("LinkedHashSet elements (insertion order): " + linkedHashSet);

    }
}
