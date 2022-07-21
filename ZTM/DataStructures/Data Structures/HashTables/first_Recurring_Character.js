//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined

//naive approach
function firstRecurringCharacter(input) {
  for (let i = 0; i < input.length; i++) {
  for (let j = i + 1; j < input.length; j++) {//start one to the right of i
    if(input[i] === input[j]) {
      return input[i];
    }
  }
  }
  return undefined
}//O(n^2)
firstRecurringCharacter([2,5,1,2,3,5,1,2,4])

//improved version
function firstRecurringCharacter2(input) {
  let map = {};//hash table or object
  for (let i = 0; i < input.length; i++) {//all value are stored one by one to map
    if (map[input[i]] !== undefined) {
      return input[i]
    } else {
      map[input[i]] = i;//storing value to map
    }
  }
  return undefined
}//O(n)

firstRecurringCharacter2([2,5,5,2,3,5,1,2,4])


//Bonus... What if we had this:
// [2,5,5,2,3,5,1,2,4]
// return 5 because the pairs are before 2,2