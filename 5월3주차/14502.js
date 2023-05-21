const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
const input = fs.readFileSync(filePath).toString().trim().split("\n")
const [N, M] = input[0].split(" ").map(Number)
const map = Array.from({ length: N }, (_, i) => {
  input[i + 1].split(" ").map(Number)
})
let count = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => Array(4).fill(Infinity))
)

class Queue {
  constructor() {
    this.storage = {}
    this.front = 0
    this.rear = 0
  }
  size() {
    if (this.storage[this.rear] === undefined) {
      return 0
    } else {
      return this.rear - this.front + 1
    }
  }
  add(value) {
    if (this.size() === 0) {
      this.storage["0"] = value
    } else {
      this.rear += 1
      this.storage[this.rear] = value
    }
  }
  popleft() {
    let temp
    if (this.front === this.rear) {
      temp = this.storage[this.front]
      delete this.storage[this.front]
      this.front = 0
      this.rear = 0
    } else {
      temp = this.storage[this.front]
      delete this.storage[this.front]
      this.front += 1
    }
    return temp
  }
}

const Maxwall = 3
const dist = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
]
const isValidPos = (x, y) => x >= 0 && y >= 0 && x < N && y < M //맵을 넘어서면 안댐
function bfs(x, y, arr) {
  if (arr[x][y] === 1 || arr[x][y] === 0) return
}
