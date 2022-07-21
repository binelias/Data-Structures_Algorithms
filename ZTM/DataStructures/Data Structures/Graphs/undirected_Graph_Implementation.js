//Graphs are data structures which contain nodes or vertices, which are connected to each other through edges.
//Tress and Linked Lists are basically graphs having nodes and connections between the nodes.
//Now, graphs are primarily classified by three properties - Cyclic/Acyclic, Weighted/Unweighted/, Directed/Undirected Graphs
//There are many many applications of graphs and many opertions can be performed on them.
//A graph can be represented in 3 ways - Adjacency List, Adjacency Matrix, Edge List.
//Adjacency list stores the nodes with which a particular node is connected to in a linked list or array.
//All these lists or arrays can be stored in a hash table with the keys being the nodes and the values being their respective lists
//Adjcaency matrix is a nXn matrix where n is the number of nodes. M[i][j] = 1 if nodes i and j are connected otherwise 0
//Edge list contains all the pairs of nodes which are connected, and if the graph is weighted, then the weight of each edge as well


//Edge List
const graph = [[0,2], [2,3], [2,1], [1,3]];
//Adjacent List
const graph2 = [[2], [2,3], [0,1,3], [1,2]];
//Adjacent Matrix
const graph3 = [
  0: [0,0,1,0],
  1: [0,0,1,1],
  2: [1,1,0,1],
  3: [0,1,1,0]
]

//Here we will build an undirected graph using an adjacency list.
class Graph { 
  constructor() { 
    this.numberOfNodes = 0; 
    this.adjacentList = {}; 
  } 
  addVertex(node)  { 
    this.adjacentList[node] = [];//nodes/vertex
    this.numberOfNodes++;
  } 
  addEdge(node1, node2) { 
    //undirected Graph 
    this.adjacentList[node1].push(node2); //n1 connect to n2
    this.adjacentList[node2].push(node1); //n2 connect to n2
  } 
  showConnections() { 
    const allNodes = Object.keys(this.adjacentList); 
    for (let node of allNodes) { 
      let nodeConnections = this.adjacentList[node]; 
      let connections = ""; 
      let vertex;
      for (vertex of nodeConnections) {
        connections += vertex + " ";
      } 
      console.log(node + "-->" + connections); 
    } 
} 
} 

var myGraph = new Graph();
myGraph.addVertex('0');
myGraph.addVertex('1');
myGraph.addVertex('2');
myGraph.addVertex('3');
myGraph.addVertex('4');
myGraph.addVertex('5');
myGraph.addVertex('6');
myGraph.addEdge('3', '1'); 
myGraph.addEdge('3', '4'); 
myGraph.addEdge('4', '2'); 
myGraph.addEdge('4', '5'); 
myGraph.addEdge('1', '2'); 
myGraph.addEdge('1', '0'); 
myGraph.addEdge('0', '2'); 
myGraph.addEdge('6', '5');

myGraph.showConnections(); ; 

// 0-->1 2 
// 1-->3 2 0 
// 2-->4 1 0 
// 3-->1 4 
// 4-->3 2 5 
// 5-->4 6 
// 6-->5 
