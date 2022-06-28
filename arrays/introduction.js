// #Arrays are one of the most commonly-used data structures
// #The elements of an array are stored in contiguous memory locations
// #Arrays are of two types : Static and Dynamic
// #Static arrays have fixed, pre-defined amount of memory that they can use, whereas in dynamic arrays this is flexible
// #In JS we only have dynamic arrays

const strings = ['a', 'b', 'c', 'd'];
//4*4 = 16bytes storage

//lookup/access, O(1)
strings[2]; 

//push/add e at the end of array, O(1)
strings.push('e');

//push x at begin of array, O(n)
strings.unshift('x')

//delete end value, O(1)
strings.pop();

//splice, O(n)
strings.splice(2, 0, 'alien');


