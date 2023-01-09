const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let input = fs.readFileSync(filePath).toString().trim().split("\r\n")
const M = input.length
const N = input[0].length

const map = []
for (let i = 0; i < M; i++) {
  map[i] = input[i].split("")
}

const visited = Array.from(Array(M), () => new Array(N).fill(false))

let cnt = 0
const dist = [
  [0, 1],
  [0, -1],
  [1, 0],
  [-1, 0],
]
const isValidPos = (x, y) => x >= 0 && y >= 0 && x < N && y < M
function dfs(x, y) {
  if (isValidPos(x, y) === false) return false
  if (!visited[y][x] && map[y][x] == 0) {
    visited[y][x] = true
    for (let i = 0; i < 4; i++) {
      let nx = x + dist[i][0]
      let ny = y + dist[i][1]
      dfs(nx, ny)
    }
    return true
  }
  return false
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (dfs(i, j)) {
      cnt++
    }
  }
}
console.log(cnt)
