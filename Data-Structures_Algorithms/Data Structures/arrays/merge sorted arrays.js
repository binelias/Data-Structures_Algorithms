//input: mergeSortedArrays([0,3,4,31],[4,6,30])
//output: [0,3,4,4,6,30,31]

//One solution can be : we compare the corresponding elements of both arrays
//We add the smaller element to a new array and increment the index of the array from which the element was added.
//Again we compare the elements of both arrays and repeat the procedure until all the elements have been added.

function merge(arr1, arr2){
  const mergeArray = [];
  let arr1Item= arr1[0];
  let arr2Item= arr2[0];
  let i = 1;
  let j = 1;

  //Check input
  if(arr1.length === 0) {
    return arr2;
  }
  if(arr2.length === 0) {
    return arr1;
  }

  while(arr1Item || arr2Item) {//The loop runs until we reach the end of either of the arrays
    if(!arr2Item || arr1Item < arr2Item) {
      mergeArray.push(arr1Item);
      arr1Item = arr1[i];
      i++;
    } else {
      mergeArray.push(arr2Item);
      arr2Item = arr2[j];
      j++;
    }
  }
  return mergeArray;
}

mergeSortedArrays([0,3,4,31],[4,6,30])