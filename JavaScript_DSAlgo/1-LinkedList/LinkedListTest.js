import { LinkedList } from "./1-LinkedList/LinkedList.js.js";

let myLinkedList = new LinkedList(10);
myLinkedList.push(7);
myLinkedList.push(4);
myLinkedList.pop();
myLinkedList.unshift(9);

myLinkedList.shift();

myLinkedList.push(7);
myLinkedList.push(4);
myLinkedList.unshift(9);

console.log(myLinkedList.get(3));
console.log(myLinkedList.set(3, 10));
console.log(myLinkedList.get(3));

myLinkedList.insert(4, 11);
myLinkedList.insert(0, 17);
myLinkedList.removeFrom(1);

myLinkedList.traverseLinkedList();

myLinkedList.reverseALinkedList();

myLinkedList.traverseLinkedList();

myLinkedList.reverseALinkedList();

myLinkedList.traverseLinkedList();
