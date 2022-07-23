// Input Format
// There is no input for this challenge.

// Output Format
// The perimeter method must return the polygon's perimeter using the side length array passed to the constructor.

// Explanation
// Consider the following code:
// // Create a polygon with side lengths 3, 4, and 5
// let triangle = new Polygon([3, 4, 5]);
// // Print the perimeter
// console.log(triangle.perimeter());
// When executed with a properly implemented Polygon class, this code should print the result of 3+4+5 =12.

/*
 * Implement a Polygon class with the following properties:
 * 1. A constructor that takes an array of integer side lengths.
 * 2. A 'perimeter' method that returns the sum of the Polygon's side lengths.
 */

class Polygon {
  constructor(array) {
      this.array = array
  }
  
  perimeter() {
      return this.array.reduce((acc,arr) => {
          return acc + arr
      },0)
  }
}

const rectangle = new Polygon([10, 20, 10, 20]);
const square = new Polygon([10, 10, 10, 10]);
const pentagon = new Polygon([10, 20, 30, 40, 43]);

console.log(rectangle.perimeter());
console.log(square.perimeter());
console.log(pentagon.perimeter());