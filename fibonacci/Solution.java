import java.util.*;

public class Solution {

    // 1. recursive, but slow
    public static int fibonacci(int n) {
        if( n < 2) return n;

        // This is very slow, as fibonacci(k) will be called many times
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // 2. recursive approach, with cache to improve performance
    static int[] cache;
    public static int fibonacci_fast(int n) {
        if( n < 2) return n;

        // using cache to improve performance
        if( cache[n] > 0 ) {
            return cache[n];
        }
        int result = fibonacci_fast(n-1) + fibonacci_fast(n-2);
        cache[n] = result;

        return result;
    }

    // 3. iterative approach;
    public static int fibonacci_iteration(int n) {
        cache[0] = 0;
        cache[1] = 1;

        for( int i=2; i <= n; i++ ) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        cache = new int[n+1];
        System.out.println(fibonacci(n));
    }
}
