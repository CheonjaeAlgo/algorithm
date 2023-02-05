const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let input = fs.readFileSync(filePath).toString().split("\n")

const [n, m, r] = input[0].split(" ").map((x) => +x)
const reward = input[1].split(" ").map((x) => +x)
const board = Array.from({ length: n + 1 }, () =>
  new Array(n + 1).fill(Infinity)
)
for (let i = 1; i <= n; i++) {
  board[i][i] = 0
}

for (let i = 2; i < 2 + r; i++) {
  const [a, b, w] = input[i].split(" ").map((x) => +x)
  board[a][b] = w
  board[b][a] = w
}

for (let k = 1; k <= n; k++) {
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
      board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j])
    }
  }
}
let max = 0
for (let i = 1; i <= n; i++) {
  let count = 0
  for (let j = 1; j <= n; j++) {
    if (board[i][j] <= m) count += reward[j - 1]
  }
  max = Math.max(max, count)
}
console.log(max)
