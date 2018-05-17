// method 1 - use "prev" to hold the max(leftTree(n).value);
// perform in-order traversal, so "prev" represents the max of left tree so far,
// and should be less than current node
Node prev = null;
boolean checkBST1(Node root) {
    if(root == null )
        return true;

    // check entire left tree
    if( ! checkBST(root.left) )
        return false;

    // make sure prev.data < root.data, to be in order
    if( prev!= null && prev.data >= root.data )
        return false;

    // to this point, prev.data < root.data, which indicate valid
    // set prev to root, to increase the value for next recursion
    prev = root;

    if( ! checkBST(root.right)) {
        return false;
    }

    return true;
}

// method 2 - with two NULL pointers approach
// start from root, and walk down to left, right trees
boolean checkBST2(Node root, Node small, Node large) {
    if( root == null )
        return true;

    if( small != null && small.data > root.data )
        return false;
    if( large != null && root.data > large.data )
        return false;

    // left, right tree all need to be BST
    return checkBST2( root.left, small, root) && checkBST2( root.right, root, large);
}

boolean checkBST(Node root) {
    // return checkBST2(root, null, null);
    return checkBST1(root);
}
