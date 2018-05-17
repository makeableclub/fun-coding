import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Problem statement:

A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
*/

public class Solution {

    /*
     * Get word count from each word in magazine, and put them in HashMap
     * Go through ransom note, and use it one by one by decreasing word count in magazine hashmap for that word;
     * until "no such word", or "no more word" in the magazine hashmap -> false
     * otherwise, true
     */
    static boolean canCreateNote(String[] m, String[] n) {
        HashMap magazine = new HashMap<String, Integer>();

        // get word count for magazine
        for( int i=0; i < m.length; i++ ) {
            if( magazine.get(m[i]) != null ) {
                int increment = (int)magazine.get(m[i]) + 1;
                magazine.put(m[i], increment);
            }
            else {
                magazine.put(m[i], 1);
            }
        }
        // we will use words from magazine (decrement), if not exists or reach -1,
        // not enough words!
        for( int i=0; i < n.length; i++ ) {
            if( magazine.get(n[i]) == null) {
                // no such word in magazine
                return false;
            }
            else {
                int count = (int)magazine.get(n[i]);
                if( count < 1 ) {
                    // no more such word to use
                    return false;
                }
                // decrement it and put it back
                count--;
                magazine.put(n[i], count);
            }
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }

        if( canCreateNote(magazine, ransom) )
            System.out.println("Yes");
        else
            System.out.println("No");

        scanner.close();
    }
}
