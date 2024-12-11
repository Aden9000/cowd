package Compilation;
import java.util.*;
public class Largest {
    public static void largest(String ... args) {
        Scanner keyboard = new Scanner(System.in);
        int x, y, z;

        System.out.println("Enter 3 numbers:");
        x = keyboard.nextInt();
        y = keyboard.nextInt();
        z = keyboard.nextInt();

        if (y > x)
            x = y;

        if (z > x)
            x = z;

        System.out.println("["+x+ "] is the largest number.");
    }
}

