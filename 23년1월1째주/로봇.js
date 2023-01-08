const fs = require("fs")

const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"

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

const input = fs.readFileSync(filePath).toString().trim().split("\n")
const [N, M] = input[0].split(" ").map(Number)
const map = Array.from({ length: N }, (_, i) =>
  input[i + 1].split(" ").map(Number)
)
let count = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => Array(4).fill(Infinity))
)
const start = input[N + 1].split(" ").map((num) => +num - 1)
const end = input[N + 2].split(" ").map((num) => +num - 1)
//console.log(start,end);
const dy = [0, 0, 1, -1]
const dx = [1, -1, 0, 0]
const isValidPos = (y, x) => y >= 0 && x >= 0 && y < N && x < M //맵을 넘어서면 안댐
const bfs = (start, end) => {
  const [sy, sx, sDir] = start //yx방향
  const [ey, ex, eDir] = end //yx방향
  count[sy][sx][sDir] = 0
  let queue = new Queue()
  queue.add([sy, sx, sDir, 0]) //[[sy, sx, sDir, 0]]

  while (queue.size()) {
    const [y, x, dir, time] = queue.popleft()
    if (y === ey && x === ex && dir === eDir) return console.log(time)
    let [ny, nx] = [y + dy[dir], x + dx[dir]]

    let k = 3
    while (k-- && isValidPos(ny, nx) && map[ny][nx] !== 1) {
      if (count[ny][nx][dir] > time + 1) {
        queue.add([ny, nx, dir, time + 1])
        count[ny][nx][dir] = time + 1
        // console.log(ny,nx,time);
      }
      ny += dy[dir]
      nx += dx[dir]
    }
    if (dir <= 1) {
      for (let i = 2; i < 4; i++) {
        if (count[y][x][i] > time + 1) {
          queue.add([y, x, i, time + 1])
          count[y][x][i] = time + 1
        }
      }
    } else {
      for (let i = 0; i < 2; i++) {
        if (count[y][x][i] > time + 1) {
          queue.add([y, x, i, time + 1])
          count[y][x][i] = time + 1
        }
      }
    }
  }
}
bfs(start, end)
