const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let input = fs.readFileSync(filePath).toString().split("\n")
let a = new Map()
for (let i = 0, sibal = Number(input.shift()); i < sibal; i++) {
  for (let j = 0; j < input[i].length; j++) {
    if (a.has(input[i][j])) {
      a.set(
        input[i][j],
        a.get(input[i][j]) + Math.pow(10, input[i].length - j - 1)
      )
    } else {
      a.set(input[i][j], Math.pow(10, input[i].length - j - 1))
    }
  }
}

let answer = 0

for (let i = 9; i > -1; i--) {
  if (a.size == 0) break
  answer =
    answer +
    a.get([...a.entries()].reduce((a, b) => (a[1] > b[1] ? a : b))[0]) * i
  a.delete([...a.entries()].reduce((a, b) => (a[1] > b[1] ? a : b))[0])
}

console.log(answer)
