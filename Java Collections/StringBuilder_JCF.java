import java.lang.StringBuilder; // Optional, auto-imported with java.lang
public class StringBuilder_JCF {
    public static void main(String[] args) {
        // 1. Constructors
        StringBuilder sb1 = new StringBuilder();                      // empty
        StringBuilder sb2 = new StringBuilder("OpenAI");          // initialized
        StringBuilder sb3 = new StringBuilder(50);           // custom capacity

        System.out.println("sb1: \"" + sb1 + "\", Capacity: " + sb1.capacity());
        System.out.println("sb2: \"" + sb2 + "\", Capacity: " + sb2.capacity());
        System.out.println("sb3: Capacity: " + sb3.capacity());

        // 2. append()
        sb1.append("Hello");
        sb1.append(" ");
        sb1.append("World");
        System.out.println("After append: " + sb1); // Hello World

        // 3. insert()
        sb1.insert(5, ",");
        System.out.println("After insert: " + sb1); // Hello, World

        // 4. delete()
        sb1.delete(5, 6);
        System.out.println("After delete: " + sb1); // Hello World

        // 5. deleteCharAt()
        sb1.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb1); // HelloWorld

        // 6. replace()
        sb1.replace(5, 10, "_Java");
        System.out.println("After replace: " + sb1); // Hello_Java

        // 7. reverse()
        sb1.reverse();
        System.out.println("After reverse: " + sb1); // avaJ_olleH

        // 8. reverse() again to get back
        sb1.reverse();
        System.out.println("After second reverse: " + sb1); // Hello_Java

        // 9. length()
        System.out.println("Length: " + sb1.length());

        // 10. charAt()
        System.out.println("Char at 1: " + sb1.charAt(1));

        // 11. setCharAt()
        sb1.setCharAt(6, '-');
        System.out.println("After setCharAt: " + sb1); // Hello-Java

        // 12. substring()
        System.out.println("Substring(6, 10): " + sb1.substring(6, 10)); // -Jav

        // 13. capacity()
        System.out.println("Current capacity: " + sb1.capacity());

        // 14. ensureCapacity()
        sb1.ensureCapacity(100);
        System.out.println("After ensureCapacity(100): " + sb1.capacity());

        // 15. trimToSize()
        sb1.trimToSize();
        System.out.println("After trimToSize(): " + sb1.capacity());

        // 16. toString()
        String result = sb1.toString();
        System.out.println("Final String: " + result);
    }
}
