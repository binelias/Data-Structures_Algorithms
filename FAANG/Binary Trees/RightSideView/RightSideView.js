// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,null,3]
// Output: [1,3]

// Example 3:
// Input: root = []
// Output: []

//BFS soln
const rightSideView = function(root) {
  if(!root) return [];
  const res = [];
  let queue= [root];
  
  while(queue.length) {
      let length = queue.length, count = 0, currNode;
      
      while(count < length) {
          currNode = queue.shift();
          if(currNode.left) queue.push(currNode.left);
          if(currNode.right) queue.push(currNode.right);
          count++;
      }
      res.push(currNode.val);
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

const tree = new TreeNode(1);
tree.insert([2,3,4,5,null,6,null,7,null,null,null,null,8,null,null,null]);
// ------- Code to generate our binary tree -------

// ------- Our Solution -------
const rightSideViewBFS = function(root) {  
  if(!root) return [];
  const result = [];
  let queue = [root];
    
  while(queue.length) {
    let length = queue.length, count = 0, currentNode;

    while(count < length) {
      currentNode = queue.shift();
      
      if(currentNode.left) {
        queue.push(currentNode.left);
      }
      
      if(currentNode.right) {
        queue.push(currentNode.right);
      }
      
      count++;
    }

    result.push(currentNode.value)
  }

  return result;
};

console.log(rightSideViewBFS(tree))


//DFS
const dfs = (root, currLvl, res) => {
  if(!root) return;
  if(currLvl >= res.length) res.push(root.val);
  if(root.right) dfs(root.right, currLvl + 1, res);
  if(root.left) dfs(root.left,currLvl + 1, res);
}
const rightSideView = function(root) {
  const res = [];
  
  dfs(root, 0, res);
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

const tree = new TreeNode(1);
tree.insert([2,3,4,5,null,6,null,7,null,null,null,null,8,null,null,null]);
// ------- Code to generate our binary tree -------

// ------- Our Solution -------
const dfs = (node, currentLevel, result) => {
  if(!node) return;
  if(currentLevel >= result.length) {
    result.push(node.value);
  }

  if(node.right) {
    dfs(node.right, currentLevel + 1, result);
  }
  
  if(node.left) {
    dfs(node.left, currentLevel + 1, result);
  }
}

const rightSideViewDFS = function(root) {
  const result = [];
  
  dfs(root, 0, result);
  return result;
};

console.log(rightSideViewDFS(tree))

