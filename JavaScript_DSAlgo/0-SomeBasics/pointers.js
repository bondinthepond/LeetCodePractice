let num1 = 10;
let num2 = num1;
console.log("Num1 " + num1 + " Num2 " + num2);

num1 = 15;
console.log("Num1 " + num1 + " Num2 " + num2);

// Num1 and Num2 don't point to same value

// Use pointers or object references

let obj1 = { value: 10 };
let obj2 = obj1;

console.log("Obj1 " + obj1.value + " Obj2 " + obj2.value);

obj2.value = 21;
console.log("Obj1 " + obj1.value + " Obj2 " + obj2.value);
