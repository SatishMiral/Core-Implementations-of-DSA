import java.lang.Math;

public class Math_JCF {
    public static void main(String[] args) {
        int a = -7;
        double x = 3.14;

        System.out.println("abs: " + Math.abs(a));             // 7
        System.out.println("ceil: " + Math.ceil(x));           // 4.0
        System.out.println("floor: " + Math.floor(x));         // 3.0
        System.out.println("round: " + Math.round(x));         // 3
        System.out.println("max: " + Math.max(10, 20));        // 20
        System.out.println("pow: " + Math.pow(2, 3));          // 8.0
        System.out.println("sqrt: " + Math.sqrt(16));          // 4.0
        System.out.println("random (0-1): " + Math.random());  // e.g., 0.75432

        double deg = 90;
        double rad = Math.toRadians(deg);
        System.out.println("sin(90°): " + Math.sin(rad));      // 1.0
    }
}
