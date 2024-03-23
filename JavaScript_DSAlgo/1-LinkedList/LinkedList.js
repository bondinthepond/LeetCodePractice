class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

export class LinkedList {
  // constructor() {
  //   this.head = null;
  //   this.tail = null;
  //   this.legnth = 0;
  // }
  constructor(value) {
    const newNode = new Node(value);
    this.head = newNode;
    this.tail = this.head;
    this.length = 1;
  }

  /* Push
  create new node
  Point Last Node to it
  point Tail pointer to it
  inserting a node to an empty list  
  */

  push(value) {
    const newNode = new Node(value);

    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
    this.length++; //don't forget to ++ length
    return this;
  }

  pushWithoutTail(value) {
    const newNode = new Node(value);

    if (!this.head) {
      this.head = newNode;
    } else {
      let last = this.head;
      while (last.next != null) {
        //traversing to last child or finding tail, using only the head pointer
        last = last.next;
      }
      last.next = newNode;
      newNode.next = null;
    }
    return this;
  }

  /* Pop 
  3 cases - multiple item, 0 items, 1 item
  To solve - use 2 pointer - temp and pre - pre pointing to the previous element of temp

  */
  pop() {
    if (this.head == null) return undefined; //empty list

    //2 or more items
    let temp, pre;
    temp = this.head;
    pre = this.head;

    while (temp.next) {
      pre = temp;
      temp = temp.next;
    }
    this.tail = pre;
    this.tail.next = null;
    this.length--;
    if (this.length == 0) {
      this.head = null;
      this.tail = null;
    }
    return this;
  }

  /* Unshift
  create new node and add at the beginning 
  */
  unshift(value) {
    const newNode = new Node(value);
    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    this.length++;
    return this;
  }

  /* Shift 
Remove node from the beginning
*/
  shift() {
    if (this.head == null) {
      console.log("list empty");
    } else if (this.length == 1) {
      this.head = null;
      this.tail = null;
    } else {
      let temp;
      temp = this.head.next;
      this.head.next = null;
      this.head = temp;
      /* Alternative approach
      temp = this.head;
      this.head = this.head.next;
      temp.next = null
      */
    }
    this.length--;
    return this;
  }

  /* get */
  get(index) {
    if (index < 0 || index >= this.length) {
      console.log("Index Out of Bounds");
    } else {
      let temp = this.head;
      for (let i = 0; i < index; i++) {
        temp = temp.next;
      }
      return temp;
    }
  }

  /* Set the value at the index */
  set(index, value) {
    let tempNode = this.get(index);
    if (tempNode) {
      tempNode.value = value;
      console.log("Value has been set");
    }
    console.log("Value hasn't been set");
  }

  //create new node and add in the middle
  insert(index, value) {
    if (index === 0) {
      console.log("index is 0, this is unshift");
      return this.unshift(value);
    } else if (index == this.length) {
      console.log("index is the tail, this is push");
      return this.push(value);
    } else if (index < 0 || index >= this.length) {
      console.log("Index Out of Bounds");
      return false;
    } else {
      const newNode = new Node(value);

      let temp = this.get(index - 1);
      let nextToTemp = this.get(index);
      temp.next = newNode;
      newNode.next = nextToTemp;

      this.length++;
      return this;
    }
  }

  removeFrom(index) {
    if (index === 0) {
      console.log("index is 0, this is shift");
      return this.shift();
    } else if (index == this.length) {
      console.log("index is the tail, this is pop");
      return this.pop();
    } else if (index < 0 || index >= this.length) {
      console.log("Index Out of Bounds");
      return false;
    } else {
      let before = this.get(index - 1);
      let temp = before.next;

      before.next = temp.next;

      console.log("Removed Node " + temp.value);

      temp.next = null;
      this.length--;
      return this;
    }
  }

  traverseLinkedList() {
    let temp = this.head;
    const list_array = new Array();
    while (temp != null) {
      list_array.push(temp.value);
      temp = temp.next;
    }
    console.log(list_array);
  }

  reverseALinkedList() {
    let curr = this.head;
    // this.head = this.tail;  //with out using tail pointer
    // this.tail = curr;

    let before = null;
    let after = null;

    while (curr != null) {
      after = curr.next;
      curr.next = before;
      before = curr;
      curr = after;
    }
    this.head = before;
    return this;
  }
}

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

myLinkedList.reverseALinkedList();

myLinkedList.traverseLinkedList();

myLinkedList.pushWithoutTail(19);
myLinkedList.traverseLinkedList();
