import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RunningMedianSolution {

    static PriorityQueue<Integer> maxHeap = null;
    static PriorityQueue<Integer> minHeap = null;

    static void addInput(int num) {
        // to ensure maxHeap to have lower half
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // make sure maxHeap size is larger than or equal to minHeap
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

        if(maxHeap.size() == minHeap.size()){
            double result = (double)(maxHeap.peek()+(minHeap.peek()))/2;
            System.out.printf( "%.1f\n", result );
        }
        else {
            System.out.printf( "%.1f\n", (double)maxHeap.peek() );
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        // holds max heap for smaller number, with max at the top
        maxHeap = new PriorityQueue<Integer>(n,Collections.reverseOrder());
        // holds min heap for larger number, with min at the top 
        minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;

            addInput(aItem);
        }

        scanner.close();
    }
}
