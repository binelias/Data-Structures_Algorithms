//Binary Search Trees are a non-linear data structure.
//They consist of a root node and zero, one or two children where the children can again have 0,1, or 2 nodes as their children and so on
//In most cases, the time complexity of operations on a BST, which include, lookups, insertions and deletions, take O(log N) time
//Except for the worst case, where the tree is heavily unbalanced with all the nodes being on one side of the tree.
//In that case, it basically becomes a linked list and the time complexities go up to O(n)

//simple binary tree
function SimpleBinaryTreeNode(value) {
  this.value = value;
  this.left = null;
  thir.right = null;
}


//Lets implement a Binary Search Tree first
//We will need a node class to store information about each node
//It will store the data and the pointers to its left and right children

class Node {
  constructor(value){
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

class BinarySearchTree {
  constructor(){
    this.root = null;
  }
  insert(value){
    const newNode = new Node(value);//create node
    if (this.root === null) {
      this.root = newNode;
    } else {
      let currentNode = this.root;
      while(true){
        if(value < currentNode.value){
          //Go left
          if(!currentNode.left){//no node in left
            currentNode.left = newNode;
            return this;//exit loop
          }
          currentNode = currentNode.left;
        } else {
          //Go right
          if(!currentNode.right){//no node in right
            currentNode.right = newNode;
            return this;//exit loop
          } 
          currentNode = currentNode.right;
        }
      }
    }
  }
  lookup(value){
    if (!this.root) {
      return false;
    }
    let currentNode = this.root;
    while(currentNode){
      if(value < currentNode.value){//left
        currentNode = currentNode.left;
      } else if(value > currentNode.value){//right
        currentNode = currentNode.right;
      } else if (currentNode.value === value) {//match
        return currentNode;//return match
      }
    }
    return null//no match found
  }
  remove(value) {
    if (!this.root) {//check if there's root
      return false;
    }
    let currentNode = this.root;
    let parentNode = null;//parent node before value
    while(currentNode){
      if(value < currentNode.value){//left
        parentNode = currentNode;
        currentNode = currentNode.left;
      } else if(value > currentNode.value){//right
        parentNode = currentNode;
        currentNode = currentNode.right;
      } else if (currentNode.value === value) {
        //We have a match, get to work!
        
        //Option 1: No right child: 
        if (currentNode.right === null) {
          if (parentNode === null) {
            this.root = currentNode.left;
          } else {
            //if parent > current value, make current left child a child of parent
            if(currentNode.value < parentNode.value) {
              parentNode.left = currentNode.left;
            //if parent < current value, make left child a right child of parent
            } else if(currentNode.value > parentNode.value) {
              parentNode.right = currentNode.left;
            }
          }
        //Option 2: Right child which doesnt have a left child
        } else if (currentNode.right.left === null) {
          currentNode.right.left = currentNode.left;
          if(parentNode === null) {
            this.root = currentNode.right;
          } else {
            
            //if parent > current, make right child of the left the parent
            if(currentNode.value < parentNode.value) {
              parentNode.left = currentNode.right;
            
            //if parent < current, make right child a right child of the parent
            } else if (currentNode.value > parentNode.value) {
              parentNode.right = currentNode.right;
            }
          }
        //Option 3: Right child that has a left child
        } else {
          //find the Right child's left most child
          let leftmost = currentNode.right.left;
          let leftmostParent = currentNode.right;
          while(leftmost.left !== null) {
            leftmostParent = leftmost;
            leftmost = leftmost.left;
          }
          //Parent's left subtree is now leftmost's right subtree
          leftmostParent.left = leftmost.right;
          leftmost.left = currentNode.left;
          leftmost.right = currentNode.right;

          if(parentNode === null) {
            this.root = leftmost;
          } else {
            if(currentNode.value < parentNode.value) {
              parentNode.left = leftmost;
            } else if(currentNode.value > parentNode.value) {
              parentNode.right = leftmost;
            }
          }
        }
      return true;
      }
    }
  }
}

const tree = new BinarySearchTree();
tree.insert(9)
tree.insert(4)
tree.insert(6)
tree.insert(20)
tree.insert(170)
tree.insert(15)
tree.insert(1)
// JSON.stringify(traverse(tree.root))
// console.log(tree.root)
tree.lookup(15);//Node {left: null, right: null, value: 15}
tree.lookup(7);//null
tree.remove(170)
JSON.stringify(traverse(tree.root))

//     9
//  4     20
//1  6  15  170

function traverse(node) {
  const tree = { value: node.value };
  tree.left = node.left === null ? null : traverse(node.left);
  tree.right = node.right === null ? null : traverse(node.right);
  return tree;
}