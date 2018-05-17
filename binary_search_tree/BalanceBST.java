// Java program to print BST in given range

// A binary tree node
class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree {

    static Node root;

    static ArrayList<Integer> arrList = new ArrayList<Integer>();

    /**
     * In-order traversal to produce an arraylist of properly sorted data
     */
    void BSTToSortedArray(Node root) {
        if( root == null ) return;

        // in-order traversals
        BSTToSortedArray(root.left);
        arrList.push(root.data);
        BSTToSortedArray(root.right);
    }

    /* A function that constructs BALANCED Binary Search Tree
     from a sorted array */
    Node sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    // Instead of sorted ArrayList which can access to any element in the list,
    // how about sorted LinkedList?
         /**
            Top root -> bottom leaf approach

             1) Get the Middle of the linked list and make it root.
             2) Recursively do same for left half and right half.
                    a) Get the middle of left half and make it left child of the root
                       created in step 1.
                    b) Get the middle of right half and make it right child of the
                       root created in step 1.

             Time complexity: O(nLogn) where n is the number of nodes in Linked List.
          */

    /* head node of link list */
    static LNode head;

    /* Link list Node */
    class LNode
    {
        int data;
        LNode next, prev;

        LNode(int d)
        {
            data = d;
            next = prev = null;
        }
    }

    int countNodes(LNode head)
    {
        int count = 0;
        LNode temp = head;
        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    /* This function counts the number of nodes in Linked List
        and then calls sortedListToBSTRecur() to construct BST */
     Node sortedLinkedListToBST()
     {
         /*Count the number of nodes in Linked List */
         int n = countNodes(head);

         /* Construct BST */
         return sortedLinkedListToBSTRecur(n);
     }


     /*
        Improved version: O(n)
        The main function that constructs balanced BST and returns root of it.
        The idea is to insert nodes in BST in the same order as the appear in Linked List,
        so that the tree can be constructed in O(n) time complexity

        n  --> No. of nodes in the Doubly Linked List */
     Node sortedLinkedListToBSTRecur(int n)
     {
         /* Base Case */
         if (n <= 0)
             return null;

         /* Recursively construct the left subtree */
         Node left = sortedLinkedListToBSTRecur(n / 2);

         /* head_ref now refers to middle node,
            make middle node as root of BST*/
         Node root = new Node(head.data);

         // Set pointer to left subtree
         root.left = left;

         /* Change head pointer of Linked List for parent
            recursive calls */
         head = head.next;

         /* Recursively construct the right subtree and link it
            with root. The number of nodes in right subtree  is
            total nodes - nodes in left subtree - 1 (for root) */
         root.right = sortedLinkedListToBSTRecur(n - n / 2 - 1);

         return root;
     }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }
}

// This code has been contributed by Mayank Jaiswal
