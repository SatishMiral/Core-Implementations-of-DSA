// Imports
import java.util.HashMap;
import java.util.Map;

public class HashMap_JCF {
    public static void main(String[] args) {
        // Create a HashMap of employee ID (Integer) to name (String)
        HashMap<Integer, String> employeeMap = new HashMap<>();

        // Group A: put(), get(), containsKey(), containsValue(), size(), isEmpty(), remove(), clear()
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");

        System.out.println("Initial Map: " + employeeMap);

        // get()
        System.out.println("Employee with ID 102: " + employeeMap.get(102));

        // containsKey()
        System.out.println("Map contains key 103? " + employeeMap.containsKey(103));

        // containsValue()
        System.out.println("Map contains value 'Bob'? " + employeeMap.containsValue("Bob"));

        // remove()
        employeeMap.remove(101);
        System.out.println("After removing ID 101: " + employeeMap);

        // size() and isEmpty()
        System.out.println("Map size: " + employeeMap.size());
        System.out.println("Is map empty? " + employeeMap.isEmpty());

        // Group B: keySet(), values(), entrySet()
        System.out.println("All Keys: " + employeeMap.keySet());
        System.out.println("All Values: " + employeeMap.values());

        System.out.println("All Entries:");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        // Group C: putIfAbsent()
        employeeMap.putIfAbsent(104, "Diana"); // adds because key 104 doesn't exist
        employeeMap.putIfAbsent(102, "Eve");   // won't overwrite existing value
        System.out.println("After putIfAbsent: " + employeeMap);

        // clear()
        employeeMap.clear();
        System.out.println("After clear(): " + employeeMap);
    }
}
