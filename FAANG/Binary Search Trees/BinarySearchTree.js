// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// Example 1:
// Input: root = [2,1,3]
// Output: true

// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

const dfs = function(node, min, max) {
  if(node.val <= min || node.val >= max) return false;
  if(node.left) {
      if(!dfs(node.left, min, node.val)) return false;
  }
  if(node.right) {
      if(!dfs(node.right, node.val, max)) return false
  }
  return true;
}

const isValidBST = function(root) {
  if(!root) return true;
  return dfs(root, -Infinity, Infinity);
};

// ------- Code to generate our binary tree -------
class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  insert(values) {
    const queue = [this];
    let i = 0;
    while (queue.length > 0) {
      let current = queue.shift();
      for (let side of ["left", "right"]) {
        if (!current[side]) {
          if (values[i] !== null) {
            current[side] = new TreeNode(values[i]);
          }
          i++;
          if (i >= values.length) return this;
        }
        if (current[side]) queue.push(current[side]);
      }
    }
    return this;
  }
}//T: O(n), S: O(n)




// ------- Code to generate our binary tree -------

// ------- Solution -------

const dfs2 = function(node, min, max) {
    if(node.val <= min || node.val >= max) {
      return false;
    }
    
    if(node.left) {
      if(!dfs(node.left, min, node.val)){
        return false;
      };
    }
    
    if(node.right) {
      if(!dfs(node.right, node.val, max)) {
        return false;
      }
    }
    
    return true;
}

const isValidBST2 = function(root) {
    if(!root) return true;
    return dfs2(root, -Infinity, Infinity);
};