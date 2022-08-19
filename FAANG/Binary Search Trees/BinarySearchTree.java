public boolean isValidBST(TreeNode root) {
        
  if (root == null) return true;
  
  return checkForBst(root, -9999999999999.99,99999999999.99);
}

private  boolean checkForBst(TreeNode node, double min, double max) {
  // check for duplicates in the node value. BST should not have duplicate node values
  if(node.val<=min || node.val>=max) return false;


  if(node.left!=null){
      // traverse the left side of the tree. min param will always stay same for the left.
      // Max will be replaced with node.val for the right side.
      if(!checkForBst(node.left,min,node.val)) return false;

  }

  if(node.right!=null){
      // traverse the right side of the tree .
      // min param will be replaced by node.val
      // max will remain the same
      if(!checkForBst(node.right,node.val,max)) return false;
  }
  return true;
}