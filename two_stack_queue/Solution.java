import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 Method 1:  enQueue costly, but deQueue fast .... items in output stack most of time;
 enQueue(q, x)
  1) While stack1 is not empty, push everything from satck1 to stack2.
  2) Push x to stack2 (assuming size of stacks is unlimited).
  3) Push everything back to stack1.

 deQueue(q)
  1) If stack1 is empty then error
  2) Pop an item from stack1 and return it
*/

/*
 Method 2: enQueue fast, but occasionally deQueue needs a shift ......  items in both stacks most of time
 enQueue(q,  x)
   1) Push x to stack1 (assuming size of stacks is unlimited).

 deQueue(q)
   1) If both stacks are empty then error.
   2) If stack2 is empty --> note: we do shift only at this necessary one time
        While stack1 is not empty, push everything from stack1 to stack2.
   3) Pop the element from stack2 and return it.

  Mehtod 2 is clearly winner, as the shift only happens occasionally when neccessary, and most of time, both stacks serve their purpose properly.
*/

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if( stackNewestOnTop.empty() && stackOldestOnTop.empty() )
                return null;

            switchStack();

            return stackOldestOnTop.peek();
        }


        public T dequeue() {
            if( stackNewestOnTop.empty() && stackOldestOnTop.empty() )
                return null;

            switchStack();

            return stackOldestOnTop.pop();
        }

        // NOTE: we only do the shift when "stackOldestOnTop" is empty;
        // otherwise, we can continue serving from "stackOldestOnTop"
        // pop all from stackNewestOnTop, and push to stackOldestOnTop
        private void switchStack() {
            // we don't have anything in output stack,
            // but has things in input stack now, shift all of them
            if( stackOldestOnTop.empty() && !stackNewestOnTop.empty()) {
                while( ! stackNewestOnTop.empty() )
                    stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
