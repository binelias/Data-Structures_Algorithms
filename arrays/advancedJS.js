
//reference type
let obj1= {value:10}; //undefined, put obj1 to box1
let obj2= obj1; //undefined, obj2 reference to obj1
let obj3 = {value:10}; //undefined, put obj3 to box3
obj1 === obj2; // true
obj1 === obj3; //false
obj1.value = 15; //15 overrides 10 in box1
obj2.value //15
obj3.value //10

const n1 = 1//immutable/primitive type


//context vs scope
//scope
function b() {
  let a = 4;
}
//context
console.log(this)//this is a window object
console.log(this === window)//true

function a() {
  console.log(this);
}
a()//window{....}

const obj4 = {
  a: function() {
    consolelog(this);
  }
}
obj4.a() //{a:f}

//Instantation, the new classical inheritance
class Player {
  constructor(name, type){
    console.log('Player', this);
    this.name = name;
    this.type = type;
  }
  introduce () {
    console.log(`Hi I am ${this.name}, I'm a ${this.type}`);
  }
}
class Wizard extends Player {
  constructor (name, type) {
    super(name, type)// to have acces to this properties of class Player
    console.log('Wizard', this);
  }
  play() {
    console.log(`Weee I'm a ${this.type}`);
  }
}

const wizard1 = new Wizard('Shelly', 'Healer');
const wizard2 = new Wizard('Shawn', 'Dark Magic');
wizard1.play()//Weee I'm a Healer
wizard1.introduce()//Hi I am Shelly, I'm a Healer
//Player > Wizard{}
//Wizard > Wizard{name:"Shawn", type:"Dark Magic"}
