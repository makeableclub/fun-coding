/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    Node fast = head;
    Node slow = head;

    boolean cycled = false;

    // empty list, or single node list => no cycle
    if( head == null || head.next == null )
        return false;

    while( fast.next != null && fast.next.next != null ) {
        // start moving, and check them if fast catches up slow, if so, there is a cycle.
        slow = slow.next;
        fast = fast.next.next;
        if( slow == fast ) {
            cycled = true;
            break;
        }
    }
    // if cycled=true, it breaks out from loop
    // otherwise, fast pointer reaches to the end of linked list, and no cycle.

    return cycled;
}
