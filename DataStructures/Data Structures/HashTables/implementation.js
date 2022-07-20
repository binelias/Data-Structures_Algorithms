//Implement a hash table
class HashTable {
  constructor(size){
      this.data = new Array(size);//hold info for our bucket
  }

  _hash(key) {//hash func that generates hash for us,_ is a private property
    let hash = 0;
    for (let i =0; i < key.length; i++){
        hash = (hash + key.charCodeAt(i) * i) % this.data.length
    }
    return hash;
  }

  set(key, value) {
    let address = this._hash(key);// where key and value stored
    if (!this.data[address]) {//if shelf are empty
      this.data[address] = [];//add address data
    }
    this.data[address].push([key, value]);//add data to the shelf at next index inside of that array
    return this.data;
  }//O(1)

  get(key){
    const address = this._hash(key);// where key and value stored
    const currentBucket = this.data[address]//grab key and value
    if (currentBucket) {//if there's data
      for(let i = 0; i < currentBucket.length; i++){//check all data in hash
        if(currentBucket[i][0] === key) {//find key match
          return currentBucket[i][1]// return corresponding value
        }
      }
    }//O(1)
    return undefined;//no data in shelf
  }
}

const myHashTable = new HashTable(50);
myHashTable.set('grapes', 10000)
myHashTable.get('grapes')
myHashTable.set('apples', 9)
myHashTable.get('apples')


//Implement Keys
//iterate all keys
class HashTable {
  constructor(size){
    this.data = new Array(size);
    // this.data = [];
  }

  _hash(key) {
    let hash = 0;
    for (let i =0; i < key.length; i++){
        hash = (hash + key.charCodeAt(i) * i) % this.data.length
    }
    return hash;
  }

  set(key, value) {
    let address = this._hash(key);
    if (!this.data[address]) {
      this.data[address] = [];
    }
    this.data[address].push([key, value]);
    return this.data;
  }

  get(key){
    const address = this._hash(key);
    const currentBucket = this.data[address]
    if (currentBucket) {
      for(let i = 0; i < currentBucket.length; i++){
        if(currentBucket[i][0] === key) {
          return currentBucket[i][1]
        }
      }
    }
    return undefined;
  }
  
  keys(){
    const keysArray = [];
    for (let i = 0; i < this.data.length; i++){
      if(this.data[i]){
        keysArray.push(this.data[i][0][0])
      }
    }
    return keysArray;
  }// all 50 shelve of hashtable
}

const myHashTable2 = new HashTable(50);
myHashTable2.set('grapes', 10000)
myHashTable2.set('grapes', 10000)
myHashTable2.get('grapes')
myHashTable2.set('apples', 9)
myHashTable2.get('apples')
myHashTable2.keys()//output all keys in the hash map


//enhance the previous keys() method to also include hash collision prevention
class HashTable {
  constructor(size){
    this.data = new Array(size);
    // this.data = [];
  }

  _hash(key) {
    let hash = 0;
    for (let i =0; i < key.length; i++){
        hash = (hash + key.charCodeAt(i) * i) % this.data.length
    }
    return hash;
  }

  set(key, value) {
    let address = this._hash(key);
    if (!this.data[address]) {
      this.data[address] = [];
    }
    this.data[address].push([key, value]);
    return this.data;
  }

  get(key){
    const address = this._hash(key);
    const currentBucket = this.data[address]
    if (currentBucket) {
      for(let i = 0; i < currentBucket.length; i++){
        if(currentBucket[i][0] === key) {
          return currentBucket[i][1]
        }
      }
    }
    return undefined;
  }
  keys() {
    if (!this.data.length) {
      return undefined
    }
    let result = []
    // loop through all the elements
    for (let i = 0; i < this.data.length; i++) {
      // if it's not an empty memory cell
      if (this.data[i] && this.data[i].length) {
        // but also loop through all the potential collisions
        if (this.data.length > 1) {
          for (let j = 0; j < this.data[i].length; j++) {
            result.push(this.data[i][j][0])
          }
        } else {
          result.push(this.data[i][0])
        } 
      }
    }
    return result; 
  }
}

const myHashTable3 = new HashTable(50);
myHashTable3.set('grapes', 10000)
myHashTable3.set('grapes', 10000)
myHashTable3.get('grapes')
myHashTable3.set('apples', 9)
myHashTable3.get('apples')
myHashTable3.keys()//output all keys in the hash map
  