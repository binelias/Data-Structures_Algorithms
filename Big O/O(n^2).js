// Log all pairs of array
array = ['a','b','c','d','e']

function log_all_pairs(array){
    // #There are nested for loops in this function but there is only one variable array. So we don't need two variables for the Big-O

    for (let i=0; i<array.length;i++) {//n*O(n)
        for (let j=0; j<array.length;j++) {//n*O(n)
            console.log(array[i], array[j]) //n*n*O(1)
        }
    }
} 
        
log_all_pairs(array)

// #Total time complexity of the log_all_pairs function =
// #O(n*n + n*n + n*n*1) = O(3n^2)
// #The constants can be safely ignored.
// #Therefore, O(3n^2) = O(n^2)

new_array = [1,2,3,4,5]
function console.log_numbers_then_pairs(numbers) {
    // #There are a total of three loops here but only one variable. So we need only variable for our Big-O notation

    console.log("The numbers are : "); //#O(1)
    numbers.forEach(function(number) {//#n*O(1)
        console.log(number); //#O(n)
    }); 


    console.log("The pairs are :") //#O(1)
    numbers.forEach(function(firstNumber) {//#n*O(n)
        numbers.forEach(function(secondNumber) {//#n*O(n)
            console.log(array[i], array[j]) //#n*n*O(1)
        });
    });      
}
console.log_numbers_then_pairs(new_array)

// #Total time complexity of the console.log_numbers_then_pairs function =
// #O(1 + n + n*1 + 1 + n*n + n*n + n*n*1) = O(3n^2 + 2n + 2)
// #Now, Big-O presents scalability of the cod, i.e., how the code will behave as the inputs grow larger and larger
// #Therefore if the expression contains terms of different degrees and the size of inputs is huge, the terms of the smaller degrees become negligible in comparison to those of the higher degrees
// #Therefore, we can ignore the terms of the smaller degrees and only keep the highest degree term
// #O(3n^2 + 2n + 2) = O(3n2)
// #The constants can be safely ignored.
// #Therefore, O(3n^2) = O(n^2)