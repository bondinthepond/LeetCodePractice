class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
    this.prev = null;
  }
}

export class DoublyLinkedLists {
  constructor(value) {
    const newNode = new Node(value);
    this.head = newNode;
    this.tail = newNode;
    this.length = 1;
  }

  push(value) {}

  pop() {}

  unshift(value) {}

  shift() {}

  traverse() {}

  get(index) {}

  set(index, value) {}

  insertAt(index, value) {}

  removeAt(index, value) {}

  reverse() {}
}
