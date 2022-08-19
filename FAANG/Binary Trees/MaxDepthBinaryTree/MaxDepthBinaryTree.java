package FAANG.Binary Trees.MaxDepthBinaryTree;

public class MaxDepthBinaryTree {
  
  class BNode {

    public int value;
    public BNode left;
    public BNode right ;

    public BNode(int value,BNode left,BNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
  }
  public static int maxDepth(BNode node, int currentDepth){
    if (node == null ) return  currentDepth;
    currentDepth++;
    return  Math.max(maxDepth(node.left, currentDepth),
            maxDepth(node.right,currentDepth));
  }

  public BNode buildTree(int[] arr, int rootIndex) {
      BNode root = null ;
      // Base case for recursion
      if(rootIndex<arr.length){
          root = new BNode(arr[rootIndex]);
          root.left = buildTree(arr,(2*rootIndex)+1);
          root.right = buildTree(arr,(2*rootIndex)+2);
      }
      return root;
  }
  public  void printTree(BNode root){
      if(root!=null){
          printTree(root.left);
          System.out.print(root.value+" ");
          printTree(root.right);
      }
  }

  public static void main(String[] args) {
      int[] array = new int[]{1,2,3,4,5,6};
      DepthOfBinaryTree depthOfBinaryTree = new DepthOfBinaryTree();
      BNode btree = depthOfBinaryTree.buildTree(array,0);
    depthOfBinaryTree.printTree(btree);
    System.out.println("\n Max depth of the tree is "+ depthOfBinaryTree.maxDepth(btree,0));

  }
}


