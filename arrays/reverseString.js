//Function that reverses a string
//"Hi My name is Rayan" should be 
//"nayaR si eman yM iH"

function simple_reverse(str){
  //check input
  if (!str || str.lenght<2 || typeof str !== 'string') {
    return "Incorrect Input";
  }
  const backward_string = [];//convert it to an array
  const totalItems = str.length-1;
  for(let i = totalItems; i >=0; i--) {//The for loop runs from the last element to the first element of the original string
    backward_string.push(str[i]);//The characters of the original string are added to the new string
  }
  return console.log(backward_string.join('')); //The characters of the reversed array are joined to form a string
}
string = "Hi My name is Rayan"
simple_reverse(string)


//JS reverse builtin code
function reverse(str) {
  return console.log(str.split('').reverse().join(''))
}
string = "Hi My name is Rayan"
reverse(string)


//modern JS using split
const reverse2 =str => console.log(str.split('').reverse().join(''));
string = "Hi My name is Rayan"
reverse2(string)


//modern JS using spread operator
const reverse3 = str => console.log([...str].reverse().join(''));
string = "Hi My name is Rayan"
reverse3(string)