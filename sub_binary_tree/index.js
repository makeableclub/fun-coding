
// Reference:
// https://coderbyte.com/algorithm/tree-traversal-algorithms
// https://coderbyte.com/algorithm/determine-if-binary-tree-is-subtree
//
// Determine if binary tree is a subtree of a larger binary tree
// The algorithm:
// To solve this problem in linear time, we will first produce the in-order and pre-order arrays for both trees, and then we will determine if the in-order and pre-order arrays of the first tree are contained somewhere within the arrays of the second tree.
// The reason the algorithm above works is because to uniquely identify a binary tree, an in-order and pre-order traversal is needed. So, because we are getting these traversal arrays for both trees, the last step will simply be to check if the smaller tree is contained in the larger one by checking their traversal arrays.
//
// in-order traversal in array format
function in_order(root, nodes) {
    if (root && root.left) {
        in_order(root.left, nodes);
    }
    nodes.push(root.data);
    if (root && root.right) {
        in_order(root.right, nodes);
    }
    return nodes;
}

// pre-order traversal in array format
function pre_order(root, nodes) {
    nodes.push(root.data);
    if (root && root.left) {
        pre_order(root.left, nodes);
    }
    if (root && root.right) {
        pre_order(root.right, nodes);
    }
    return nodes;
}

// function that takes two root nodes and determines if
// the first tree is a subtree of the second tree
function is_subtree(root, root_r) {

    // the variables below will hold the values:
    // 4-30-10-6
    // 4-30-10-6-26-3-3
    var inord1 = in_order(root, []).join('-');
    var inord2 = in_order(root_r, []).join('-');

    // 10-4-30-6
    // 26-10-4-30-6-3-3
    var preord1 = pre_order(root, []).join('-');
    var preord2 = pre_order(root_r, []).join('-');

    // check if the left tree is contained with the right tree
    return inord2.indexOf(inord1) !== -1 && preord2.indexOf(preord1) !== -1;

}

is_subtree(root, root_r); // => true
