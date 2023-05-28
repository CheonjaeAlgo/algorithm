class Node {
  constructor(item) {
    this.item = item;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  push(item) {
    const node = new Node(item)
    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.next = node;
    }

    this.tail = node;
    this.length += 1;
  }

  pop() {
    const popItem = this.head;
    this.head = this.head.next;
    this.length -= 1;
    return popItem.item;
  }
}
const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n");
const [N, M] = input.shift().split(' ').map(Number);
const [x1, y1, x2, y2] = input.shift().split(' ').map(Number);
let board = input.map(v => v.trim().split(''));




function solve() {

  let cnt = 1;
  let q = new Queue();
  let visited = Array.from(Array(N), () => Array(M).fill(false));
  const dx = [0, 0, -1, 1]
  const dy = [1, -1, 0, 0]


  q.push([x1 - 1, y1 - 1]);
  visited[x1 - 1][y1 - 1] = true;

  while (q.length > 0) {
    const friends = [];

    while (q.length > 0) {
      let [x, y] = q.pop();
      for (let j = 0; j < 4; j++) {
        const nx = x + dx[j]
        const ny = y + dy[j]
        if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
          if (board[nx][ny] == '1') {
            visited[nx][ny] = true;
            friends.push([nx, ny])
          } else if (board[nx][ny] == '0') {
            visited[nx][ny] = true;
            q.push([nx, ny])
          } else {
            return cnt;
          }
        }
      }
    }
    friends.forEach(v => {
      q.push([v[0], v[1]]);
    })
    cnt++;
  }
}

const x = solve();
console.log(x)
