const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let input = fs.readFileSync(filePath).toString().split("\r\n")

const N = Number(input[0])
let work = []
for (let i = 1; i < N + 1; i++) {
  work.push(input[i].toString().trim().split(" ").map(Number))
}

work.sort((a, b) => a[1] - b[1])

const WL = new Array(work[N - 1][1]).fill(false)
const algo = (a, b) => {
  if (a === 0 || b === 0) return
  if (WL[b - 1]) {
    b--
  } else {
    WL[b - 1] = true
    b--
    a--
  }
  algo(a, b)
}

for (let i = 0; i < N; i++) {
  algo(work[i][0], work[i][1])
}
let sum = []
let temp = 0
for (let i = 0; i < WL.length; i++) {
  if (WL[i]) {
    sum.push(temp)
    temp = 0
  } else {
    temp++
  }
}

console.log(Math.max.apply(null, sum))
