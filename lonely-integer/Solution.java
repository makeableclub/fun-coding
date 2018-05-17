import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // RXIE explanation
        //
        // XOR properties:
        // 1. a number XOR with 0 is itself
        // 2. a number XOR with itself is 0, which cancels out
        // 3. commutative: a^b = b^a
        // 4. associative: a^(b^c) = (a^b)^c

        int lonelyNumber = 0;

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
            
            // all pairs cancel out, leaving the lonely one XOR with 0
            lonelyNumber ^= aItem;
        }

        System.out.println(lonelyNumber);

        scanner.close();
    }
}
