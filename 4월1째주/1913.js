const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"

const input = fs.readFileSync(filePath).toString().trim().split("\n")

const n = Number(input[0])
const a = Number(input[1])
let ax = 0,
  ay = 0
const map = Array.from(Array(n), () => new Array(n))

map[parseInt(n / 2)][parseInt(n / 2)] = 1

const dist = [
  [0, 1],
  [1, 0],
  [0, -1],
  [-1, 0],
]
let x = parseInt(n / 2)
let y = parseInt(n / 2)
let cnt = 2
let dno = 3
while (cnt <= n * n) {
  if (a === 1) {
    ax = parseInt(n / 2)
    ay = parseInt(n / 2)
  }
  if (cnt > n * n) break
  let flagcount = 0
  for (let i = 0; i < 4; i++) {
    const nx = x + dist[i][0]
    const ny = y + dist[i][1]
    if (nx < 0 || nx === n || ny < 0 || ny === n) continue
    if (map[nx][ny] !== undefined) flagcount++
  }
  if (flagcount === 1) {
    dno = (dno + 1) % 4
  }

  x = x + dist[dno][0]
  y = y + dist[dno][1]
  map[x][y] = cnt
  if (cnt === a) {
    ax = x
    ay = y
  }
  cnt++
}
function traverse2dArray2(arr) {
  arr.forEach((rowArray) => {
    let row = ""

    rowArray.forEach((column) => {
      row += column + " "
    })

    console.log(row)
  })
}
traverse2dArray2(map)
console.log(ax + 1, ay + 1)
