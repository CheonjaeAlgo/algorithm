const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let [n, ...input] = fs.readFileSync(filePath).toString().trim().split("\r\n")
const [N, M] = n.split(" ").map(Number)
const map = []
for (let i = 0; i < N; i++) {
  map[i] = input[i].split("").map(Number)
}
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
const dx = [1, -1, 0, 0]
const dy = [0, 0, 1, -1]
function bfs(x, y) {
  const queue = new Queue()
  queue.add({ x: x, y: y })
  while (queue.size() !== 0) {
    const target = queue.popleft()
    for (let i = 0; i < 4; i++) {
      const nx = target.x + dx[i]
      const ny = target.y + dy[i]
      if (nx >= N || nx < 0 || ny >= M || ny < 0) {
        continue
      }
      if (map[nx][ny] !== 1) {
        continue
      }

      map[nx][ny] = map[target.x][target.y] + 1
      queue.add({ x: nx, y: ny })
    }
  }
  return map[N - 1][M - 1]
}
console.log(bfs(0, 0))
