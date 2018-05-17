import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isComplete is true if the node represents a word
        boolean isComplete;

        // save a "size" information, so we don't have re-count all potentials
        // THIS IS the KEY!!!! to improve performance
        int size;

        TrieNode(){
            isComplete = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    static TrieNode root;
    static int partialCount;

    static void insert(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode pCrawl = root;
        for(level=0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if( pCrawl.children[index] == null )
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
            pCrawl.size++;
        }
        pCrawl.isComplete = true;
    }

    // check if "word" exists in trie, as a complete word
    static int findPartials(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode pCrawl = root;
        for(level=0; level < length; level++) {
            index = word.charAt(level) - 'a';
            if( pCrawl.children[index] == null ) {
                return 0;
            }
            pCrawl = pCrawl.children[index];
        }

        // now need to look how many children this node has
        //
        // use "size", so we don't need to traverse every time
        return pCrawl.size;

        // partialCount = 0;
        // countPotentials(pCrawl);

        // return partialCount;
    }

    static void countPotentials(TrieNode here) {
        if( here!=null && here.isComplete ) {
            partialCount++;
        }

        for(int i=0; i < here.children.length; i++ ) {
            if( here.children[i] != null ) {
                countPotentials(here.children[i]);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        root = new TrieNode();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];

            if( "add".equalsIgnoreCase(op) ) {
                insert(contact);
            }
            else if( "find".equalsIgnoreCase(op) ) {
                System.out.println( findPartials(contact) );
            }
        }

        scanner.close();
    }
}
