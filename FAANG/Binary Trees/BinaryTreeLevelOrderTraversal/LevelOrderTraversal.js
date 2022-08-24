// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

const levelOrder = function(root) {
  if(!root) return [];
  const res = [];
  const queue = [root];
  
  while(queue.length) {
      const currLvlVal = [];
      const length = queue.length;
      
      for(let i = 0; i< length; i++) {
          const currNode = queue.shift();
          currLvlVal.push(currNode.val);
          
          if(currNode.left) queue.push(currNode.left);
          if(currNode.right) queue.push(currNode.right);
      }
      res.push(currLvlVal);
  }
  return res;
};//T: O(n), S: O(n)


/*
NOTE: The beginning portion builds our test case binary tree. Scroll down to the section titled Our Solution for the code solution!
 */

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
}

const tree = new TreeNode(3);
tree.insert([6,1,9,2,null,4,null,5,null,null,null,null,8,null,null,null]);
// ------- Code to generate our binary tree -------

// ------- Our Solution -------
const levelOrder2 = function(root) {
  if(!root) return [];
  const result = [];
  const queue = [root];
  
  while(queue.length) {
    const currentLevelValues = [];
    let length = queue.length, count = 0;

    while(count < length) {
      const currentNode = queue.shift();
      
      currentLevelValues.push(currentNode.value);
      
      if(currentNode.left) {
        queue.push(currentNode.left)
      }
      
      if(currentNode.right) {
        queue.push(currentNode.right)
      }

      count++;
    }
    
    result.push(currentLevelValues);
  }
  
  return result;
};

console.log(levelOrder2(tree))